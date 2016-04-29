<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<%@ attribute name="title" required="false" %>
<page:html>
    <page:head title="${title}">
        <page:css/>
    </page:head>
    <page:body>
        <page:header/>
        <jsp:doBody/>
        <page:footer/>

        <page:js/>
    </page:body>
</page:html>