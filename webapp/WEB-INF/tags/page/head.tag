<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="false"%>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title><c:out value="${title}" default="기본타이틀" /></title>
    <script>var contextPath = "${pageContext.request.contextPath}"</script>
    <jsp:doBody/>
</head>