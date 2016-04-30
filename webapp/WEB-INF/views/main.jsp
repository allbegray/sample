<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<page:defaultpage>
    <script type="text/javascript">
        test();
        function test() {
            try {
                $('#txt-1');
            } catch (e) {
                alert('이곳에서 호출하면 $ 레퍼런스 에러가 나게 됩니다.')
            }
        }
    </script>
    <page:scripts>
        <br/>여기에 적힌 글은 body 의 가장 하단부에 출력하게 됩니다.
    </page:scripts>
    <page:scripts>
        <br/>여러개를 사용해도 되며, 위에서부터 순서대로 출력됩니다. 이런 태그가 왜 필요할까요?
    </page:scripts>
    <page:scripts>
        <br/>클라이언트 js 를 따로 만들지 않고 script 태그를 바로 사용하기 위함입니다..
        <br/>해당 객체는 Session을 이용하지 않고 TheadLocal을 사용합니다.
        <script type="text/javascript">
            test2();
            function test2() {
                $('#txt-1');
                alert('이곳에서는 문제가 발생하지 않죠');
            }
        </script>
    </page:scripts>
    ${'메인'}
    <input type="text" id="txt-1" value=""/>
    <spring:message code="test.test" />
</page:defaultpage>