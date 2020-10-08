<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Author: Jannik Hausin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simulation</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script
            src="http://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous">
    </script>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    <script src="../scripts/simulation.js"></script>
    <style>
        * {
            font-family: 'Poppins', sans-serif;
            color: var(--secondary);
        }

        button {
            outline: none;
        }

        hr {
            width: 10%;
        }

        .simulation-container {
            background-color: var(--primary);
            height: 100%;
            width: 60%;
            clip-path: polygon(12.5% 0, 100% 0, 100% 100%, 0% 100%);
        }

        span {
            width: 30%;
        }

        .control-container {
            text-align: center;
            margin: 2em;
        }

        .table-container {
            text-align: center;
            margin: 0 10% 0 15%;
            font-size: 36px;
            width: 75%;
            height: 50%;
            overflow-y: scroll;
        }

        thead {
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            z-index: 100;
        }

        .earnings {
            display: flex;
            justify-content: space-evenly;
            margin: 30px 10% 0 15%;

        }

        .h-divider {
            margin: 0 0 0 15%;
        }

        .h-divider hr {
            border: none;
            background-color: grey;
            height: 1px;
        }

        .info {
            position: absolute;
            bottom: 10px;
            margin-left: 15px;
        }

        .chart-button {
            margin: 30px 10% 0 15%;
            display: flex;
            justify-content: flex-end;
        }

        .chart-container {
            display: flex;
            position: fixed;
            top: 12.5%;
            left: 12.5%;
            z-index: 5;
            background-color: white;
            height: 75%;
            width: 75%;
            border-radius: 5px;
            -webkit-box-shadow: 0 0 31px -5px rgba(0, 0, 0, 0.75);
            -moz-box-shadow: 0 0 31px -5px rgba(0, 0, 0, 0.75);
            box-shadow: 0 0 31px -5px rgba(0, 0, 0, 0.75);
            justify-content: space-evenly;
            flex-direction: row;
        }


        .chart-container #close {
            position: absolute;
            right: 5px;
            top: 0;
            border: none;
            background: none;
            font-size: 30px;
        }

        #config-div {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            width: 75%;
            margin: 0 10% 10px 15%;
            text-align: center;
        }

        .blurred {
            display: none;
            position: absolute;
            z-index: 4;
            bottom: 0;
            top: 0;
            left: 0;
            right: 0;
            backdrop-filter: blur(5px);
        }
    </style>
</head>
<body>
<jsp:include page="/templates/container.html"/>
<div class="simulation-container">
    <div class="control-container">
        <h1>Simulation</h1>
        <button id="start" class="btn btn-primary">Start Simulation*</button>
        <button id="stop" class="btn btn-danger">Stop Simulation</button>
        <button id="reset" class="btn btn-warning">Reset</button>
    </div>
    <div id="config-div">
        <span id="carParkName" class="badge badge-info"></span>
        <span id="carParkLots" class="badge badge-info"></span>
        <span id="carParkPrice" class="badge badge-info"></span>
    </div>
    <div class="table-container">
        <table id="car-table" class="table table-fixed">
            <thead>
            <tr>
                <th scope="col">Customer Type</th>
                <th scope="col">License Plate</th>
                <th scope="col">Entry Date</th>
                <th scope="col">Exit Date</th>
                <th scope="col">Price in €</th>
                <th scope="col">Ticket ID</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="h-divider">
        <hr>
    </div>
    <div class="earnings">
        <span id="totalCustomer" class="badge badge-secondary"></span>
        <span id="earnings" class="badge badge-success"></span>
    </div>
    <div class="chart-button">
        <button id="chart-button" class="btn btn-primary">Show Charts</button>
    </div>
    <div class="info">
        <small>* Wenn keine Konfiguration angegeben wird, startet die Simulation mit der <i>DEFAULT</i>
            Konfiguration.</small>
    </div>

</div>
<div id="chart-container" class="chart-container">
    <button id="close"><span aria-hidden="true">&times;</span></button>
    <div id="customer-type-chart">
    </div>
    <div id="statistics-bar-chart">
    </div>
</div>
<div class="blurred">

</div>
</body>
</html>
