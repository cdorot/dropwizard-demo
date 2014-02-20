$ java -jar target/dropwizard-demo-0.1-SNAPSHOT.jar server demo.yml

http://localhost:8080/users
http://localhost:8080/users/1
http://localhost:8081/

# Test user creation

curl -i -v -X POST -H "Accept: Application/json" -H "Content-Type: application/json" -d '{ "firstname":"Leo", "lastname":"Messi" }' http://localhost:8080/users
