# WS-POC in Java with Jersey

This application is a basic REST service made with Jersey 2.31 in Java.

# Used technologies

1. Java EE (Dynamic Web Project)
2. Maven
3. Jersey
4. MySQL

# How to set-up

1. You have to create a database with the name ws_poc and import the file ws_poc.sql into that database.
2. You have to change the user:passowrd inside Dataconn.java class inside com.web.models package

# How to use

You have available 3 types: fruits, meats and vegetables. Examples are made with meats

http://localhost:8080/WS-POC/list/meats With GET returns a list of the meats stored in the database

http://localhost:8080/WS-POC/meat/2 With GET returns the fruit with the Id == 2

http://localhost:8080/WS-POC/add/meat With POST and two properties of application/json (Name and Description) add a new meat in the database, you get the response of the added item

http://localhost:8080/WS-POC/delete/meat/12 With DELETE removes the item with the passed Id from the database. If it is correctly removed: Status 200 OK

http://localhost:8080/WS-POC/update/name/meat/12 With PUT and the Name property updates the name of the give item by Id

http://localhost:8080/WS-POC/update/description/meat/15 With PUT and the Description property updates the name of the give item by Id

Thank you for your time
