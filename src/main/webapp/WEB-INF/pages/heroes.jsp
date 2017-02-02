<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Главная страница">
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
				<tr>
					<td>${hero.id}</td>
					<td>${hero.name}</td>
					<td>${hero.type.name}</td>
				</tr>
			</c:forEach>
			</tbody>
		  </table>
		</div>
		<div class="footer">
		<p align="center">&copy; 2017. Created by mativil</p>
		</div>
</t:layout>