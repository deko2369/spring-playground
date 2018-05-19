spring playground
=================

[![CircleCI](https://circleci.com/gh/deko2369/spring-playground/tree/master.svg?style=svg)](https://circleci.com/gh/deko2369/spring-playground/tree/master)

## Load variables in VCAP_SERVICES

See [Injecting Credentials Into Spring Boot Apps – The Easy Way](http://engineering.pivotal.io/post/spring-boot-injecting-credentials/) .

When the VCAP_SERVICES system variable is declared in your .bashrc,

```bash
export VCAP_SERVICES='
{
  "user-provided": [
    {
      "credentials": {
        "password": "RitzyAF",
        "username": "Andromeda",
        "host": "localhost",
        "port": 3306
      },
      "label": "user-provided",
      "name": "MySQLService"
    }
  ]
}'
```

then you execute this application and can check loaded variables.

```bash
$ mvn package
$ mvn spring-boot:run
Andromeda
RitzyAF
localhost
3306
```
