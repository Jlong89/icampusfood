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
                        <span class="restfb-brand-highlight">iCampus</span><span class="restfb-brand-light">Food</span>
                    </h1>
                    <p>
                        iCampusFood is an iOS based application<br>
                        It lets users know food ?profiles? on and around the USC campus.
                    </p>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="page-header">
                <h1 class="text-center">Best fit location for food?<br>Try iCampusFood!</h1>
            </div>
            <!--<p class="text-center"><img src="${pageContext.request.contextPath}/images/line2.png" alt="separator line"></p>-->     
            <div class="jumbotron">
                <p>
                    A profile of a food location includes <strong>the type of food, rating of food, 
                        quality of service, and the number of friends </strong>that have been at that location. 
                    The profiles are compounded from user posts of locations. Users can also add new food place at any location, 
                    which will become available for other users to post about. 
                    The area profiles will include an option to <strong>view profiles based on food categories.</strong>
                    Through this feature, users can explore areas and see the area profile to find areas they are interested in.
                </p>
                <br>
                <!--<div class="text-center">
                    <a href="${pageContext.request.contextPath}/ChartDataServlet?action=searchPatient" class="btn btn-primary btn-lg" role="button" target="_blank">Go search patient!</a>
                </div>-->
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
                    <!--<a href="#">Privacy</a>
                    ·
                    <a href="#">Terms</a>-->
                </p>
            </footer>
        </div>               
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            function logout() {
                window.location.replace('${pageContext.request.contextPath}/LoginServlet?action=mobLogout');
            }
            ;
        </script>
    </body>
</html>
