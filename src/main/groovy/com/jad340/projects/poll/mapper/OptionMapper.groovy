package com.jad340.projects.poll.mapper

import com.jad340.projects.poll.domain.Option
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Component

@Mapper
@Component
interface OptionMapper {

    @Insert("INSERT INTO poll.options (poll_id, name) VALUES (#{pollId}, #{option.name})")
    int createOption(@Param("option") Option option, @Param("pollId") int pollId)

    @Select("SELECT * FROM poll.options WHERE poll_id = #{pollId}")
    List<Option> getOptions(@Param("pollId") int pollId)

    @Update("UPDATE poll.options SET votes = votes + 1 WHERE poll_id = #{pollId} AND name = #{option.name}")
    void vote(@Param("option") Option option, @Param("pollId") int pollId)

    @Delete("DELETE FROM poll.options WHERE name = #{option.name} AND poll_id = #{pollId}")
    void deleteOption(@Param("option") Option option, @Param("pollId") int pollId)
}