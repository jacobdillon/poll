package com.jad340.projects.poll.mapper

import com.jad340.projects.poll.domain.Poll
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Component

@Mapper
@Component
interface PollMapper {

    @Insert("INSERT INTO poll.polls (name, description, created_time, expires_time) \
            VALUES (#{poll.name}, #{poll.description}, #{poll.createdTime}, #{poll.expiresTime})")
    @Options(useGeneratedKeys = true, keyProperty = "poll.id")
    int createPoll(@Param("poll") Poll poll)

    @Delete("DELETE FROM poll.polls WHERE id = #{pollId}")
    void deletePoll(@Param("pollId") int pollId)
}