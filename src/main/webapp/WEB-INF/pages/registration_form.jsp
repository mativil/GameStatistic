<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<t:layout title="Главная страница">
    <form:form action="register_me" modelAttribute="user" method = "post">
        <div>
            <label>Login</label>
            <form:input path="login"/>
        </div>
        <div>
            <label>Password</label>
            <form:password path="password"/>
        </div>
        <div>
            <label>Confrim password</label>
            <form:password path="confrimation"/>
        </div>
        <button type="submit">Register</button>
    </form:form>
</t:layout>