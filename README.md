iCampusFood
===========
iOS 9 app to discover, add, rate and share food locations on and around the USC campus. The project was completed for USC CS587 
'GeoSpatial Database Management' under Prof. Cyrus Shahabi, fall 2015. 

![alt text](imgs/ios_shot1.png?raw=true)      ![alt text](imgs/ios_shot2.png?raw=true)

----------------------------------------------------------------------------------------------------------------------------------

Features
========

Take a look at the features in the video! https://youtu.be/u9dnNvEjVbw

----------------------------------------------------------------------------------------------------------------------------------

Implementation Description
==========================

This repo shows the source for the backend of the application, which provide RESTful API web services for the mobile client. The following backend technologies were used:
```
Server technology: Java
Server: Tomcat 7 
Server framework: Spring 4, including Core, MVC, Persistence, and ORM
ORM Framework: MyBatis
Database: Postgresql and Postgis extension for geo spatial data management
Proj mgmt: Maven
Server Host: Amazon AWS
```

#Structure
----------------------------------------------------------------------------------------------------------------------------------

We separated the backend into four tiers: 
```
RESTful API Controller Layer: Define URLs for RESTful API. Data response from RESTful methods are all in json. No logic or algorithm implementation happens here.

Domain Logic Layer: This layer is responsible for all logic implementation.

Data Access Layer: This layer contains object relational mapping between database tables and java DBDO objects, whose functionality is  clearly defined into methods that map to SQL statements in the SQL Mapper Layer.

SQL Mapper Layer: SQL is written in this layer in MyBatis XML Mappers to implement CRUD behavior of the data objects as well as more complex queries, such as geospatial queries (KNN, range search, etc.)
```
![alt text](imgs/backend_struct.png?raw=true "Backend structure")



Database
========

Postgis extension of Postgresql was used to get functionality to store and manipulate geospatial data. For instance, Postgis PGgeometry structures were needed to store lat/long information of our restaurant items effectively. It also allowed us to perform geospatial queries effectively, such as KNN and range search.



