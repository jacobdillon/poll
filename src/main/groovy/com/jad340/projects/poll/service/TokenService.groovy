package com.jad340.projects.poll.service

import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token

interface TokenService {

    List<Token> createToken(Poll poll)

    boolean checkExists(Token token)

    boolean isAdmin(Token token)

    int getPollId(Token token)
}