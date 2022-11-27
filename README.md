# ZOOM+Care Java Web Service

![ZOOM+Care Logo](https://avatars0.githubusercontent.com/u/48925141?s=150)


## Instructions

The database is a relational database containing two tables, `EMPLOYEE` and `PROPERTIES`.  The `EMPLOYEE` table is a simple mapping of an employee's id to their supervisor's id (or null if they have no supervisor). The `PROPERTIES` table contains a map of key/value pairs of properties for the employee.

The resulting services should allow users to get a list of all top-level employees or to specify an employee by id to return just that employee.  The result for each employee, whether in the top level list or an individual, should include the employee's Id and all properties as well as a nested list of all direct reports for that employee.  This applies any where in the structure an employee is displayed, creating a deeply nested structure of the organization.

## The Basic Project
The project is built using Maven and the Spring-Boot framework. We encourage candidates to utilize the [Spring](https://spring.io/projects/spring-framework) and [Spring-Boot](https://spring.io/projects/spring-boot) frameworks to their advantage, but it is not required to use any specific frameworks. The base project includes an instance of the [H2 database](https://www.h2database.com/html/main.html) running embedded in the process and will start up a [Tomcat java web container](http://tomcat.apache.org) running on port 8080. Running the built in application is as easy as executing the following command in the root of the project.

```
./mvnw spring-boot:run
```

The application can also be run by executing the main method of the `CandidateChallengeApplication` class in the usual way that java applications are run (command line or in an IDE).

The embedded database is configured using the spring-boot defaults for JDBC and H2. The default database JDBC url is `jdbc:h2:mem:testdb`.  This is the URL that is used for any JDBC connections and is automatically configured in the default spring-data-jdbc functionality. The H2 web console is also configured to be exposed at [http://localhost:8080/h2-console](http://localhost:8080/h2-console) when the application is running.  Make sure you set the `JDBC URL` field to `jdbc:h2:mem:testdb` when connecting to the console to be able to access the database used for the code challenge.

For additional details and troubleshooting, the project includes spring actuator in the default path [http://localhost:8080/actuator](http://localhost:8080/actuator) with all endpoints exposed and unsecure, including the detailed health endpoint at [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

## Table Reference
**EMPLOYEE**
An primary id for an employee and a reference to the employees supervisor.

| Column        | Type          |
| ------------- | ------------- |
| ID            | BIGINT(19)    |
| SUPERVISOR_ID | BIGINT(19)    |

**PROPERTIES**
A map of key/value pairs of properties assigned to an employee.

| Column        | Type          |
| ------------- | ------------- |
| EMPLOYEE_ID   | BIGINT(19)    |
| KEY           | VARCHAR(256)  |
| VALUE         | VARCHAR(256)  |


