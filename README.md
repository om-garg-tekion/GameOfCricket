# Game of Cricket

Game of Cricket is a Spring Boot Project, in which data will stored in database. This is a minor project made while Tekion Internship.

## Table of Contents

- [Teachnology Overview](#technology-overview)
- [API Endpoints](#api-endpoints)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [Testing](#testing)

## Technology Overview
- Database - SQL
- Programming Language - Java
- Framework - Spring Boot
- Hibernate Framework - JPA
- Testing Framework - Mockito

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

## Schema

<img width="759" alt="Screenshot 2023-03-13 at 3 54 28 PM" src="https://user-images.githubusercontent.com/123242450/224674938-fc92bccd-a475-4360-b6bb-31c82701c296.png">

## Installation

- Clone the repository 
- Build build.gradle file
- Run the project from main function
- Use port number = 1234 for API Operations

## How To start with Game?

- First make match through POST request on /match endpoint with below body
```
{
    "numberOfPlayersInATeam" : INT,
    "overs" : INT
}
```
##### Example
```
{
    "numberOfPlayersInATeam" : 3,
    "overs" : 5
}
```
##### Response
```
{
    "id": 1,
    "numberOfPlayersInATeam": 3,
    "overs": 5,
    "winnerTeamId": null,
    "target": 0,
    "firstTeam": null,
    "secondTeam": null
}
```
- Then make teams through POST request on /team endpoint with below body
```
{
    "matchId": LONG,
    "name": STRING
}
```
##### Example
```
{
     "matchId": 1,
     "name": "India1"
}
```
##### Response
```
{
     "id": 1,
     "matchId": 1,
     "totalRuns": 0,
     "wickets": 0,
     "name": "India1"
}
```
- Then make players through POST request on /player endpoint with below body
```
{
   "matchId": LONG,
   "teamId" : LONG,
   "name" : STRING,
   "battingOrderNumber" : INT,
   "playerRole" : STRING
}
``` 
##### Example
```
{
        "matchId": 1,
        "teamId" : 1,
        "name" : "Om",
        "battingOrderNumber" : 1,
        "playerRole" : "BATSMAN"
    }
```
##### Response
```
{
        "id": 1,
        "teamId": 1,
        "matchId": 1,
        "batsmanStatsId": null,
        "bowlingStatsId": null,
        "name": "Om",
        "battingOrderNumber": 1,
        "playerRole": "BATSMAN"
    }
```
- Then start match through POST request on /startMatch end point with below body
```
{
    "id": LONG,
    "firstTeam": {
        "id": LONG,
        "players": [
            {
                "id": LONG
            },
            {
                "id": LONG
            },
            {
                "id": LONG
            }
        ]
    },
    "secondTeam": {
        "id": LONG,
        "players": [
            {
                "id": LONG
            },
            {
                "id": LONG
            },
            {
                "id": LONG
            }
        ]
    }
}
```
##### Example
```
{
    "id": 1,
    "firstTeam": {
        "id": 1,
        "players": [
            {
                "id": 1
            },
            {
                "id": 2
            },
            {
                "id": 3
            }
        ]
    },
    "secondTeam": {
        "id": 2,
        "players": [
            {
                "id": 4
            },
            {
                "id": 5
            },
            {
                "id": 6
            }
        ]
    }
}
```

##### Response
```
{
    "id": 1,
    "numberOfPlayersInATeam": 3,
    "overs": 5,
    "winnerTeamId": 1,
    "target": 22,
    "firstTeam": {
        "id": 1,
        "matchId": 1,
        "players": [
            {
                "id": 1,
                "teamId": 1,
                "matchId": 1,
                "batsmanStatsId": 1,
                "bowlingStatsId": null,
                "name": "Om",
                "battingOrderNumber": 1,
                "batsmanStats": {
                    "id": 1,
                    "totalRunsMade": 10,
                    "totalBallsPlayed": 10,
                    "numberOfFours": 0,
                    "numberOfSixes": 1,
                    "outBy": null,
                    "bowledBy": null,
                    "runsForBatsman": "ZERO",
                    "runsForBowler": "ONE"
                },
                "bowlerStats": {
                    "id": null,
                    "numberOfWicketTaken": 0,
                    "numberOfBallsTaken": 0
                },
                "playerRole": "BATSMAN"
            },
            {
                "id": 2,
                "teamId": 1,
                "matchId": 1,
                "batsmanStatsId": 2,
                "bowlingStatsId": 1,
                "name": "OMG",
                "battingOrderNumber": 2,
                "batsmanStats": {
                    "id": 2,
                    "totalRunsMade": 12,
                    "totalBallsPlayed": 9,
                    "numberOfFours": 1,
                    "numberOfSixes": 0,
                    "outBy": null,
                    "bowledBy": null,
                    "runsForBatsman": "ONE",
                    "runsForBowler": "ZERO"
                },
                "bowlerStats": {
                    "id": 1,
                    "numberOfWicketTaken": 1,
                    "numberOfBallsTaken": 12
                },
                "playerRole": "BOWLER"
            },
            {
                "id": 3,
                "teamId": 1,
                "matchId": 1,
                "batsmanStatsId": 3,
                "bowlingStatsId": 2,
                "name": "Techno",
                "battingOrderNumber": 3,
                "batsmanStats": {
                    "id": 3,
                    "totalRunsMade": 0,
                    "totalBallsPlayed": 0,
                    "numberOfFours": 0,
                    "numberOfSixes": 0,
                    "outBy": null,
                    "bowledBy": null,
                    "runsForBatsman": "FOUR",
                    "runsForBowler": "ZERO"
                },
                "bowlerStats": {
                    "id": 2,
                    "numberOfWicketTaken": 1,
                    "numberOfBallsTaken": 12
                },
                "playerRole": "BOWLER"
            }
        ],
        "totalRuns": 22,
        "wickets": 0,
        "name": "India1"
    },
    "secondTeam": {
        "id": 2,
        "matchId": 1,
        "players": [
            {
                "id": 4,
                "teamId": 2,
                "matchId": 1,
                "batsmanStatsId": 4,
                "bowlingStatsId": null,
                "name": "Parth",
                "battingOrderNumber": 1,
                "batsmanStats": {
                    "id": 4,
                    "totalRunsMade": 10,
                    "totalBallsPlayed": 9,
                    "numberOfFours": 1,
                    "numberOfSixes": 0,
                    "outBy": null,
                    "bowledBy": null,
                    "runsForBatsman": "ZERO",
                    "runsForBowler": "ZERO"
                },
                "bowlerStats": {
                    "id": null,
                    "numberOfWicketTaken": 0,
                    "numberOfBallsTaken": 0
                },
                "playerRole": "BATSMAN"
            },
            {
                "id": 5,
                "teamId": 2,
                "matchId": 1,
                "batsmanStatsId": 5,
                "bowlingStatsId": 3,
                "name": "PP",
                "battingOrderNumber": 2,
                "batsmanStats": {
                    "id": 5,
                    "totalRunsMade": 8,
                    "totalBallsPlayed": 10,
                    "numberOfFours": 0,
                    "numberOfSixes": 0,
                    "outBy": {
                        "id": 3,
                        "teamId": 1,
                        "matchId": 1,
                        "batsmanStatsId": 3,
                        "bowlingStatsId": 2,
                        "name": "Techno",
                        "battingOrderNumber": 3,
                        "batsmanStats": {
                            "id": 3,
                            "totalRunsMade": 0,
                            "totalBallsPlayed": 0,
                            "numberOfFours": 0,
                            "numberOfSixes": 0,
                            "outBy": null,
                            "bowledBy": null,
                            "runsForBatsman": "ZERO",
                            "runsForBowler": "ONE"
                        },
                        "bowlerStats": {
                            "id": 2,
                            "numberOfWicketTaken": 1,
                            "numberOfBallsTaken": 12
                        },
                        "playerRole": "BOWLER"
                    },
                    "bowledBy": 3,
                    "runsForBatsman": "ONE",
                    "runsForBowler": "ZERO"
                },
                "bowlerStats": {
                    "id": 3,
                    "numberOfWicketTaken": 0,
                    "numberOfBallsTaken": 12
                },
                "playerRole": "BOWLER"
            },
            {
                "id": 6,
                "teamId": 2,
                "matchId": 1,
                "batsmanStatsId": 6,
                "bowlingStatsId": 4,
                "name": "Techie",
                "battingOrderNumber": 3,
                "batsmanStats": {
                    "id": 6,
                    "totalRunsMade": 3,
                    "totalBallsPlayed": 5,
                    "numberOfFours": 0,
                    "numberOfSixes": 0,
                    "outBy": {
                        "id": 2,
                        "teamId": 1,
                        "matchId": 1,
                        "batsmanStatsId": 2,
                        "bowlingStatsId": 1,
                        "name": "OMG",
                        "battingOrderNumber": 2,
                        "batsmanStats": {
                            "id": 2,
                            "totalRunsMade": 12,
                            "totalBallsPlayed": 9,
                            "numberOfFours": 1,
                            "numberOfSixes": 0,
                            "outBy": null,
                            "bowledBy": null,
                            "runsForBatsman": "TWO",
                            "runsForBowler": "ONE"
                        },
                        "bowlerStats": {
                            "id": 1,
                            "numberOfWicketTaken": 1,
                            "numberOfBallsTaken": 12
                        },
                        "playerRole": "BOWLER"
                    },
                    "bowledBy": 2,
                    "runsForBatsman": "THREE",
                    "runsForBowler": "FIVE"
                },
                "bowlerStats": {
                    "id": 4,
                    "numberOfWicketTaken": 0,
                    "numberOfBallsTaken": 7
                },
                "playerRole": "BOWLER"
            }
        ],
        "totalRuns": 21,
        "wickets": 2,
        "name": "India2"
    }
}
```

## Testing

The testing of this project is done using Mockito the framework of JUnit.
The test cases are present in src/test directory.


