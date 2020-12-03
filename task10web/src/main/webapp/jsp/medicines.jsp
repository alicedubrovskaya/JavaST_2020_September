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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Medicines list</title>
</head>
<body>
<a href="/Hello">home</a>
<table border="1">
<%--    <tr>--%>
<%--        <th>Name</th>--%>
<%--        <th>Pharm</th>--%>
<%--        <th>Group</th>--%>
<%--        <th>Analogs</th>--%>
<%--        <th>Dosages</th>--%>
<%--    </tr>--%>
<%--    <c:forEach var="medicine" items="${medicines}" varStatus="status">--%>
<%--        <tr>--%>
<%--            <td rowspan="2">Name</td>--%>
<%--            <td>Dosage 1</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Dosage 2</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
       <c:forEach var="medicine" items="${medicines}" varStatus="status">
        <tr>
            <td rowspan="<c:out value="${ medicine.versionList.getVersionsCount() }"/>">
                <c:out value="${ medicine.name }"/>
            </td>
            <td rowspan="<c:out value="${ medicine.versionList.getVersionsCount() }"/>">
                <c:out value="${ medicine.pharm }"/></td>
            <td rowspan="<c:out value="${ medicine.versionList.getVersionsCount() }"/>">
                <c:out value="${ medicine.group }"/></td>
            <td rowspan="<c:out value="${ medicine.versionList.getVersionsCount() }"/>">
                <c:out value="${ medicine.analogs }"/></td>
            <c:forEach var="version" items="${medicine.versionList.versions}"
                      varStatus="status" begin="0"  end="0">

                <td><c:out value="${ version.type }"/></td>

                <td><c:out value="${ version.producer.aPackage.type }"/></td>
                <td><c:out value="${ version.producer.aPackage.quantity }"/></td>
                <td><c:out value="${ version.producer.aPackage.price }"/></td>

                <td><c:out value="${ version.producer.dosage.count }"/></td>
                <td><c:out value="${ version.producer.dosage.period }"/></td>

                <td><c:out value="${ version.producer.certificate.number }"/></td>
                <td><c:out value="${ version.producer.certificate.issueDate }"/></td>
                <td><c:out value="${ version.producer.certificate.organization }"/></td>
                <c:choose>
                    <c:when test="${version.producer.certificate.getClass() eq 'class by.training.xml.entity.Certificate'}">
                        <td>-</td>
                    </c:when>
                    <c:otherwise>
                        <td><c:out value="${ version.producer.certificate.expirationDate }"/></td>
                    </c:otherwise>
                </c:choose>


            </c:forEach>
        </tr>
        <c:forEach var="version" items="${medicine.versionList.versions}"
                   varStatus="status" begin="1"  end="${medicine.versionList.versions.size()}">
            <tr>
                <td> <c:out value="${ version.type }"/></td>

                <td><c:out value="${ version.producer.aPackage.type }"/></td>
                <td><c:out value="${ version.producer.aPackage.quantity }"/></td>
                <td><c:out value="${ version.producer.aPackage.price }"/></td>

                <td><c:out value="${ version.producer.dosage.count }"/></td>
                <td><c:out value="${ version.producer.dosage.period }"/></td>

                <td><c:out value="${ version.producer.certificate.number }"/></td>
                <td><c:out value="${ version.producer.certificate.issueDate }"/></td>
                <td><c:out value="${ version.producer.certificate.organization }"/></td>
                <c:choose>
                    <c:when test="${version.producer.certificate.getClass() eq 'class by.training.xml.entity.Certificate'}">
                        <td>-</td>
                    </c:when>
                    <c:otherwise>
                        <td><c:out value="${ version.producer.certificate.expirationDate }"/></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
       </c:forEach>

</table>
</body>
</html>
