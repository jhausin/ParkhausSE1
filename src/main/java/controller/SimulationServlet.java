package controller;

import interfaces.VehicleIF;
import models.CarPark;
import models.Config;

import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import static utilities.responseUtilities.createVehicleAsJson;

@WebServlet(name = "SimulationServlet")
public class SimulationServlet extends HttpServlet {
    CarPark carPark;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext ctx = req.getServletContext();
        carPark = (CarPark) ctx.getAttribute("carPark");
        if (carPark == null) {
            carPark = new CarPark(new Config());
            System.out.println(carPark);
            ctx.setAttribute("carPark", carPark);
        }
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            carPark.enter();
            System.out.print("Enter, ");
        } else {

            VehicleIF v = carPark.leaveRandom();
            if (v != null) {
                JsonObject car = createVehicleAsJson(v,carPark.getFreeSpaces());
                System.out.println(car);
                res.setContentType("application/json");
                res.getWriter().print(car);
                res.getWriter().flush();
            }
        }
        res.setStatus(HttpServletResponse.SC_OK);
    }
}
