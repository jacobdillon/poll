package com.jad340.projects.poll.mapper

import com.jad340.projects.poll.domain.Option
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Component

@Mapper
@Component
interface OptionMapper {

    @Insert("INSERT INTO poll.options (poll_id, name) VALUES (#{pollId}, #{option.name})")
    int createOption(@Param("option") Option option, @Param("pollId") int pollId)
}