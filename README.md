spring playground
=================

[![CircleCI](https://circleci.com/gh/deko2369/spring-playground/tree/master.svg?style=svg)](https://circleci.com/gh/deko2369/spring-playground/tree/master)
[![Build Status](https://travis-ci.org/deko2369/spring-playground.svg?branch=master)](https://travis-ci.org/deko2369/spring-playground)
[![codecov](https://codecov.io/gh/deko2369/spring-playground/branch/master/graph/badge.svg)](https://codecov.io/gh/deko2369/spring-playground)



## Load variables in VCAP_SERVICES

See [Injecting Credentials Into Spring Boot Apps – The Easy Way](http://engineering.pivotal.io/post/spring-boot-injecting-credentials/).

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
$ mvn spring-boot:run
Andromeda
RitzyAF
localhost
3306
```

## Using SQLite with Spring Data

See [Using multiple datasources with Spring Boot and Spring Data]( https://medium.com/@joeclever/using-multiple-datasources-with-spring-boot-and-spring-data-6430b00c02e7).

Hibernete requires two packages to use SQLite: [sqlite-jdbc](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc) and [sqlite-dialect](https://mvnrepository.com/artifact/com.zsoltfabok/sqlite-dialect).

```bash
# 1st
$ mvn spring-boot:run
Andromeda
RitzyAF
localhost
3306
1: MAN MEN MI

# 2nd
$ mvn spring-boot:run
Andromeda
RitzyAF
localhost
3306
1: MAN MEN MI
2: MAN MEN MI

$ sqlite3 ika.sqlite
sqlite> select * from ika;
1|MAN MEN MI
2|MAN MEN MI
```