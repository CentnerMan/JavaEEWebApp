<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.vlsv.repositories.ProductRepository" %>
<%@ page import="ru.vlsv.entity.Product" %>
<%@ page import="java.sql.SQLException" %><%--

  Created by IntelliJ IDEA.
  @author Anatoly Lebedev
  @link https://github.com/Centnerman
  Date: 05.06.2020 Time: 13:09
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<% ProductRepository repository = (ProductRepository) application.getAttribute("productRepository"); %>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Product Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    <% try {
        for (Product prod : repository.findAll()) { %>
        <tr>
            <th><%= prod.getId()%></th>
            <th><%= prod.getProductName()%></th>
            <th><%= prod.getDescription()%></th>
            <th><%= prod.getPrice()%></th>
        </tr>

        <% }
    } catch (SQLException e) {
        e.printStackTrace();
    } %>
</table>
<hr/>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Product Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    <% request.setAttribute("products", repository.findAll()); %>
    <c:forEach items="${products}" var="prod">
        <tr>
            <th>${prod.id}</th>
            <th>${prod.productName}</th>
            <th>${prod.description}</th>
            <th>${prod.price}</th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
