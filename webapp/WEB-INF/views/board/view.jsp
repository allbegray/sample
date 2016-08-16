<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<page:defaultpage>

    <div>
        <div>
            제목 : ${board.title}
        </div>
        <div>
            내용 : ${board.content}
        </div>
    </div>

    <div>
        <a href="${s:mvcUrl("boardController.updateForm").arg(0, board.id).build()}" class="btn btn-primary">수정</a>
        <a href="${s:mvcUrl("boardController.list").build()}" class="btn btn-default">목록</a>
    </div>

</page:defaultpage>