package com.jad340.projects.poll.mapper

import com.jad340.projects.poll.domain.Poll
import org.apache.ibatis.annotations.*
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

    @Select("SELECT * FROM poll.polls WHERE id = #{pollId}")
    @Results([
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "expiresTime", column = "expires_time")
    ])
    Poll getPoll(@Param("pollId") int pollId)

    @Update("UPDATE poll.polls SET name = #{poll.name}, description = #{poll.description} WHERE id = #{poll.id}")
    void updatePoll(@Param("poll") Poll poll)
}