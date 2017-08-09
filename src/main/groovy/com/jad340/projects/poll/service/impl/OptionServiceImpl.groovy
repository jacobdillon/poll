package com.jad340.projects.poll.service.impl

import com.jad340.projects.poll.domain.Option
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.mapper.OptionMapper
import com.jad340.projects.poll.service.OptionService
import com.jad340.projects.poll.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OptionServiceImpl implements OptionService {

    OptionMapper optionMapper
    TokenService tokenService

    @Autowired
    TokenServiceImpl(OptionMapper optionMapper, TokenService tokenService) {
        this.optionMapper = optionMapper
        this.tokenService = tokenService
    }

    void createOption(Option option, int pollId) {
        optionMapper.createOption(option, pollId)
    }

    List<Option> getOptions(int pollId) {
        optionMapper.getOptions(pollId)
    }

    ResponseEntity vote(Token token, Option option) {
        if(tokenService.checkExists(token)) {
            optionMapper.vote(option, tokenService.getPollId(token))
            new ResponseEntity(HttpStatus.ACCEPTED)
        } else {
            new ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    ResponseEntity addOption(Token token, Option option) {
        if(tokenService.checkExists(token)) {
            if(tokenService.isAdmin(token)) {
                optionMapper.createOption(option, tokenService.getPollId(token))
                new ResponseEntity(HttpStatus.CREATED)
            } else {
                new ResponseEntity(HttpStatus.FORBIDDEN)
            }
        } else {
            new ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
