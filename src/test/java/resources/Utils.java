package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public  static RequestSpecification requestSpecification;

    public RequestSpecification requestSpecification() throws IOException {

        if (requestSpecification == null) {

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
//AddFilter is applied to our object so that object will have knowledge of logging filter and it will log everything

        requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();

        return requestSpecification;
    }
    return requestSpecification;
}
    public static String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\User\\IdeaProjects\\restAPIBDDFramework\\src\\test\\java\\resources\\global.properties");
       prop.load(fis);
        return prop.getProperty(key);

    }
    public String getJsonPath(Response response,String key){
        String  responseSpecification = response.asString();
        JsonPath jsonPath = new JsonPath(responseSpecification);
        return jsonPath.get(key).toString();

    }
}
