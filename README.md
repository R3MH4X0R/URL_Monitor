# URL_Monitor
Spring based web application that monitor URL responses such as:
* Response time
* Response code
* Response length

Features:
* Update single url
* Update all url
* Update all url every 5 sec
* Basic CRUD operations
* Jquery validation
* In-memory H2 Database


In this project i used H2 database(in-memory) instead of usual MySql that allows me to make and test project faster
and anyone who want to test project dont need to have installed some database, flexibility ^_^
Possible in future this project get some reworks and new features!

## Install
Clone the project
```
git clone https://github.com/R3MH4X0R/URL_Monitor.git
```
Use maven to build project

```
mvn clean install
```
Launch it
```
java -jar urlmonitoring-1.0.jar
```
You can access project through http://localhost:8080/

## Built With

* [Thymeleaf](https://www.thymeleaf.org/)
* [Maven](https://maven.apache.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
* [H2 Database](http://www.h2database.com/html/main.html)

## License

This project is licensed under the MIT License - see the LICENSE.md file for details
