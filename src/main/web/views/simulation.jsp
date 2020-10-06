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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script
            src="http://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous">

    </script>
    <style>
        * {
            font-family: 'Poppins', sans-serif;
            color: var(--secondary);
        }

        button {
            outline: none;
        }

        .simulation-container {
            background-color: var(--primary);
            height: 100%;
            width: 60%;
            clip-path: polygon(10% 0, 100% 0, 100% 100%, 0% 100%);
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
            height: 80%;
        }

        #config-div {
            display: flex;
            flex-direction: column;
            width: 75%;
            margin: 0 10% 0 10%;
            text-align: center;
        }
    </style>
    <script>
        let sim
        let totalEarnings = 0;
        const config = {
            name: " ",
            lots: 0,
            price: 0,
        };
        const API_URL = "http://localhost:8080/SimulationServlet";

        function simulate() {
            $.ajax({
                url: API_URL,
                type: 'POST',
                success: (res) => {
                    console.log(res);
                    if (res) {
                        let tableElement = "<tr>";
                        for (let key in res) {
                            if (res.hasOwnProperty(key))
                                tableElement += "<td>" + res[key] + "</td>";
                        }
                        tableElement += "</tr>";
                        $('#car-table tbody').append(tableElement);
                    }
                },
                complete: () => {
                    sim = setTimeout(simulate, 100)
                }
            })
        }

        function getConfig() {
            $.ajax({
                url: API_URL,
                type: "POST",
                data: {
                    "cmd": "config",
                },
                success: (res) => {
                    console.log(res);
                    if (res) {
                        config.name = res["Parkhausname"];
                        config.lots = Number(res["Parkplätze gesamt"]);
                        config.price = parseFloat(res["Preis"]);
                    }
                    $('#carParkName').text("Parkhausname: " + config.name);
                    $('#carParkLots').text("Freie Parkplätze: " + config.lots);
                    $('#carParkPrice').text("Preis pro Stunde: " + config.price + "0€");
                }
            })
        }

        function resetSimulation() {
            $.ajax({
                url: API_URL,
                type: "POST",
                data: {
                    "cmd": "reset"
                },
                success: (res) => {
                    $('#car-table').find("tr:gt(0)").remove();
                }
            });


        }

        $(document).ready(() => {
            getConfig();

            $('#start').on('click', () => {
                $('#start').hide();
                $('#stop').show();
                $('#reset').show();
                simulate();
            })
            $('#stop').hide().on('click', () => {
                clearTimeout(sim);
                $('#stop').hide();
                $('#start').show()
            })
            $('#reset').hide().on('click', () => {
                resetSimulation();
            })
        });


    </script>
</head>
<body>
<jsp:include page="/templates/container.html"/>
<div class="simulation-container">
    <div class="control-container">
        <h1>Simulation</h1>
        <button id="start" class="btn btn-primary">Start Simulation</button>
        <button id="stop" class="btn btn-danger">Stop Simulation</button>
        <button id="reset" class="btn btn-warning">Reset</button>
    </div>
    <div id="config-div">
        <h6 id="carParkName"></h6>
        <h6 id="carParkLots"></h6>
        <h6 id="carParkPrice"></h6>
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
</div>
</body>
</html>
