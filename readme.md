# Java ORM Frameworks

This project is to demonstrate / implement how to make db operations using common ORM technology / frameworks.

- JDBC
- Spring JPA / Spring Data
  - Hibernate
  - Mybatis

Overall, from top to bottom, there's less transparency, but in return, you write less code.

# User Story

As a user, I can do simple CRUD query.

# Tech Stack

- Spring Boot
- H2 (DB)

# Run Instruction

## jdbc

- set up h2 in local
  - download and install
  - run `sql/init_db_schema.sql`
- start application
  - maven import
  - modify `DbConfig` if needed
  - run `org.example.jdbc.App`

example output below:

~~~
connect successfully :)
ID	NAME	
1	Alice	
2	Bob	
connection closed, bye...
~~~

## spring jpa

- setup h2
- start application
  - maven import
  - modify `application.properties`
  - run `org.example.springjpa.App`

(note: if you remove `application.properties`, spring will connect to in memory h2 db if the driver is in place)

# Reference

- https://zhuanlan.zhihu.com/p/367585184