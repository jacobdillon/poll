package com.jad340.projects.poll.service

import com.jad340.projects.poll.domain.Option

interface OptionService {

    void createOption(Option option, int pollId)
}