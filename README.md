```
    ____        ____
   / __ \____  / / /
  / /_/ / __ \/ / /
 / ____/ /_/ / / /
/_/    \____/_/_/
Jacob Dillon (jad340) - 2017
```


[![Build Status](https://travis-ci.org/jad340/poll.svg?branch=master)](https://travis-ci.org/jad340/poll)![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)

Build using [angular](https://angular.io/), [spring boot](https://projects.spring.io/spring-boot/), and [mybatis](http://www.mybatis.org/mybatis-3/)

## Building ##

### Backend ###

Run `gradlew jar && gradlew assemble` in the root directory of this project

### Frontend ###

Run `ng build` in the `/src/main/frontend` directory

### Database Setup ###

**WARNING: RUNNING `MySQLSetup.sql` WILL DROP ANY SCHEMA NAMED `poll` IN YOUR MYSQL SERVER**

Run `mysql < MySQLSetup.sql` to setup MySQL database


## Todo ##

### API calls ###
- [x] /v1/createPoll (POST) Requests a Poll : Returns a Token
- [x] /v1/deletePoll (POST) Requests a Token : Returns a HTTP Status
- [x] /v1/getPoll (POST) Requests a Token : Returns a Poll
- [x] /v1/vote (POST) Requests a Token and Option : Returns a HTTP Status
- [x] /v1/addOption (POST) Requires a Token and Option : Returns a HTTP Status
- [x] /v1/deleteOption (POST) Requires a Token: Returns a HTTP Status
- [x] /v1/setName (POST) Requires a Token and String : Returns a HTTP Status
- [x] /v1/setDescription (POST) Requires a Token and String : Returns a HTTP Status
