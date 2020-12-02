<%--
  Created by IntelliJ IDEA.
  User: alice
  Date: 02.12.2020
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Medicines list</title>
</head>
<body>
<a href="/Hello">home</a>
<table>
        <tr>
            <th>Name</th>
        </tr>
    <c:forEach var="medicine" items="${medicines}" varStatus="status">
        <tr>
            <td><c:out value="${ medicine.name}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
