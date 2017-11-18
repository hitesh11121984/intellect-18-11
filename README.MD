# How to run the project
The project is a Spring boot Sample Project. It Contains basic CUD Operations i.e. Create, Update and Delete.
To run the project go to App.java file under com.intellect.test.user_cud package and run it as java application.
The project is using in memory DB H2 that holds the data temporarily.
It runs on port 8090.

The resources for CUD are below.
Adding User : path = /user/, Method=PUT
Updating User : path= /user/{id}, Method=POST
Deleting User : path= /user/{id}, Methos=DELETE
