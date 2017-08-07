package com.jad340.projects.poll.service.impl

import com.jad340.projects.poll.domain.Option
import com.jad340.projects.poll.mapper.OptionMapper
import com.jad340.projects.poll.service.OptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OptionServiceImpl implements OptionService {

    OptionMapper optionMapper

    @Autowired
    TokenServiceImpl(OptionMapper optionMapper) {
        this.optionMapper = optionMapper
    }

    void createOption(Option option, int pollId) {
        optionMapper.createOption(option, pollId)
    }
}
