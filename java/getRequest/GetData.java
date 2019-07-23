package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetData {

    String baseURL = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    /**
     * This method checks the state of code
     * test is passed if method return 200
     */
    @Test
    public void testResponseCode(){

        Response resp = RestAssured.get(baseURL);
        int code = resp.statusCode();
        System.out.println("Status code is " + code);
        Assert.assertEquals(200, code);
    }
    /**
     * This test return all the data in JSON format using specify url
     * it also shows how long it takes
     */
    @Test
    public void testBody(){
        Response resp = RestAssured.get(baseURL);
        long time = resp.getTime();
        String data = resp.asString();
        System.out.println("Data is " + data);
        System.out.println("Response time is " + time);
    }

    /**
     * This testdoes the same thing as the testResponseCode but takes the wrong data
     */
    @Test
    public void testResponseCodeInvalid(){

        Response resp = RestAssured.get(baseURL);
        int code = resp.statusCode();
        System.out.println("Status code is " + code);
        Assert.assertEquals(400, code);
    }
}
