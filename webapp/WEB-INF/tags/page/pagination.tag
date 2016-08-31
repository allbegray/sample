<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="url" required="true" rtexprvalue="true" %>
<%@ attribute name="form" type="allbegray.sample.common.web.search.AbstractSearchForm" required="true" rtexprvalue="true" %>
<%@ attribute name="page" type="allbegray.sample.common.spring.PageWrapper" required="true" rtexprvalue="true" %>
<div>
    <ul class="pagination">
        <c:choose>
            <c:when test="${page.first}">
                <li class="disabled"><a href="#">first</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${url}?page=1&size=${page.size}${form.params}">first</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${page.hasPrevious()}">
                <li><a href="${url}?page=${page.number - 1}&size=${page.size}${form.params}">prev</a></li>
            </c:when>
            <c:otherwise>
                <li class="disabled"><a href="#">prev</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach items="${page.items}" var="item">
            <c:choose>
                <c:when test="${item.current}">
                    <li class="active"><a href="#">${item.number}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${url}?page=${item.number}&size=${page.size}${form.params}">${item.number}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${page.hasNext()}">
                <li><a href="${url}?page=${page.number + 1}&size=${page.size}${form.params}">next</a></li>
            </c:when>
            <c:otherwise>
                <li class="disabled"><a href="#">next</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${page.last}">
                <li class="disabled"><a href="#">last</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${url}?page=${page.totalPages}&size=${page.size}${form.params}">last</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>