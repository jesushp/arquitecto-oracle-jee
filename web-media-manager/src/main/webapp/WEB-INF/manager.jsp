<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=""utf-8">
              <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="/web-media-manager/css/bootstrap.min.css" rel="stylesheet">
        <link href="/web-media-manager/css/media-manager.css" rel="stylesheet">
        <title>Media Manager</title>
    </head>
    <body>
        <jsp:useBean id="fileBean" type= "org.apz.curso.bean.FileMediaBean" scope="request"/>
        <div class="container">
            <div class="page-header">
                <h1>Media Manager <small class="hidden-xs">${fileBean.videoCount} Videos, ${fileBean.pictureCount} Pictures</small></h1>
            </div>
                        <c:forEach var="mediaGroup" items="${fileBean.groups}">
                <div class="row">
                    <div class="col-sm-1">
                        <h3 class="group-header">${mediaGroup.title}</h3>
                    </div>
                    <div class="col-sm-11">
                        <ul class="list-inline">
                            <c:forEach var="mediaItem" items="${mediaGroup.items}">
                                <li>
                                    <div>
                                        <a href="/web-media-manager/MediaController?action=item&itemId=${mediaItem.id}">
                                            <c:choose>
                                            <c:when test="${mediaItem.type == 'IMAGE'}">
                                                <img src="${mediaItem.uri}" class="thumbnail"/>
                                            </c:when>
                                            <c:otherwise>
                                                <img src="/web-media-manager/images/play.png" class="thumbnail"/>
                                            </c:otherwise>
                                        </c:choose>
                                        <h5>${mediaItem.title}</h5>
                                        </a>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:forEach>
            <nav class="navbar navbar-inverse">
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="/web-media-manager">Home</a></li> 
                        <li>
                            <a href="/web-media-manager/upload.html">Upload</a></li>
                         <li>
                            <a href="/web-media-manager/MediaController?action=settings">Settings</a></li>
                    </ul>
                </div>
            </nav>
           </div>
        <script src="/web-media-manager/js/jquery-1.11.1.min.js"></script>
        <script src="/web-media-manager/js/bootstrap.min.js"></script> 
    </body>
</html>
