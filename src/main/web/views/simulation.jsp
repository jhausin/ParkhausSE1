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

        .inner-container {
            text-align: center;
            margin: 20px;
            font-size: 36px;
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
                    if (result) {
                        cars.push(result);
                        var trHtml = "";
                        $.each(result, (i, car) => {
                            trHtml += "<tr><td>" + car.CustomerType +
                        })
                    }
                },
                complete: () => {
                    sim = setTimeout(simulate, 2000)
                }
            })
        }

        $(document).ready(() => {
            $('#form').submit((event) => {
                event.preventDefault();
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
    <div class="inner-container">
        <h1>Simulation</h1>
        <div class="config-container">

        </div>
        <div class="start-container">
            <form id="form" class="simulation-form">
                <button id="start" type="submit">Start Simulation</button>
            </form>
        </div>
        <button id="stop">Stop Simulation</button>
        <table>
        </table>
    </div>
</div>
</div>

</body>
</html>
