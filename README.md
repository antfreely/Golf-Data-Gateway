# Overview

This project exposes two endpoints to allow updates to golf tournaments, 
where the request body contains a JSON body representing the tournament information
and a header, `DataSource`, where the data source name should be specified

Once the application receives the updates,
it maps the request body to a model class and saves it to a database

# How to Run

## Build the Jar file

Build the jar file by executing the following: 

`gradlew bootJar`

## Run the Jar file

Run the jar file by executing the following:

`java -jar golf-data-gateway-0.0.1-SNAPSHOT.jar`

## Send REST calls

### Use the V1 API

In Postman, send a `POST` request to the endpoint:

`http://localhost:8080/v1/golf-tournaments`

With a header value filled in for header, `DataSource`

With a request body with the following schema:

`
{
	"tournamentId": "174638",
	"tournamentName": "Women's Open Championship",
	"forecast": "fair",
	"courseName": "Sunnydale Golf Course",
	"countryCode": "GB",
	"startDate": "09/07/21",
	"endDate": "13/07/21",
	"roundCount": "4"
}
`

### Use the V2 API

In Postman, send a `POST` request to the endpoint:

`http://localhost:8080/v2/golf-tournaments`

With a header value filled in for header, `DataSource`

With a request body with the following schema:

`
{
    "tournamentUUID":"southWestInvitational",
    "golfCourse":"Happy Days Golf Club",
    "competitionName":"South West Invitational",
    "hostCountry":"United States Of America",
    "epochStart":"1638349200",
    "epochFinish":"1638468000",
    "rounds":"2",
    "playerCount":"35"
}
`

# Future proofing the solution

## Adding additional data sources

As long as the data source has enough information to use either endpoint, the new data source can use the
existing endpoints and will just have to be given a new value to fill in the `DataSource` header as part of the request

## Need for a new endpoint

If there is a need for a new endpoint, a new `v3` package can be made where the controller, DTO and mappers can live.
Other than a new Controller and DTO, the rest of the flow should remain unchanged.

## Changing Database implementations

Since JPA and Spring are being used, SQL database implementations can be injected via configuration.

Currently, the default is an in memory H2 database since there isn't an implementation defined
