icampusfood
===========
iOS 9 app to discover, add, rate and share food locations on and around the USC campus. The project was completed for USC CS587 
'GeoSpatial Database Management' under Prof. Cyrus Shahabi, fall 2015. 

----------------------------------------------------------------------------------------------------------------------------------
This repo shows the source for the backend of the application. The following backend technologies were used:
```
Server technology: Java
Server: Tomcat 7 
Server framework: Spring 4, including Core, MVC, Persistence, and ORM
ORM Framework: MyBatis
Database: Postgresql and Postgis extension for geo spatial data management
Server Host: Amazon AWS
```

#Structure
----------------------------------------------------------------------------------------------------------------------------------

We separated the backend into four tiers: 
```
RESTful API Controller Layer: Define URLs for RESTful API. Data response from RESTful methods are all in json. No logic or algorithm implementation
happens here.
Domain Logic Layer: This layer is responsible for all logic implementation
Data Access Layer: This layer contains object relational mapping between database tables and java objects
SQL Mapper Layer: Plain SQL is written in this layer in MyBatis Mappers to implement logic to manipulating and processing data in and out of
the databse.
```
![alt tag](https://github.com/Jlong89/icampusfood.git/imgs/backend_structure.png)




