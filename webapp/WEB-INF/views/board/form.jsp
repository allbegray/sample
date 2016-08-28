<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<page:defaultpage>

    <c:set var="actionUrl">${s:mvcUrl("boardController.save").build()}</c:set>
    <form:form commandName="boardForm" action="${actionUrl}">
        <div>
            제목 : <form:input path="title"/><form:errors path="title"/>
        </div>
        <div>
            내용 : <form:textarea path="content"/><form:errors path="content"/>
        </div>
        <button type="submit" class="btn btn-primary">저장</button>
    </form:form>

</page:defaultpage>