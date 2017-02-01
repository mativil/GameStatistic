﻿<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false" %>
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
									<li><a href="#"><i class="icon-star"></i> Лига игроков</a></li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">
											<i class="icon-eye-open"></i> Информация
											<b class="caret"></b>
										</a>
										<ul class="dropdown-menu">
											<li><a href="#">Герои</a></li>
											<li><a href="#">Карты</a></li>
										</ul>
									</li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">
											<i class="icon-user"></i> Моя учетная запись
											<b class="caret"></b>
										</a>
										<ul class="dropdown-menu">
											<li><a href="#">Профиль</a></li>
											<li><a href="#">История матчей</a></li>
											<li><a href="#">Загрузить реплей</a></li>
										</ul>
									</li>
									</ul>
					  </div>

				</div>
				</div>
		<div class="container">
			<h1>Приветствую!</h1>
			<p class="text-info">На этом сайте вы можете ознакомиться с различной информацией компьютерной игре "Герои Штангенциркуля". </p>   
			<p class="text-info">${message} </p>   
		</div>
		<div class="well">
			 <table class="table">
			<thead>
			  <tr>
				<th>Номер</th>
				<th>Имя</th>
				  <th>Класс</th>
			  </tr>
			</thead>
			<tbody>
			<c:forEach var="hero" items="${listHeroes}">
				<!--
				<tr>
					<td>${hero.id}</td>
					<td>${hero.name}</td>
					<td>${hero.type.name}</td>
				</tr>
				-->
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
