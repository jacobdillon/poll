package com.jad340.projects.poll.service.impl

import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.mapper.PollMapper
import com.jad340.projects.poll.service.OptionService
import com.jad340.projects.poll.service.PollService
import com.jad340.projects.poll.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

import java.sql.Timestamp

@Service
class PollServiceImpl implements PollService {

    PollMapper pollMapper
    TokenService tokenService
    OptionService optionService

    @Autowired
    PollServiceImpl(PollMapper pollMapper, TokenService tokenService, OptionService optionService) {
        this.pollMapper = pollMapper
        this.tokenService = tokenService
        this.optionService = optionService
    }

    List<Token> createPoll(Poll poll) {
        poll.createdTime = new Timestamp(System.currentTimeMillis())
        pollMapper.createPoll(poll)
        for(option in poll.options) {
            optionService.createOption(option, poll.id)
        }
        tokenService.createToken(poll)
    }

    ResponseEntity deletePoll(Token token) {
        if(tokenService.checkExists(token)) {
            if(tokenService.isAdmin(token)) {
                pollMapper.deletePoll(tokenService.getPollId(token))
                new ResponseEntity(HttpStatus.OK)
            } else {
                new ResponseEntity(HttpStatus.FORBIDDEN)
            }
        } else {
            new ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    ResponseEntity<Poll> getPoll(Token token) {
        if(tokenService.checkExists(token)) {
            def poll = pollMapper.getPoll(tokenService.getPollId(token))
            poll.options = optionService.getOptions(poll.id)
            new ResponseEntity<>(poll, HttpStatus.OK)
        } else {
            new ResponseEntity<>(HttpStatus.NOT_FOUND)
        }
    }
}
