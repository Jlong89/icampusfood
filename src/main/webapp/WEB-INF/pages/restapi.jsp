<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="../include/normal_head.jsp" %>
    <body>
        <%@ include file="../include/navbar.jsp" %>
        <div id="content" class="bs-docs-header">
            <div class="container">
                <div class="container">
                    <h1 class="restfb-logo-brand">
                        <span class="restfb-brand-light">RESTful API</span><span class="restfb-brand-highlight"> iCampusFood </span>
                    </h1>
                    <p>
                        Here are all about iCampusFood RESTful API, <br>including explanation, contents, and example!
                    </p>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="page-header">
                <h1 class="text-left">Retrieve All Users</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/getusers.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>GET</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                None
                <h2>Data Response</h2>
                [<br>
                &nbsp;&nbsp;&nbsp; {<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"userId": 1,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"userName": "testUser1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"password": "pass1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"favoriateLocationIdList":<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;13<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;],<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"friends":<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"test2"<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<br>
                &nbsp;&nbsp;&nbsp; },<br>
                &nbsp;&nbsp;&nbsp; {<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"userId": 2,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"userName": "testUser2",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"password": "pass2",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"favoriateLocationIdList":<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;],<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"friends":<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Joey",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Ray",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"test2"<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<br>
                &nbsp;&nbsp;&nbsp; },<br>
                ]<br>
                <h2>Testing</h2>
                <a href="http://icampusfood.elasticbeanstalk.com/rest/getusers.mvc" class="btn btn-primary" role="button" target="_blank">Retrieve All Users</a>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Create a new User</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/insertuser.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Restriction</td>
                        <td>User name must be unique.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "userName":"user23",<br>
                &nbsp;&nbsp;&nbsp; "password":"eji2u33"<br>
                }<br>
                <h2>Data Response<small>  System returns an User object with a new user Id</small></h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "userId": 12,<br>
                &nbsp;&nbsp;&nbsp; "userName":"user23",<br>
                &nbsp;&nbsp;&nbsp; "password":"eji2u33"<br>
                }<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Check Login</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/checklogin.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>Given a token, system responds whether if the token is in database. If yes, return true.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {"token" : "5spp0o4nhv1p462ub0l4h6pt8m"}<br>
                <h2>Data Response</h2>
                true/false<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Login</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/login.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>Given a User name and password, system first verify the user and then check if this user id is in token table. If it is, then update the user's token with a new token. Otherwise, system create a new token for the user.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {"userName":"Ray", "password":"ray"}<br>
                <h2>Data Response</h2>
                {"token": "5spp0o4nhv1p462ub0l4h6pt8m"}<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Add A New Food Location</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/addnewfoodlocation.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>Save a new food location. If success, return true. For some reasons, such as duplicate coordinate, it return false.</td>
                    </tr>
                    <tr>
                        <td>Restriction 1</td>
                        <td>Time format for open/close time: 00:00~23:59. Date format for strt/end date: 2015/09/29. If the food location is permanent, just put "null" in endDate field.</td>
                    </tr>
                    <tr>
                        <td>Restriction 2</td>
                        <td>Name and coordinate must be unique.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"180.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"192.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"4.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                }<br>
                <h2>Data Response</h2>
                true/false<br>
            </div>
            <br><br><br>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Get A Food Location By Location Name</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/getfoodlocationbyname.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Restriction</td>
                        <td>Name and coordinate are unique.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                }<br>
                <h2>Data Response</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"180.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"192.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"4.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                }<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Get All Food Types</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/getfoodtypes.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>GET</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>Get all food types. In all web services, system only respond type Integer instead of type String.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                None<br>
                <h2>Data Response</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "1": "fast food",<br>
                &nbsp;&nbsp;&nbsp; "2": "italian",<br>
                &nbsp;&nbsp;&nbsp; "3": "chinese",<br>
                &nbsp;&nbsp;&nbsp; "4": "mexican",<br>
                &nbsp;&nbsp;&nbsp; "5": "snack",<br>
                &nbsp;&nbsp;&nbsp; "6": "bar/cafe,",<br>
                &nbsp;&nbsp;&nbsp; "7": "japanese"<br>
                }<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Insert New Favorite By Username</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/addNewFavorite.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>Insert a new user's favorite location by username.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"7",<br>
                &nbsp;&nbsp;&nbsp; "userName":"Ray"<br>
                }<br>
                <h2>Data Response</h2>
                1=success, otherwise: false<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Insert New Friend By Username</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/addNewFriend.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>add a new friend by user's username and the new friend's username.</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                {<br>
                &nbsp;&nbsp;&nbsp; "userName":"Joey",<br>
                &nbsp;&nbsp;&nbsp; "friendUserName":"Ray"<br>
                }<br>
                <h2>Data Response</h2>
                1=success, otherwise: false<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Insert New Post</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/addNewPost.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                &nbsp;&nbsp;&nbsp; {<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postId": 1,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "locationId": 5,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "foodRating": 4,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "serviceRating": 3,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "crowdedness": 2,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postDate": "2015/11/23",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postTime": "12:35"<br>
                &nbsp;&nbsp;&nbsp; }<br>
                <h2>Data Response</h2>
                1=success, otherwise: false<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Get Posts by Location ID</h1>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Function</th>
                        <th>Contents</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>API URL</td>
                        <td>http://icampusfood.elasticbeanstalk.com/rest/getPostsByLocId.mvc</td>
                    </tr>
                    <tr>
                        <td>HTTP Mtehod</td>
                        <td>GET</td>
                    </tr>
                    <tr>
                        <td>Protocol</td>
                        <td>HTTP, PORT=80</td>
                    </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: locId<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/getPostsByLocId.mvc?locId=5" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/getPostsByLocId.mvc?locId=5</a>
                <h2>Data Response</h2>
                [<br>
                &nbsp;&nbsp;&nbsp; {<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postId": 1,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "locationId": 5,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "foodRating": 4,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "serviceRating": 3,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "crowdedness": 2,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postDate": "1999/0/8",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postTime": "4:5"<br>
                &nbsp;&nbsp;&nbsp; },<br>
                &nbsp;&nbsp;&nbsp; {<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postId": 2,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "locationId": 5,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "foodRating": 3,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "serviceRating": 5,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "crowdedness": 1,<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postDate": "1999/0/8",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "postTime": "4:5"<br>
                &nbsp;&nbsp;&nbsp; }<br>
                ]<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Near By (Range)</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/nearByRange.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>1. longitude(String), 2. latitude(String), 3. radius(double, unit=meter)</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: 1. longitude(String), 2. latitude(String), 3. radius(double)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/nearByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/nearByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000</a>
                <!--EX: <a href="http://localhost:8080/icampusfood/rest/nearByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/nearByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000</a>-->
                <h2>Data Response<small> List of Food locations, if no contents, return empty list (size=0)</small></h2>
                [<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"123",<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"180.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"192.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"4.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp; },<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"124",<br>
                &nbsp;&nbsp;&nbsp; "name":"Burger",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"190.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"111.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"1.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;}<br>
                ]<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Near By (Range + KNN)</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNN.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>1. longitude(String), 2. latitude(String), 3. radius(double, unit=meter), 4. K (int)</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: 1. longitude(String), 2. latitude(String), 3. radius(double),  4. K (int)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNN.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNN.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3</a>
                <!--EX: <a href="http://localhost:8080/icampusfood/rest/nearByRangeKNN.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNN.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3</a>-->
                <h2>Data Response<small> List of Food locations, if no contents, return empty list (size=0)</small></h2>
                <h3><span style="color:red;">Return "distance" to query point when using this method!</span> </h3>

                [<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"121",<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"180.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"192.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"4.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;&nbsp;&nbsp; <span style="color:red;">"distance":"12.23"</span><br>
                &nbsp; },<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"123",<br>
                &nbsp;&nbsp;&nbsp; "name":"Burger",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"190.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"111.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"1.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;&nbsp;&nbsp; <span style="color:red;">"distance":"23.43"</span><br>
                &nbsp;}<br>
                ]<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Best Food Type By Range</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/getBestFoodTypeByRange.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>1. longitude(<span style="color:red;"> double</span>), 2. latitude(<span style="color:red;"> double</span>), 3. radius(double, unit=meter)</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: 1. longitude(<span style="color:red;"> double</span>), 2. latitude(<span style="color:red;"> double</span>), 3. radius(double)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/getBestFoodTypeByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/getBestFoodTypeByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000</a>
                <!--EX: <a href="http://localhost:8080/icampusfood/rest/getBestFoodTypeByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/getBestFoodTypeByRange.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000</a>-->
                <h2>Data Response</h2>
                {<br>
                &nbsp;&nbsp; "foodType":"1",<br>
                &nbsp;&nbsp; "rating":"4.1",<br>
                }<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Near By (Range + KNN + Time)</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNNTime.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>1. longitude(double), 2. latitude(double), 3. radius(double, unit=meter), 4. K (int) 5. hour (int) 6. min (int) 7. sec (int)</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: 1. longitude(String), 2. latitude(String), 3. radius(double),  4. K (int) 5. hour (int) 6. min (int) 7. sec (int)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNNTime.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&hour=12&min=10&sec=10" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/nearByRangeKNNTime.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&hour=12&min=10&sec=10</a>
                <!--<br>EX: <a href="http://localhost:8080/icampusfood/rest/nearByRangeKNNTime.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&hour=12&min=10&sec=10" target="_blank">http://localhost:8080/icampusfood/rest/nearByRangeKNNTime.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&hour=12&min=10&sec=10</a>-->
                <h2>Data Response<small> List of Food locations, if no contents, return empty list (size=0)</small></h2>
                <h3><span style="color:red;">Return "distance" to query point when using this method!</span> </h3>

                [<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"122",<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"180.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"192.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"4.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;&nbsp;&nbsp; <span style="color:red;">"distance":"12.23"</span><br>
                &nbsp; },<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"123",<br>
                &nbsp;&nbsp;&nbsp; "name":"Burger",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"190.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"111.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"1.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;&nbsp;&nbsp; <span style="color:red;">"distance":"23.43"</span><br>
                &nbsp;}<br>
                ]<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Weekly Data</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/weeklyData.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>locationId (int)</td>
                </tr>
                <tr>
                    <td>Abailable LocationId for crowded data</td>
                    <td>277, 283</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: locationId (int)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/weeklyData.mvc?locationId=277" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/weeklyData.mvc?locationId=277</a>
                <!--<br>EX: <a href="http://localhost:8080/icampusfood/rest/weeklyData.mvc?locationId=277" target="_blank">http://localhost:8080/icampusfood/rest/weeklyData.mvc?locationId=277</a>-->
                <h2>Data Response<small> List of Crowdedness Data</small></h2>

                [<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "rowNo":"0",<br>
                &nbsp;&nbsp;&nbsp; "crowdedness":"2.823529411764706",<br>
                &nbsp;&nbsp;&nbsp; "dow":"0",<br>
                &nbsp;&nbsp;&nbsp; "hour":"13",<br>
                &nbsp; },<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "rowNo":"0",<br>
                &nbsp;&nbsp;&nbsp; "crowdedness":"2.125",<br>
                &nbsp;&nbsp;&nbsp; "dow":"0",<br>
                &nbsp;&nbsp;&nbsp; "hour":"12",<br>
                &nbsp; }<br>
                ]<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Get Best Foodlaction With KNN By Food Type or Crowdedness</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/getBestByTypeOrCrowd.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>1. longitude(double), 2. latitude(double), 3. radius(double, unit=meter), 4. K (int) 5. FoodType (int), 6. Category (int)</td>
                </tr>
                <tr>
                    <td>Category Description</td>
                    <td>1. avgFoodRating<br>
                        2. avgServiceRating<br>
                        3. avgCrowdedness</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: 1. longitude(double), 2. latitude(double), 3. radius(double, unit=meter), 4. K (int) 5. FoodType (int), 6. Category (int)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/getBestByTypeOrCrowd.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&foodType=1&category=1" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/getBestByTypeOrCrowd.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&foodType=1&category=1</a>
                <br>EX: <a href="http://localhost:8080/rest/getBestByTypeOrCrowd.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&foodType=1&category=1" target="_blank">http://localhost:8080/rest/getBestByTypeOrCrowd.mvc?longitude=-118.2829198&latitude=34.0242493&radius=3000&k=3&foodType=1&category=1</a>
                <h2>Data Response<small> List of Food locations, if no contents, return empty list (size=0)</small></h2>
                <h3><span style="color:red;">Return "distance" to query point when using this method!</span> </h3>
                [<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"123",<br>
                &nbsp;&nbsp;&nbsp; "name":"Panda",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"180.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"192.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"4.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;&nbsp;&nbsp; <span style="color:red;">"distance":"12.23"</span><br>
                &nbsp; },<br>
                &nbsp; {<br>
                &nbsp;&nbsp;&nbsp; "locationId":"124",<br>
                &nbsp;&nbsp;&nbsp; "name":"Burger",<br>
                &nbsp;&nbsp;&nbsp; "coordinate":{<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "xcoord":"190.1",<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "ycoord":"111.3"},<br>
                &nbsp;&nbsp;&nbsp; "avgFoodRating":"2.1",<br>
                &nbsp;&nbsp;&nbsp; "avgServiceRating":"3.1",<br>
                &nbsp;&nbsp;&nbsp; "avgCrowdedness":"1.1",<br>
                &nbsp;&nbsp;&nbsp; "openTime":"08:00",<br>
                &nbsp;&nbsp;&nbsp; "closeTime":"22:00",<br>
                &nbsp;&nbsp;&nbsp; "startDate":"2015/09/29",<br>
                &nbsp;&nbsp;&nbsp; "endDate":"2015/10/12",<br>
                &nbsp;&nbsp;&nbsp; "foodType":"1"<br>
                &nbsp;&nbsp;&nbsp; <span style="color:red;">"distance":"23.43"</span><br>
                &nbsp;}<br>
                ]<br>
            </div>
            <br><br><br>
            <div class="page-header">
                <h1 class="text-left">Is specific food location your friend's favorite</h1>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Function</th>
                    <th>Contents</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>API URL</td>
                    <td>http://icampusfood.elasticbeanstalk.com/rest/isFriendFavorite.mvc</td>
                </tr>
                <tr>
                    <td>HTTP Mtehod</td>
                    <td>GET</td>
                </tr>
                <tr>
                    <td>Get parameters</td>
                    <td>1. username(String), 2. locationId(int)</td>
                </tr>
                <tr>
                    <td>Protocol</td>
                    <td>HTTP, PORT=80</td>
                </tr>
                </tbody>
            </table>
            <div class="well well-lg">
                <h2>Data Send</h2>
                Get parameter: 1. username(String), 2. locationId(int)<br>
                EX: <a href="http://icampusfood.elasticbeanstalk.com/rest/isFriendFavorite.mvc?username=rayyy&locationId=342" target="_blank">http://icampusfood.elasticbeanstalk.com/rest/isFriendFavorite.mvc?username=rayyy&locationId=342</a>
                <br>EX: <a href="http://localhost:8080/rest/isFriendFavorite.mvc?username=rayyy&locationId=342" target="_blank">http://localhost:8080/rest/isFriendFavorite.mvc?username=rayyy&locationId=342</a>
                <h2>Data Response<small> This food location is your friend's favorite or not.</small></h2>
                True or False<br>
            </div>
        </div>

        </div>
        <div class="container">
            <hr class="featurette-divider">
            <footer>
                <p class="pull-right">
                    <a href="#">Back to top</a>
                </p>
                <p>
                    Copyright © 2015 The University of Southern California Privacy Policy 
                </p>
            </footer>
        </div>               
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   
    </body>
</html>
