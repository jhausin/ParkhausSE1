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
    public static void getContextParams(HttpServletRequest req) throws IOException{
        ServletContext ctx = req.getServletContext();
       Enumeration<String> attributeNames= ctx.getAttributeNames();

       while(attributeNames.hasMoreElements()){
           String attribute = attributeNames.nextElement();
           System.out.println(attribute);
       }
    }
    public static void setContextParam(HttpServletRequest req){
        if(checkAttributes(req)){
            JsonObject Config = createJson(req);
            req.getServletContext().setAttribute("config", Config);
        }
    }
    public static JsonObject createJson(HttpServletRequest req){
            return Json.createObjectBuilder()
                    .add("name", (String) req.getAttribute("name"))
                    .add("lots", (int) req.getAttribute("totalLots"))
                    .add("women", (int) req.getAttribute("womenLots"))
                    .add("disabled", (int) req.getAttribute("disabledLots"))
                    .add("local", (int) req.getAttribute("localLots"))
                    .add("bike", (int) req.getAttribute("bikeLots"))
                    .add("price", (double) req.getAttribute("price"))
                    .build();
    }
    public static boolean checkAttributes(HttpServletRequest request){
        return request.getAttribute("name") != null
                && request.getAttribute("totalLots") != null
                && request.getAttribute("womenLots") != null
                && request.getAttribute("disabledLots") != null
                && request.getAttribute("localLots") != null
                && request.getAttribute("bikeLots") != null
                && request.getAttribute("price") != null;
    }
}

