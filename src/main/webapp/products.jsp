<%@ page import="ru.vlsv.repositories.ProductRepository" %>
<%@ page import="ru.vlsv.entity.Product" %><%--
  Created by IntelliJ IDEA.
  @author Anatoly Lebedev
  @link https://github.com/Centnerman
  Date: 01.04.2020 Time: 13:09
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <% for (Product prod : repository.findAll()) { %>
    <tr>
        <th><%= prod.getId()%></th>
        <th><%= prod.getProductName()%></th>
        <th><%= prod.getDescription()%></th>
        <th><%= prod.getPrice()%></th>
    </tr>

    <% } %>
</table>

</body>
</html>
