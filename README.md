```
    ____        ____
   / __ \____  / / /
  / /_/ / __ \/ / /
 / ____/ /_/ / / /
/_/    \____/_/_/
Jacob Dillon (jad340) - 2017
```


[![Build Status](https://travis-ci.org/jad340/poll.svg?branch=master)](https://travis-ci.org/jad340/poll)![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)


### Database Setup ###
**WARNING: RUNNING `MySQLSetup.sql` WILL DROP ANY SCHEMA NAMED `poll` IN YOUR MYSQL SERVER**

Run `mysql < MySQLSetup.sql` to setup MySQL database


### API calls ###
- [x] /api/createPoll (POST) Requests a Poll : Returns a Token
- [x] /api/deletePoll (POST) Requests a Token : Returns a HTTP Status
- [x] /api/getPoll (POST) Requests a Token : Returns a Poll
- [x] /api/vote (POST) Requests a Token and Option : Returns a HTTP Status
- [x] /api/addOption (POST) Requires a Token and Option : Returns a HTTP Status
- [ ] /api/deleteOption (POST) Requires a Token: Returns a HTTP Status
- [ ] /api/setName (POST) Requires a Token and String : Returns a HTTP Status
- [ ] /api/setDescription (POST) Requires a Token and String : Returns a HTTP Status
