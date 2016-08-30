<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<page:defaultpage>

    <c:set var="actionUrl">${s:mvcUrl("boardController.save").build()}</c:set>
    <form:form modelAttribute="boardForm" action="${actionUrl}" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <div>
            제목 : <form:input path="title"/><form:errors path="title"/>
        </div>
        <div>
            내용 : <form:textarea path="content"/><form:errors path="content"/>
        </div>
        <div>
            파일 : <input type="file" name="file" />
        </div>
        <button type="submit" class="btn btn-primary">저장</button>
    </form:form>

</page:defaultpage>