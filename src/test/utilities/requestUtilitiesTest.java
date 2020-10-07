/**
 *Author: Joshua Bäuml
 */
package utilities;

import utilities.requestUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static utilities.requestUtilities.createJson;


class requestUtilitiesTest {

    HttpServletRequest req;

    @BeforeEach
    void init(){
        req=createMock(HttpServletRequest.class);
    }

    @Test
    void getRequestParams_() {

    }

    @Test
    void getContextParams() {
    }

    @Test
    void setContextParam() {
    }

    @Test
    void createJson_() {
        expect(req.getParameter("name")).andReturn("Parkhaus").times(1);
        String s=createJson(req).toString();
        assertEquals("name: Parkhaus",s);
    }

    @Test
    void checkAttributes() {
    }
}