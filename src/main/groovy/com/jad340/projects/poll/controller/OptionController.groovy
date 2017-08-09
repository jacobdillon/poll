package com.jad340.projects.poll.controller

import com.jad340.projects.poll.domain.view.TokenOption
import org.springframework.http.ResponseEntity

interface OptionController {

    ResponseEntity vote(TokenOption tokenOption)

    ResponseEntity addOption(TokenOption tokenOption)

    ResponseEntity deleteOption(TokenOption tokenOption)
}