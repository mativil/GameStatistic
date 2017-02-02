<%@tag pageEncoding="UTF-8" description="Base layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" type="java.lang.String" required="true"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title><c:out value="${title}"/></title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.css"  type="text/css">
</head>
<body>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="../../resources/js/bootstrap.js"></script>

<div class="container">
    <!--Header-->
    <div class="page-header">
        <h1 align="center">Игровая статистика</h1>
        <div class="navbar">
            <div class="navbar-inner">
                <ul class="nav">
                    <li><a href="#"><i class="icon-star"></i>Лига игроков</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-eye-open"></i>Игровая Информация
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/heroes">Герои</a></li>
                            <li><a href="#">Карты</a></li>
                            <li><a href="/logs">Список матчей</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> Моя учетная запись
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Профиль</a></li>
                            <li><a href="#">История моих матчей</a></li>
                            <li><a href="#">Загрузить матч</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <jsp:doBody/>
    </div>
    <div class="footer">
        <p align="center">&copy; 2017. Created by mativil</p>
    </div>
</div>
</body>
</html>
