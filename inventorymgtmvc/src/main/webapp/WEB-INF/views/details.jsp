<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Supplier Details</title>
</head>
<body>

<h1>Supplier Details </h1>

id is <c:out value="${supplier.id}"  />
<br>
name is <c:out value="${supplier.name}"  />
<br>
  
Item ID is <c:out value="${supplier.item.id}"  />
<br>
Item Name is <c:out value="${supplier.item.name}"  />
<br>

<button><a href="/logout"> Log out </a></button>

</body>
</html>