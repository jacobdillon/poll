package com.jad340.projects.poll.controller.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.jad340.projects.poll.controller.OptionController
import com.jad340.projects.poll.domain.Option
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.service.OptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class OptionControllerImpl implements OptionController {

    OptionService optionService

    @Autowired
    OptionServiceImpl(OptionService optionService) {
        this.optionService = optionService
    }

    @RequestMapping(value = "/api/vote", method = RequestMethod.POST)
    ResponseEntity vote(@RequestBody String tokenOption) {
        def objectMapper = new ObjectMapper()
        def jsonNode = objectMapper.readTree(tokenOption)

        def token = objectMapper.convertValue(jsonNode.get("token"), Token)
        def option = objectMapper.convertValue(jsonNode.get("option"), Option)

        optionService.vote(token, option)
    }
}
