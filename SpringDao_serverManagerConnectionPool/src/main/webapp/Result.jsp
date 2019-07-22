<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose >
<c:when test="${not empty result }">
<table>
<tr>
<th>eno</th><th>ename</th><th>job</th><th>sal</th>
</tr>
<c:forEach var="emp" items="${result }">
<tr>
<td><c:out value="${emp.empno }"></c:out></td>
<td><c:out value="${emp.ename }"></c:out></td>
<td><c:out value="${emp.job}"></c:out></td>
<td><c:out value="${emp.sal }"></c:out></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1>No employee found......</h1>
</c:otherwise>
</c:choose>

    