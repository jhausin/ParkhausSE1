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
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
  <style>
    body{
      background-image: url("images/parking-lot.jpg");
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
      text-align: center;
      color: white;
      font-family: 'Poppins', sans-serif;
    }
    .container{
      display:flex;
      width: 60%;
      height: 90%;
      margin: 40px auto;
      padding: 20px;
      background-color:rgba(45, 43, 53, 0.95);
      border-radius: 4px;

      animation: fade-in 2s;
      -webkit-animation: fade-in 2s;
      -moz-animation: fade-in 2s;
      -ms-animation: fade-in 2s;
      -o-animation: fade-in 2s;
    }
    @keyframes fade-in {
      from{opacity: 0;}
      to{opacity:1;}
    }
    @-moz-keyframes fade-in{
      from{opacity: 0;}
      to{opacity: 1;}
    }
    @-ms-keyframes fade-in{
      from{opacity: 0;}
      to{opacity: 1;}
    }
    @-o-keyframes fade-in{
      from{opacity: 0;}
      to{opacity: 1;}
    }
    @-webkit-keyframes fade-in{
      from{opacity: 0;}
      to{opacity: 1;}
    }
    .form{
      display:flex;
      flex-direction: column;
      align-items: center;
    }
    .form a{
      text-decoration: none;
      color: white;
      margin: 20px;
      border: 1px solid white;
      border-radius: 3px;
      padding: 10px;

    }
    .form a:hover{
      color: rgb(43, 43, 43);
      background-color: white;

    }
    .info p{
      margin: 20px;
    }
    .git{
      position: fixed;
      bottom: 10px;
      left: 10px;
    }
    .git a{
      text-decoration: none;
      color: white;
    }
  </style>
</head>
<body>
<div class="container fade-in">
  <div class="info">
    <h1>Parkhaus Simulation</h1>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
      Massa vitae tortor condimentum lacinia quis vel eros donec.
      Diam maecenas ultricies mi eget mauris pharetra et.
      Nam aliquam sem et tortor consequat id porta nibh venenatis.
      In mollis nunc sed id semper risus in hendrerit gravida.
      Mauris rhoncus aenean vel elit scelerisque mauris pellentesque.
      Facilisis leo vel fringilla est ullamcorper
    </p>
  </div>
  <hr>
  <form class="form">
    <a href="">
      <i class="fas fa-wrench"></i><br>
      Parkhaus konfigurieren
    </a>
    <a href="">
      <i class="fas fa-cog"></i><br>
      Konfiguration anzeigen
    </a>
    <a href="">
      <i class="fas fa-car"></i> <br>
      Parkhaus simulieren
    </a>
  </form>
</div>
<div class="git">
  <a href="https://www.github.com/jhausin/ParkhausSE1">
    <i class="fab fa-github"></i>
    Git
  </a>
</div>
</body>

</html>