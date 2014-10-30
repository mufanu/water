<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Waterproof - Capacity per Employee</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/jquery.datetimepicker.css">
    <script src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/jquery.datetimepicker.js"></script>
</head>
<body>

<div id="form">
    <h1>Capacity per Employee</h1>

    <form:form method="post" action="${pageContext.servletContext.contextPath}/csv" modelAttribute="search">
        <div class="row">
            <div id="form-group-title" class="form-group col-lg-10">
                <label class="control-label">Date Time from</label>
                <form:input path="dateTimeFrom" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div id="form-group-body" class="form-group col-lg-10">
                <label class="control-label">Date Time to</label>
                <form:input path="dateTimeTo" cssClass="form-control"/>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-lg-10">
                <button type="submit" class="btn btn-default">PDF</button>
                <button type="submit" class="btn btn-default">CSV</button>
                <button type="submit" class="btn btn-default">Preview</button>
            </div>
        </div>
    </form:form>
</div>

<c:if test="${result != null}">
    <div id="result">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Employee key</th>
                    <th>Employee capacity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${result}" var="project">
                    <tr>
                        <td>${project.employeeKey}</td>
                        <td>${project.capacity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

</body>
</html>