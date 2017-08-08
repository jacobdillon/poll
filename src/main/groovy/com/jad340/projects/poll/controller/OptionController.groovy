package com.jad340.projects.poll.controller

import com.jad340.projects.poll.domain.Option
import com.jad340.projects.poll.domain.Token
import org.springframework.http.ResponseEntity

interface OptionController {

    ResponseEntity vote(String tokenOption)
}