package com.vaytee.shapes;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShapesApplicationTests {

    @LocalServerPort
    private int port;

    private final SessionFilter sessionFilter = new SessionFilter();

    private static final String RECTANGLE_JSON = "{\"type\":\"_rectangle\",\"a\":5.0,\"b\":2.0}";

    private String FIGURES_URI;
    private String HISTORY_URI;

    @Before
    public void setup() {

        RestAssured.baseURI = "http://localhost:" + port;
        FIGURES_URI = baseURI + "/figures";
        HISTORY_URI = baseURI + "/history";

        given().auth().
                form("user", "pass", new FormAuthConfig("/login", "username", "password")).
                filter(sessionFilter).
                get("/login");

    }

    @Test
    public void
    login_returns_200() {
        given().
                filter(sessionFilter).
                expect().
                statusCode(200).
                when().
                get("/login").peek();
    }

    @Test
    public void
    figures_resource_returns_200() {
        given().
                filter(sessionFilter).
                expect().
                statusCode(200).
                when().
                get("/figures").peek();
    }

    @Test
    public void
    post_figure_returns_200() {
        given().
                filter(sessionFilter).
                contentType("application/json").
                body(RECTANGLE_JSON).
                expect().
                statusCode(200).
                when().
                post("/figures").peek();

    }

    @Test
    public void
    post_rectangle_actually_posts_a_rectangle_lol() {
        given().
                filter(sessionFilter).
                contentType(ContentType.JSON).
                body(RECTANGLE_JSON).
                post("/figures").
                peek().
                then().
                body("type", equalTo("_rectangle"));
    }

    @Test
    public void
    get_figure_area_creates_history_item() {
        String figureId =
                given().
                        filter(sessionFilter).
                        contentType(ContentType.JSON).
                        body(RECTANGLE_JSON).
                        post("/figures").
                        peek().
                        then().
                        extract().path("id");

        given().
                filter(sessionFilter).
                get(getFigureAreaUri(figureId)).peek();

        String history =
                given().
                        filter(sessionFilter).
                        get(HISTORY_URI).
                        peek().
                        asString();

        JsonPath jsonPath = new JsonPath(history);
        List<String> figureIds = jsonPath.get("content.figureId");
        String responseId = figureIds.get(figureIds.size() - 1);

        assertEquals(figureId, responseId);
    }

    @Test
    public void
    area_calculates_area() {
        String figureId =
                given().
                        filter(sessionFilter).
                        contentType(ContentType.JSON).
                        body(RECTANGLE_JSON).
                        post("/figures").
                        peek().
                        then().
                        extract().path("id");
        given().
                filter(sessionFilter).
                get(getFigureAreaUri(figureId)).
                peek().
                then().
                assertThat().
                body("area", equalTo(10.0f));


    }

    private String getFigureAreaUri(String id) {
        return baseURI + "/figures/" + id + "/area";
    }

}
