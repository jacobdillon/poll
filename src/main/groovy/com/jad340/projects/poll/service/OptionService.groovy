package com.jad340.projects.poll.service

import com.jad340.projects.poll.domain.Option
import com.jad340.projects.poll.domain.Token
import org.springframework.http.ResponseEntity

interface OptionService {

    void createOption(Option option, int pollId)

    List<Option> getOptions(int pollId)

    ResponseEntity vote(Token token, Option option)
}