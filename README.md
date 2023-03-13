# Game of Cricket

Game of Cricket is a Spring Boot Project, in which data will stored in database. This is a minor project made while Tekion Internship.

## Table of Contents

- [Teachnology Overview](#technology-overview)
- [API Endpoints](#api-endpoints)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [Testing](#testing)

## Technology Overview
### Database - SQL
### Programming Language - Java
### Framework - Spring Boot
### Hibernate Framework - JPA
### Testing Framework - Mockito

## API Endpoints

Provide information about the API endpoints for your project. Include a table that lists the endpoint URL, HTTP method, request parameters, response format, and any authentication requirements.

| Endpoint | Method | Body | Response |
| -------- | ------ | ---- | -------- |
| /match | POST | ```json {
    "numberOfPlayersInATeam" : INTEGER,
    "overs" : INTEGER
}``` | ```json{
    "id": 1,
    "numberOfPlayersInATeam": 3,
    "overs": 5,
    "winnerTeamId": null,
    "target": 0,
    "firstTeam": null,
    "secondTeam": null
}``` |
| /startMatch | POST | None | ```json {
    "id": LONG,
    "firstTeam" : {
        "id" : LONG,
        "players" :[
            {
                "id" : LONG
            },
            {
                "id" : LONG
            },
            {
                "id" : LONG
            }
        ]
    },
    "secondTeam" : {
        "id" : LONG,
        "players" : [
            {
                "id" : LONG
            },
            {
                "id" : LONG
            },
            {
                "id" : LONG
            }
        ]
    }
}```| Whole Match Object with all the details |
| /match/{winnerTeamId} | GET | None | ```json{
    "id": 1,
    "numberOfPlayersInATeam": 3,
    "overs": 5,
    "winnerTeamId": 1,
    "target": 22,
    "firstTeam": {
        "id": 1,
        "matchId": 1,
        "players": null,
        "totalRuns": 22,
        "wickets": 0,
        "name": "India1"
    },
    "secondTeam": {
        "id": 2,
        "matchId": 1,
        "players": null,
        "totalRuns": 21,
        "wickets": 2,
        "name": "India2"
    }
}```|

## Dependencies

List the dependencies that your project uses. Include the version number for each dependency.

- Dependency 1 (version number)
- Dependency 2 (version number)
- Dependency 3 (version number)

## Installation

Provide step-by-step instructions for installing your project.

## Testing

Explain how to run tests for your project. Include information about any test suites, frameworks, or libraries that you are using.
