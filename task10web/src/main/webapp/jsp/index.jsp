<%--
  Created by IntelliJ IDEA.
  User: alice
  Date: 02.12.2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1 align="center">Parsing XML document.</h1>
    <form name="XML WebParser" method="post" action="parsing">
        <input type="radio" name="parserType" value="dom" checked>dom<br>
        <input type="radio" name="parserType" value="sax">sax<br>
        <input type="radio" name="parserType" value="stax">stax<br>
        <input type="submit" value="Parse"/>
    </form>
</div>
</body>
</html>
