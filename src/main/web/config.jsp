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
        :root{
            --primary: rgba(255,255,255, 0.95);
            --secondary: rgb(49,49,49);
        }
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
            margin: 20px 20px 20px 100px;
            font-size: 36px;
        }
        .config-form{
            display: flex;
            flex-direction: column;
            margin-left: 12.5%;
            width: 75%;
            font-size: 25px;
        }
        .config-form input{
            border: none;
            border-bottom: 1px solid var(--secondary);
            background: none;
            max-width: 20%;
            font-size: 24px;
        }
        .config-form button:hover {
            font-size: 26px;
        }
        .config-form button {
            padding:0;
            width: 20%;
            height: 30px;
            margin-top: 20px;
            border: none;
            background: none;
            font-size: 24px;
        }
        .input-div{
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>
<body>
    <jsp:include page="templates/container.html"/>
    <div class="simulation-container">
        <div class="inner-container">
            <h1>Parkhaus Konfigurieren</h1>
        </div>
        <form action="${pageContext.request.contextPath}/ConfigServlet"  method="POST" class="config-form">
            <div class="input-div">
                <label for="name">Parkhaus Name:</label>
                <input type="text" name="name" id="name" value="Car Park">
            </div>
            <div class="input-div">
                <label for="lots">Anzahl Parkplätze:</label>
                <input type="number" name="lots" id="lots" value="40">
            </div>
            <div class="input-div">
                <label for="women">Davon Frauenparkplätze:</label>
                <input type="number" name="women" id="women" value="6">
            </div>
            <div class="input-div">
                <label for="disabled">Davon Behindertenparkplätze:</label>
                <input type="number" name="disabled" id="disabled" value="3">
            </div>
            <div class="input-div">
                <label for="local">Davon Anwohnerparkplätze:</label>
                <input type="number" name="local" id="local" value="12">
            </div>
            <div class="input-div">
                <label for="bike">Davon Motorradparkplätze:</label>
                <input type="number" name="bike" id="bike" value="4">
            </div>
            <div class="input-div">
                <label for="price">Preis/Stunde:</label>
                <input type="number" name="price" id="price" step="any" value="1.50">
            </div>
            <button type="submit"><i class="fas fa-paper-plane" ></i> Submit</button>
        </form>
    </div>

</body>
</html>
