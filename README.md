# telecom-operator

Demo REST application that uses Spring Boot, MySQL, JUnit and Maven.

### Starting application
To start application run `mvn spring-boot:run` command in project root directory. To work properly, database username and password must be specified either in application.properties file or using env variables `DB_USER` and `DB_PASS`. After it's started it will be available at `localhost:8080`. 

### Aviable endpoints
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
Provides information on a number of calls per each city.

#### GET api/callinfo/longest?client_id=id&start=yyyy-MM-ddTHH:mm:ssX&end=yyyy-MM-ddTHH:mm:ssX
Provides information about the longest call for defined client id and specified date range.
