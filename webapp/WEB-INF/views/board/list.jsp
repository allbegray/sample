<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<page:defaultpage>

    <div>
        <a href="${s:mvcUrl("boardController.addForm").build()}" class="btn btn-primary">생성</a>
    </div>

    <table id="tbl-board" class="table"
           data-toggle="table"
           data-url="${s:mvcUrl("boardRestController.list").build()}"
           data-sort-name="date"
           data-sort-order="desc"
           data-search="true"
           data-show-refresh="true"
           data-cookie="true"
           data-cookie-id-table="noticeList">
        <thead>
        <tr>
            <th data-field="id" data-sortable="true">id</th>
            <th data-field="title" data-sortable="true">제목</th>
            <th data-field="content" data-sortable="true">내용</th>
            <th data-field="date" data-sortable="true" data-formatter="dateFormatter">게시일</th>
        </tr>
        </thead>
    </table>

    <page:scripts>
        <script>
            $('#tbl-board').on('click-row.bs.table', function(e, row) {
                return location.href = row.id;
            });
        </script>
    </page:scripts>

</page:defaultpage>