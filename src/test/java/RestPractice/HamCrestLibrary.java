package RestPractice;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HamCrestLibrary {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://3.89.115.0";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
        // above will generate a BASE REQUEST URL OF http://52.23.254.102:8000/api
    }



    @Test
    public void DoingAssertionWithHamcrest_ForSpartan(){

        //Response response= given().pathParam("my_id",3).get("/spartans/{my_id}");
        //response.prettyPrint();
        given()
                .pathParam("my_id",3).
        when()
                .get("/spartans/{my_id}").
        then()
                .assertThat()
                .statusCode(equalTo(200))
                .contentType(ContentType.JSON)
                .body("id",equalTo(3))
                .body("gender", equalToIgnoringCase("male"))
                .body("phone", hasToString("6105035231"));

    }



    // hamcrest is a testing library to provide many built in testing methods
    // that comes from hamcrest Matcher
    @Test
    public void Calculation_Test(){

        int a = 10 ,b = 20 ;

        assertEquals(30, a+b) ;

        assertThat(a+b, equalTo(30));
        assertThat(a+b, greaterThan(20) );

    }



    @Test
    public void arrayTest(){

        int[] nums = {1,4,6,7,8} ;

        //Matchers.contains()
       //assertThat(nums  , hasItemInArray(1));
       // assertThat(1 ,hasItemInArray(1) );


    }


}
