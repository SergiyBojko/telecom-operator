# telecom-operator

Demo REST application that uses Spring Boot, MySQL, JUnit and Maven.

### Starting application
Run `mvn spring-boot:run` in project root directory, it will be available at `localhost:8080`

### Aviable endpoints:
#### POST api/clients
Creates new client, it accepts following JSON request
```
{
	"id":"0",
	"fullName":"name",
	"birthday":"yyyy-MM-dd",
	"gender":"MALE/FEMALE",
	"phones":[phone1,...]
}
```

#### POST api/callinfo
Creates new call information, it accepts following JSON request
```
{
    "id": 0,
    "clientId": id,
    "callersPhone": "callersphone",
    "recipientsPhone": "recipientsphone",
    "callTime": "yyyy-MM-ddTHH:mm:ssX",
    "callDurationMills": durationInMills,
    "city": "city"
}
```

#### GET api/callinfo/perCity
Returns information on a number of calls per each city.

#### POST api/callinfo/longest?client_id=id&start=yyyy-MM-ddTHH:mm:ssX&end=yyyy-MM-ddTHH:mm:ssX
Provides information about the longest call for defined client id and specified date range.
