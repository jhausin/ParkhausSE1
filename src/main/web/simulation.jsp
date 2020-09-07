<%--
  Author: Jannik Hausin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Configuration</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <style>

        * {
            font-family: 'Poppins', sans-serif;
            color: var(--secondary);
        }
        .simulation-container{
            background-color: var(--primary);
            animation: fade-in 1s;
            height: 90%;
            width: 70%;
            margin: 30px 30px 30px 0;
            clip-path: polygon(10% 0, 100% 0, 100% 100%, 0% 100%);
        }
        .inner-container{
            text-align: center;
            margin: 20px;
            font-size: 36px;
        }
    </style>
</head>
<body>
<jsp:include page="templates/container.html"/>
<div class="simulation-container">
    <div class="inner-container">
        <h1>Simulation</h1>
    </div>
</div>

</body>
</html>
