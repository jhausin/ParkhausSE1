/*
 * Author: Jannik Hausin
 */

let sim;
const park = {
    name: "",
    lots: 0,
    price: 0,
    earnings: 0,
    totalCustomers: 0,
    totalDuration: 0,
    customers: {
        usual: 0,
        women: 0,
        disabled: 0,
        local: 0,
        bike: 0,
    }
};
const API_URL = "http://localhost:8080/SimulationServlet";

$(document).ready(() => {
    getConfig();
    resetSimulation();

    $('#start').on('click', () => {
        $('#start').hide();
        $('#stop').show();
        $('#reset').show();
        $('#chart-button').hide();
        simulate();
    })
    $('#stop').hide().on('click', () => {
        clearTimeout(sim);
        $('#stop').hide();
        $('#start').show();
        $('#chart-button').show();
    })
    $('#reset').hide().on('click', () => {
        resetSimulation();
    })
    $('#chart-button').hide().on('click', () => {
        plotPieChart();
        plotBarChart();
        $('#chart-container').show();
        $('.blurred').show();
    })
    $('#close').on('click', () => {
        $('#chart-container').hide();
        $('.blurred').hide();
    })
    $('#chart-container').hide();
});

function simulate() {
    $.ajax({
            url: API_URL,
            type: 'POST',
            success: (res) => {
                console.log(res);
                if (res) {
                    let tableElement = "<tr>";
                    if (res.hasOwnProperty("CustomerType")) {
                        park.totalCustomers++;
                        park.earnings += Number(res["Price"]);
                    }
                    for (let key in res) {
                        if (res.hasOwnProperty(key)) {
                            if (key === "freeSpaces") {
                                park.lots = res[key];
                                $('#carParkLots').text("Freie Parkplätze: " + park.lots);
                            } else if (key === "duration") {
                                park.totalDuration += Number(res[key]);
                            } else {
                                if (res[key] === "USUAL") park.customers.usual++;
                                else if (res[key] === "WOMEN") park.customers.women++;
                                else if (res[key] === "DISABLED") park.customers.disabled++;
                                else if (res[key] === "LOCAL") park.customers.local++;
                                else if (res[key] === "BIKE") park.customers.bike++;
                                tableElement += "<td>" + res[key] + "</td>";
                            }
                        }
                    }
                    tableElement += "</tr>";
                    $('#car-table tbody').append(tableElement);
                    $('#totalCustomer').text("Kunden insgesamt: " + park.totalCustomers);
                    $('#earnings').text("Einnahmen: " + park.earnings + "€");
                }
            },
            complete: () => {
                sim = setTimeout(simulate, 500)
            }
        }
    )
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
                park.name = res["Parkhausname"];
                park.lots = Number(res["Parkplätze gesamt"]);
                park.price = parseFloat(res["Preis"]);
            }
            $('#carParkName').text("Parkhausname: " + park.name);
            $('#carParkLots').text("Freie Parkplätze: " + park.lots);
            $('#carParkPrice').text("Preis pro Stunde: " + park.price + "0€");
            $('#earnings').text("Einnahmen: " + park.earnings + "€");
            $('#totalCustomer').text("Kunden insgesamt: " + park.totalCustomers);

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
            park.earnings = 0;
            for (let key in park.customers) {
                park.customers[key] = 0;
            }
            park.totalCustomers = 0;
            getConfig();
        }
    });


}

function plotPieChart() {
    const data = [{
        values: [
            park.customers.usual,
            park.customers.women,
            park.customers.disabled,
            park.customers.local,
            park.customers.bike
        ],
        labels: ["USUAL", "WOMEN", "DISABLED", "LOCAL", "BIKE"],
        type: "pie"
    }]
    const layout = {
        height: 600,
        width: 600,
        title: "Kundentyp",
    }
    Plotly.newPlot("customer-type-chart", data, layout);
}

function plotBarChart() {
    const avgEarnings = park.earnings / park.totalCustomers;
    const avgDuration = park.totalDuration / park.totalCustomers;

    const data = [{
        x: ["Durschnittliche Parkkosten", "Durschnittliche Parkdauer"],
        y: [avgEarnings, avgDuration],
        type: "bar",
    }]
    const layout = {
        height: 600,
        width: 600,
        title: "Statistik",
    }
    Plotly.newPlot("statistics-bar-chart", data, layout);
}



