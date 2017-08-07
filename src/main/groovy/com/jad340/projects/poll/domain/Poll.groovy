package com.jad340.projects.poll.domain

import java.sql.Timestamp

class Poll {
    int id
    String name
    String description
    Timestamp createdTime
    Timestamp expiresTime
    List<Option> options
}
