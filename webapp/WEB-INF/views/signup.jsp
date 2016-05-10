<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<page:defaultpage>

    <form:form method="post" commandName="signupForm">

        <div>
            <form:errors path="*" />
        </div>

        아이디 : <form:input path="loginId" /><form:errors path="loginId" /> <br/>
        이름 : <form:input path="name" /><form:errors path="name" /> <br/>
        이메일 : <form:input path="email" /><form:errors path="email" /> <br/>
        패스워드 : <form:input path="password" /><form:errors path="password" /> <br/>
        패스워드 확인<form:input path="confirmPassword" /><form:errors path="confirmPassword" /> <br/>
        <input type="submit" value="저장" />
    </form:form>

</page:defaultpage>