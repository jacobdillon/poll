package com.jad340.projects.poll.controller.impl

import com.jad340.projects.poll.controller.OptionController
import com.jad340.projects.poll.domain.view.TokenOption
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
    ResponseEntity vote(@RequestBody TokenOption tokenOption) {
        optionService.vote(tokenOption.token, tokenOption.option)
    }

    @RequestMapping(value = "/api/addOption", method = RequestMethod.POST)
    ResponseEntity addOption(@RequestBody TokenOption tokenOption) {
        optionService.addOption(tokenOption.token, tokenOption.option)
    }

    @RequestMapping(value = "/api/deleteOption", method = RequestMethod.POST)
    ResponseEntity deleteOption(@RequestBody TokenOption tokenOption) {
        optionService.deleteOption(tokenOption.token, tokenOption.option)
    }
}
