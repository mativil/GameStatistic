<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Главная страница">
		<div class="hero-unit">
                <c:if test="${hero != null}">
                <h1 align="center"><c:out value="${hero.name}"/></h1>
                <h2 align="center">Класс - <c:out value="${hero.type.name}"/></h2>
                <p class="text-info"><c:out value="${hero.description}"/>
                </c:if>
		</div>
</t:layout>