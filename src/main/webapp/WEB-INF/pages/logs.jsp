<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Главная страница">
		<div class="well">
			 <table class="table">
			<thead>
			  <tr>
				  <th>Номер</th>
				  <th>Карта</th>
                  <th>Дата загрузки</th>
				  <th>Длительность</th>
			  </tr>
			</thead>
			<tbody>
            <c:forEach var="log" items="${listLogs}">
                <tr>
                    <td>${log.id}</td>
                    <td>${log.map.name}</td>
                    <td>${log.loadTime}</td>
                    <td>${log.duration}</td>
                </tr>
            </c:forEach>
			</tbody>
		  </table>
		</div>
		<div class="footer">
		<p align="center">&copy; 2017. Created by mativil</p>
		</div>
</t:layout>
