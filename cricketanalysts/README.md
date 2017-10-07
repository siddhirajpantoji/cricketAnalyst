# README #
This is a java Spring Boot Project with Angular UI . Would need a JDK 8 for running
Google Graphs integration with backend data is done . 
Forms and imput from Angular are consuming REST API interface. 
All CRUD Operations with sample report is Set 

### What is this repository for? ###

* Cricket Summary Analysis
* 1.0

### How do I get set up? ###

* git pull origin master  
* **cd cricket**
* Database configuration- Change database name in **application.properties** ( src/main/resources/application.properties)
* Installing all Dependencies for the project
   ** mvn clean install -DskipTests**
* Cleaning and preparing for Deployment
    **mvn clean package -DskipTests**
    ( This will generate a jar file )
* Deployment instructions
  **java -jar .\target\cricket-0.0.1-SNAPSHOT.jar**
* Deploy angular using npm start . This will start in port 3000 

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact
