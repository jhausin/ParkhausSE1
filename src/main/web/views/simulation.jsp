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
            animation: fade-in 1s;
            height: 90%;
            width: 70%;
            margin: 30px 30px 30px 0;
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
        }
    </style>
    <script>
        let sim;
        const cars = []

        function simulate() {
            $.ajax({
                url: "http://localhost:8080/SimulationServlet",
                type: 'POST',
                success: (result) => {
                    console.log(result);
                    if (result) {
                        let tableElement = "<tr>";
                        for (let key in result) {
                            if (result.hasOwnProperty(key))
                                tableElement += "<td>" + result[key] + "</td>";
                        }
                        tableElement += "</tr>";
                        $('#car-table tbody').append(tableElement);
                    }
                },
                complete: () => {
                    sim = setTimeout(simulate, 1000)
                }
            })
        }

        $(document).ready(() => {
            $('#start').on('click', () => {
                $('#start').hide();
                simulate();
            })
            $('#stop').on('click', () => {
                clearTimeout(sim);
                $('#start').show()
            })
        });


    </script>
</head>
<body>
<jsp:include page="/templates/container.html"/>
<div class="simulation-container">
    <div class="control-container">
        <h1>Simulation</h1>
        <button id="start">Start Simulation</button>

        <button id="stop">Stop Simulation</button>
    </div>
    <div class="table-container">
        <table id="car-table" class=" table">
            <thead>
            <tr>
                <th scope="col">Customer Type</th>
                <th scope="col">License Plate</th>
                <th scope="col">Entry Date</th>
                <th scope="col">Exit Date</th>
                <th scope="col">Price</th>
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
