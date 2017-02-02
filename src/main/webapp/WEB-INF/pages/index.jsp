<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Главная страница">
			<h1>Приветствую!</h1>
			<p class="text-info">На этом сайте вы можете ознакомиться с различной информацией компьютерной игре "Герои Штангенциркуля".
            На данный момент загружено ${logsCount} игр</p>
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
</t:layout>