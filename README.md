# Game of Cricket

Game of Cricket is a Spring Boot Project, in which data will stored in database. This is a minor project made while Tekion Internship.

## Table of Contents

- [Teachnology Overview](#technology-overview)
- [API Endpoints](#api-endpoints)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [Testing](#testing)

## Technology Overview
#### Database - SQL
#### Programming Language - Java
#### Framework - Spring Boot
#### Hibernate Framework - JPA
#### Testing Framework - Mockito

## API Endpoints

| Endpoint | Method | Body | Response |
| -------- | ------ | ---- | -------- |
| /match | POST | JSON Object | JSON Object |
| /startMatch | POST | JSON Object| JSON Object |
| /match/{winnerTeamId} | GET | None | JSON Object |
| /player | POST | JSON Object | JSON Object |
| /players | POST | JSON Object | JSON Object |
| player/{name} | GET | None | JSON Object |
| /player/{teamId}/{battingOrderNumber} | GET | None | JSON Object |
| /team | POST | JSON Object | JSON Object |
| /teams | POST | JSON Object | JSON Object |
| /team/{name} | GET | None | JSON Object |

## Dependencies

- implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	- implementation 'org.springframework.boot:spring-boot-starter-web'
	- implementation 'org.hibernate.validator:hibernate-validator:8.0.0.Final'
	- implementation 'junit:junit:4.13.2'
	- compileOnly 'org.projectlombok:lombok'
	- developmentOnly 'org.springframework.boot:spring-boot-devtools'
	- runtimeOnly 'com.mysql:mysql-connector-j'
	- annotationProcessor 'org.projectlombok:lombok'
	- testImplementation 'org.springframework.boot:spring-boot-starter-test'

## Installation

- Clone the repository 
- Build build.gradle file
- Run the project from main function
- Use port number = 1234 for API Operations

## How To start with Game?

- First make match through POST request on /match endpoint with below body
```
{
    "numberOfPlayersInATeam" : 3,
    "overs" : 5
}
```

## Testing

Explain how to run tests for your project. Include information about any test suites, frameworks, or libraries that you are using.

