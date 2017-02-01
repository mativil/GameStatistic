<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false" %>
<%@ page import="java.util.Hashtable"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Game Statistic Site</title>
		<link rel="stylesheet" href="../../resources/css/bootstrap.css"  type="text/css">
	</head>
	<body>
	 <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	 <script src="../../resources/js/bootstrap.js"></script>
	
	 <div class="container">
	 <!--Header-->
					<div class="page-header">
								<h1 align="center">Герои Штангенциркуля</h1>						 	 
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
			<h1>Приветствую!</h1>
			<p class="text-info">На этом сайте вы можете ознакомиться с различной информацией компьютерной игре "Герои Штангенциркуля".
            На данный момент загружено ${logsCount} игр</p>
		</div>
		<div class="well">
			 <table class="table">
			<thead>
			  <tr>
				<th>Номер</th>
				<th>Имя</th>
                  <th>Класс</th>
                  <th>Убийств в среднем</th>
				  <th>Смертей в среднем</th>
				  <th>Победы (%)</th>
				  <th>Популярность  (%)</th>
			  </tr>
			</thead>
			<tbody>
            <c:forEach items="${mapResults}" var="mapItem">
                <tr>
                <td>${mapItem.key.getId()}
                </td>
                    <td><a href="<c:url value="/heroes/${mapItem.key.id}"/>">${mapItem.key.getName()}</a>
                    </td>
                    <td>${mapItem.key.getType().getName()}</td>
                <td>
                        ${String.format("%.2f", mapItem.value.avgKills)}
                </td>
					<td>
							${String.format("%.2f", mapItem.value.avgDeaths)}
					</td>
					<td>
							${String.format("%.2f", mapItem.value.gamesCnt)}
					</td>
					<td>
							${String.format("%.2f", mapItem.value.popularity)}
					</td>
                </tr>
            </c:forEach>
			</tbody>
		  </table>
		</div>
		<div class="footer">
		<p align="center">&copy; 2017. Created by mativil</p>
		</div>
 </div>
	</body>
</html>
