package utilities;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Author: Jannik Hausin
 */
public class requestUtilities {
    static public void getRequestParams(HttpServletRequest request) throws IOException {
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {

            String paramName = paramNames.nextElement();

            System.out.print(paramName + ":");
            System.out.print(" ");

            String[] paramValues = request.getParameterValues(paramName);
            for (String paramValue : paramValues) {
                System.out.print(paramValue);
                System.out.print("\n");
            }

        }

    }
}
