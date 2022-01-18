## Start application on local:
### clone the git repository
```
git clone https://github.com/jwalax5/hometest.git
```
### cd to root path of the repository
```
cd hometest
```
### build the jar
```
./gradlew clean build
```
### run the application
```
java -jar build/libs/hometest-0.0.1-SNAPSHOT.jar
```
### Application started!

## Api endpoint
- ### Get history of wallet balance
```
GET     localhost:8080/transactions 
```
request body
```
{
    "startDatetime": "2011-10-08T21:00:00+00:00",
    "endDatetime": "2011-10-08T23:00:00+00:00"
}
```

- ### Save record
```
POST    localhost:8080/transactions 
```
request body
```
{
    "amount": 12,
    "transactionTime": "2011-10-08T22:39:01+00:00"
}
```
**request param field same as pdf*

## Database
### url
```
http://localhost:8080/h2
```
### set jdbc 
```
jdbc:h2:mem:testdb
```
### click connect