<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Receipt</title>
</head>
<body>

<h2>Payment Receipt</h2>

<img src="<%=request.getAttribute("photo")%>" width="120"><br><br>

Student ID: <%=request.getAttribute("id")%><br>
Name: <%=request.getAttribute("name")%><br>
Email: <%=request.getAttribute("email")%><br>
Phone: <%=request.getAttribute("phone")%><br>

Total Fee: <%=request.getAttribute("total")%><br>
Paid Amount: <%=request.getAttribute("paid")%><br>
Due Amount: <%=request.getAttribute("due")%><br>

Bank: <%=request.getAttribute("bank")%><br>
Date: <%=request.getAttribute("date")%><br>
Last Date: <%=request.getAttribute("lastdate")%><br>

</body>
</html>