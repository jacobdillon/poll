package com.jad340.projects.poll.controller.impl

import com.jad340.projects.poll.controller.PollController
import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.service.PollService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class PollControllerImpl implements PollController {

    PollService pollService

    @Autowired
    PollControllerImpl(PollService pollService) {
        this.pollService = pollService
    }

    @RequestMapping(value = "/api/createPoll", method = RequestMethod.POST)
    ResponseEntity<List<Token>> createPoll(@RequestBody Poll poll) {
        new ResponseEntity<>(pollService.createPoll(poll), HttpStatus.CREATED)
    }

    @RequestMapping(value = "/api/deletePoll", method = RequestMethod.POST)
    ResponseEntity deletePoll(@RequestBody Token adminToken) {
        pollService.deletePoll(adminToken)
    }
}
