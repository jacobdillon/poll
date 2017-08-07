package com.jad340.projects.poll.mapper

import com.jad340.projects.poll.domain.Token
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component
interface TokenMapper {

    @Select("SELECT EXISTS(SELECT 1 FROM poll.tokens WHERE token = #{token.token})")
    boolean checkExists(@Param("token") Token token)

    @Insert("INSERT INTO poll.tokens (poll_id, token, isAdmin) \
            VALUES (#{pollId}, #{token.token}, #{token.isAdmin})")
    int addToken(@Param("token") Token token, @Param("pollId") int pollId)

    @Select("SELECT EXISTS(SELECT 1 FROM poll.tokens WHERE token = #{token.token} AND isAdmin = 1)")
    boolean isAdmin(@Param("token") Token token)

    @Select("SELECT poll_id FROM poll.tokens WHERE token = #{token.token}")
    int getPollId(@Param("token") Token token)
}