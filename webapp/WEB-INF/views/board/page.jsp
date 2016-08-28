<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<page:defaultpage>

    <c:url var="url" value="/board/page" />
    <page:pagination url="${url}" page="${page}" form="${boardSearchForm}"></page:pagination>

    <table class="table">
        <thead>
            <th>제목</th>
            <th>내용</th>
        </thead>
        <tbody>
            <c:forEach items="${page.content}" var="board">
                <tr>
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</page:defaultpage>