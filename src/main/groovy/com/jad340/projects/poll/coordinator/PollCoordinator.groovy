package com.jad340.projects.poll.coordinator

import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import org.springframework.http.ResponseEntity

interface PollCoordinator {

    ResponseEntity<List<Token>> createPoll(Poll poll)

    ResponseEntity deletePoll(Token adminToken)
}