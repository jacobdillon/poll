package com.jad340.projects.poll.service

import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import org.springframework.http.ResponseEntity

interface PollService {

    List<Token> createPoll(Poll poll)

    ResponseEntity deletePoll(Token token)

    ResponseEntity<Poll> getPoll(Token token)

    ResponseEntity setName(Token token, String string)

    ResponseEntity setDescription(Token token, String string)
}