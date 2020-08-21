<%--
  Created by IntelliJ IDEA.
  User: jannik
  Date: 21.08.20
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Configuration
    </title>

</head>
<body>
    <form action="${pageContext.request.contextPath}/ConfigServlet" method="GET">
        Name:<input type="text" name="name">
        Anzahl Parkplätze:<input type="number" name="parkingLots">
        Frauenparkplätze:<input type="number" name="women">
        Abonnenten Parkplätze:<input type="number" name="abo">
        Behinderten Parkplätze:<input type="number" name="disabled">
        Preis:<input type="number" name="price">
        <input type="submit" value="submit">
    </form>
</body>
</html>
