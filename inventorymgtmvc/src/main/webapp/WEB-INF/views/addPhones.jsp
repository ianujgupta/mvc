<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Item Details</title>
</head>
<body>

<h1>Item Details </h1>

Phone name is <c:out value="${phone.name}"  />
<br>
supplier name is <c:out value="${phone.supplier}"  />
<br>
Storage  is <c:out value="${phone.storagesize}"  />
<br>

<button><a href="/logout"> Log out </a></button>

</body>
</html>