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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <script
            src="http://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <style>

        :root {
            --primary: rgba(255, 255, 255, 0.95);
            --secondary: rgb(49, 49, 49);
        }

        * {
            font-family: 'Poppins', sans-serif;
            color: var(--secondary);
        }

        button {
            outline: none;
        }

        .config-container {
            background-color: var(--primary);
            width: 60%;
            clip-path: polygon(10% 0, 100% 0, 100% 100%, 0% 100%);
        }

        .inner-container {
            text-align: center;
            margin: 20px 20px 20px 100px;
            font-size: 2rem;
        }

        .config-form {
            display: flex;
            flex-direction: column;
            margin: 10% 12.5%;
            width: 80%;
            font-size: 1.3rem;
        }

        .config-form input {
            border: none;
            border-bottom: 1px solid var(--secondary);
            background: none;
            max-width: 20%;
            font-size: 1.2rem;
        }

        .config-form button:hover {
            transform: scale(1.1);
            cursor: pointer;
        }

        .config-form button {
            font-size: 2rem;
            width: 20%;
            margin-top: 5%;
            border: none;
            background: none;
        }

        .input-div {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }

        .alert {
            display: none;
        }

        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>
<body>
<script>
    $('document').ready(() => {
        $('#form').submit((event) => {
            event.preventDefault();
            const data = $('#form').serializeArray();
            $.ajax({
                url: "http://localhost:8080/ConfigServlet",
                type: 'POST',
                data: data,
                error: (xhr, error, status) => {
                    $('.alert').text("Konfiguration ungültig. Bitte Eingabe überprüfen.")
                        .removeClass("alert-success")
                        .addClass("alert-danger")
                        .show();
                },
                success: (xhr, error, status) => {
                    $('.alert')
                        .text("Konfiguration erfolgreich gespeichert.")
                        .removeClass("alert-danger")
                        .addClass("alert-success")
                        .show();
                }
            })
        });
        $('form').on('keyup change paste', 'input', () => {
            $('.alert').hide();
        })
    })
</script>
<jsp:include page="/templates/container.html"/>
<div class="config-container">
    <div class="inner-container">
        <h1>Parkhaus Konfigurieren</h1>
    </div>
    <form id="form" class="config-form">
        <div class="alert alert-success" role="alert">
        </div>
        <div class="input-div">
            <label for="name">Parkhaus Name:</label>
            <input type="text" name="name" id="name" value="Car Park">
        </div>
        <div class="input-div">
            <label for="totalLots">Anzahl Parkplätze:</label>
            <input type="number" name="totalLots" id="totalLots" value="40">
        </div>
        <div class="input-div">
            <label for="womenLots">Davon Frauenparkplätze:</label>
            <input type="number" name="womenLots" id="womenLots" value="6">
        </div>
        <div class="input-div">
            <label for="disabledLots">Davon Behindertenparkplätze:</label>
            <input type="number" name="disabledLots" id="disabledLots" value="3">
        </div>
        <div class="input-div">
            <label for="localLots">Davon Anwohnerparkplätze:</label>
            <input type="number" name="localLots" id="localLots" value="12">
        </div>
        <div class="input-div">
            <label for="bikeLots">Davon Motorradparkplätze:</label>
            <input type="number" name="bikeLots" id="bikeLots" value="4">
        </div>
        <div class="input-div">
            <label for="price">Preis/Stunde:</label>
            <input type="number" name="price" id="price" step="any" value="1.50">
        </div>
        <button type="submit"><i class="fas fa-paper-plane"></i> Submit</button>
    </form>
</div>

</body>
</html>
