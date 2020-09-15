<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        #config{

        }
    </style>
    <script>
        function showConfig(){
            let cfg = document.getElementById("config");
            cfg.style.display="block";
        }
    </script>
</head>
<body>
<jsp:include page="templates/container.html"/>
<div class="simulation-container">
    <div class="inner-container">
        <h1>Simulation</h1>
        <div class="config-container">

        </div>
        <div class="start-container">
            <form action="${pageContext.request.contextPath}/simulationServlet" method="post">
                <button type="submit" onclick="">Start Simulation</button>
            </form>
        </div>
        <div id="config">
            <c:choose>
                <c:when test="${empty requestScope.config}">
                    Bitte Parkhaus konfigurieren.
                </c:when>
                <c:otherwise>
                    Press Start to begin...
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

</body>
</html>
