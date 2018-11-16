/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.youbora;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class YouboraDAOImplIT {

    public YouboraDAOImplIT() {
    }
    YouboraDAOImpl instance = new YouboraDAOImpl();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws Exception {

//        String link = "https://api.youbora.com/ob-brazil/data?fromDate=last6hours&granularity=none&metrics=playtime%2CbufferRatioTracking%2CstartFailuresTracking%2CexitsTracking%2CbitrateTracking%2CjoinTimeTracking&operation=reduceJoin&type=all&timeGap=false&token=MTNmcHlGOVI1MWZlTlV6Y01VMkNLa0lHZERvK2tEWjhRTEZlQzMyV0JLVzZIUTVDa1F1MEdFczBNNVYvL3FYZ0t1QlVVaVhKQjhoK1ltK2tyTWFnZGFBY09sb2pmQnlwbFpnVFlZa3NNcFdKbk1FSXpIUDBSbFhROUhBYkl1MFcxaCtvU3dwL2tQblRSOU9tL3ZyS0RoZStFOUdVMExPQlMwclNJbmdSMUVKNEtqZWJwTzJ0WnhHYW4waVhscFdJd3FZOEtaU1oxeHZ6Ny81ZlJuRVVXM1d6K1BIMkZiU0k0OURxVVpSa01Md1B2Mjl4YjZFVDRwb3ozblVCSVcyMXdRWFM5RXJwNkpueUpNZ2hjQ21aZ1ZUbEM0UVkwVURwTXArbGF0NnJaSlR2a3RQTWVKVjVIZ1hvRHRuNkYxZEZFaHBNRDkxSG5RUVh2eFVGa0NHUlBNV0sveFQ3TWFaTU50Z2pZbmhKbkt3dE9zY1Bia1BRWm5DbFk1dC8zR2NZU1o3VU04YnhkaXFMY0U0aHhjcitMdVpKdkJkS3AzTXNGWWlBUWJRU245TDJ3TmpQNHNUZnR3ZUI4N2dJbkVHdy9qMk00eHh2NlBXU1lOT1JjUE9iUFNPdHNObHlqdm1DU25zNkFDTTBxL2h3WnRvdis2R3gxZVNDakpaWTNhMnRZWUxIQ0w2Z2FuaTU5bVlEZUhKNSt2QWRycmxDL3l2WDYzLzVpVFB1MWVDc2xja0crbTJEVFVxRXNxMmxNWnBUN0ZodDZTbS9tc3NEMmpORnJveWFsQWpxR29vZVZ4dnFvUkR1eFFxckgrWjhQMGxVVG8rOVkyRlY1Q1ZhOC9hWmVZSTIxSVVMY2d0UDQrVXBDenlqRXpUS3VnL2NnZlJ1dHQrR05lWEwvQlJ1QzhFUXJydjBBRVY1ejlKb3hDZEt3VER5dUN6aVY2U1hNeTNtV3VneWNDRTh0MDMxSjBpUkpOdUxibVFoa05NREU3SXQ1ZVBibkx1WkVYUVVyY3lieGE2Z2xSYkQrUVlWZWN0N3dnR01XTXJBZlUrcmlOL1NibDZRL1J2ZEFqTVFleS9haG53b3J5SnJUc0Z4UStlT3hsTU1XbEhKQlhpUG1uYlZFdGJjbGl1aThHUS9pRDJTNVo0cDZsRlNKcDhKU1ZRaktVaVduY0VRdWJtK1k2Ykh3L25rQ054SWwrQUJTZDlZOC9NeFZoNUdNbDU4UGZqem8xV3Mya0NmRmNCQjBCcmpZbjloa1BvOFJVY3RHb3VvZlhTck9NMm9EV3FvZTlTMnFodGNualVDbnI5NmNGcGk4M2kxR2VmWWdWUmMvVTNhcTdhNEFBK3V0MWlaM2FqZ2ZHaTFTNytXSk55VmtSTGJHSWtrMHdHemo0MlJmOTNqSUdUVDQ1MDB4Z0l0b3l4Nm5UT2V1SFcvaldZc09SMU0xS1BsQytLeVNzaktkOHh2Mm9SU2xnPT0%3D&filter=%5B%7B%22name%22%3A%22uniquefilter%22%2C%22rules%22%3A%7B%22qos_unique_user%22%3A%5B%22TV-ARQ-814VTZ86RH-050%22%5D%7D%7D%5D&_=1541434203461";
//        System.out.println(URLDecoder.decode(link, "UTF-8"));
        Date d = Calendar.getInstance().getTime();
        Long timeout = d.getTime() + 600000;
        String preUrl = "/ob-brazil/data?fromDate=last6hours&granularity=none&type=all&metrics=playtime&dateToken=" + timeout + "movistargo2016";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(preUrl.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);
        String filter = URLEncoder.encode("[{\"name\":\"uniquefilter\",\"rules\":{\"qos_unique_user\":[\"TV-ARQ-814VTZ86RH-050\"]}}]", "UTF-8");
        String url = "http://api.youbora.com/ob-brazil/data?fromDate=last6hours&granularity=none&type=all&metrics=playtime&dateToken=" + timeout + "&token=" + hashtext + "&filter=" + filter;
        
        System.out.println(url);
    }

    /**
     * Test of listaEqp method, of class YouboraDAOImpl.
     */
    @Test
    public void testListaEqp() throws Exception {
        System.out.println("listaEqp");
        String designadorTv = "";

        instance.listaEqp(designadorTv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
