<%--
  Created by IntelliJ IDEA.
  User: JANNIK
  Date: 20.08.2020
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Parkhaus Simulation </title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400&display=swap" rel="stylesheet">
  <link rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
        crossorigin="anonymous">
  <style>
    *{
      font-family: 'Poppins', sans-serif;
      color: white;
    }
    body{
      background-image: url("./ressources/parking-lot.jpg");
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
      margin: 0;
      padding: 0;
    }
    .container{
      background-color: rgb(49, 49, 49);
      width: 25%;
      height: 100%;
      animation: fade-in 1.5s;
    }
    @keyframes fade-in{
      from{opacity: 0}
      to{opacity: 1}
    }
    .container h1{
      padding-top: 40px;
      text-align: center;
    }
    </style>
<body>
  <div class="container">
    <h1>Parkhaus Simulation</h1>

  </div>
</body>

</html>