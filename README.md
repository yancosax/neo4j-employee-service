# Yancarlo Neo4j employee graph homework

This project uses Spring Boot, Spring Data, and Neo4j for the Neo4j interview homework.
Spring Data Neo4j enables convenient integration of Neo4j in your Spring-based application.
It provides object-graph mapping (OGM) functionality and other features common to the Spring Data projects.

## Accessing Endpoints

 There are two ways you can access the rest end points:
 
    -  Open the browser web interface at http://ec2-3-18-57-200.us-east-2.compute.amazonaws.com:8080/swagger-ui.html#/employee-controller 
           
    -  Clone this project from GitHub repo https://github.com/yancosax/neo4j-employee-service.git: 
          . Run the project with `mvn spring-boot:run`.
          . access swagger ui with http://localhost:8080/swagger-ui.html#/employee-controller

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [SPRING INITIALIZR](https://start.spring.io/) - Project Setup

## The Stack

* Application Type:         Spring-Boot Java Web 
* Web framework:            Spring-Boot enabled Spring-WebMVC, Spring-Data-Rest
* Persistence Access:       Spring-Data-Neo4j 5.*
* Database:                 Neo4j-Server 3.5.3
* Frontend:                 Swagger UI 2

## Authors

* **Yancarlo Perez** - *Initial work*
