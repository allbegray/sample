<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="pop" required="false" type="java.lang.Boolean" %>
<jsp:doBody var="body" />
${g.pushScript(body)}
<c:if test="${pop}">
    <c:forEach items="${g.popScripts()}" var="script">
        ${script}
    </c:forEach>
</c:if>