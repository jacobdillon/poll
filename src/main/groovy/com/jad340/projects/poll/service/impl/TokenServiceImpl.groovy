package com.jad340.projects.poll.service.impl

import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.mapper.TokenMapper
import com.jad340.projects.poll.service.TokenService
import org.apache.commons.text.RandomStringGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TokenServiceImpl implements TokenService {

    TokenMapper tokenMapper

    @Autowired
    TokenServiceImpl(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper
    }

    List<Token> createToken(Poll poll) {
        def generator = new RandomStringGenerator.Builder().withinRange('a'.codePointAt(0), 'z'.codePointAt(0)).build()

        List<Token> uncheckedTokenList = new ArrayList<>()
        uncheckedTokenList.add(new Token(token: generator.generate(8), isAdmin: true))
        uncheckedTokenList.add(new Token(token: generator.generate(8), isAdmin: false))

        List<Token> goodTokenList = new ArrayList<>()

        for(Token token : uncheckedTokenList) {
            if(!tokenMapper.checkExists(token)) {
                tokenMapper.addToken(token, poll.id)
                goodTokenList.add(token)
            } else {
                uncheckedTokenList.add(new Token(token: generator.generate(16), isAdmin: token.isAdmin))
            }
        }

        goodTokenList
    }

    boolean checkExists(Token token) {
        tokenMapper.checkExists(token)
    }

    boolean isAdmin(Token token) {
        tokenMapper.isAdmin(token)
    }

    int getPollId(Token token) {
        tokenMapper.getPollId(token)
    }
}