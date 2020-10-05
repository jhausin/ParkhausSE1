package utilities;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Author: Jannik Hausin
 */
public class requestUtilities {
    static public void getRequestParams(HttpServletRequest req) throws IOException {
        Enumeration<String> paramNames = req.getParameterNames();

        while (paramNames.hasMoreElements()) {

            String param = paramNames.nextElement();

            System.out.print(param + ":");
            System.out.print(" ");

            String[] paramValues = req.getParameterValues(param);
            for (String value : paramValues) {
                System.out.println(value);
            }

        }

    }

    public static void getContextParams(HttpServletRequest req) throws IOException {
        ServletContext ctx = req.getServletContext();
        Enumeration<String> attributeNames = ctx.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement();
            System.out.println(attribute);
        }
    }

    public static void setContextParam(HttpServletRequest req) {
        if (checkAttributes(req)) {
            JsonObject Config = createJson(req);
            req.getServletContext().setAttribute("config", Config);
        }
    }

    public static JsonObject createJson(HttpServletRequest req) {
        return Json.createObjectBuilder()
                .add("name", req.getParameter("name"))
                .add("lots", Integer.parseInt(req.getParameter("totalLots")))
                .add("women", Integer.parseInt(req.getParameter("womenLots")))
                .add("disabled", Integer.parseInt(req.getParameter("disabledLots")))
                .add("local", Integer.parseInt(req.getParameter("localLots")))
                .add("bike", Integer.parseInt(req.getParameter("bikeLots")))
                .add("price", Double.parseDouble(req.getParameter("price")))
                .build();
    }

    public static boolean checkAttributes(HttpServletRequest req) {
        if (req.getParameter("name") != null
                && Integer.parseInt(req.getParameter("totalLots")) >= 0
                && Integer.parseInt(req.getParameter("womenLots")) >= 0
                && Integer.parseInt(req.getParameter("disabledLots")) >= 0
                && Integer.parseInt(req.getParameter("localLots")) >= 0
                && Integer.parseInt(req.getParameter("bikeLots")) >= 0
                && Double.parseDouble(req.getParameter("price")) >= 0) {
            return Integer.parseInt(req.getParameter("totalLots")) >
                    (Integer.parseInt(req.getParameter("womenLots")) +
                            Integer.parseInt(req.getParameter("disabledLots")) +
                            Integer.parseInt(req.getParameter("localLots")) +
                            Integer.parseInt(req.getParameter("bikeLots"))
                    );
        }
        return false;


    }
}

