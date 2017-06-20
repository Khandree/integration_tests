package edu.iis.mto.blog.rest.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by Agata on 2017-06-20.
 */
    public class AddBlogPostTest extends FunctionalTests {
        @Test
        public void ConfirmedUsedCanAddPost() throws Exception {
            JSONObject jsonObject = new JSONObject().put("entry", "Test post 1");
            RestAssured.given().accept(ContentType.JSON).header("Content-Type", "application/json;charset=UTF-8")
                    .body(jsonObject.toString()).expect().log().all().statusCode(HttpStatus.SC_CREATED).when()
                    .post("/blog/user/1/post");
        }

        @Test
        public void NewUserCannotAddPost() throws Exception {
            JSONObject jsonObject = new JSONObject().put("entry", "Test post 2");
            RestAssured.given().accept(ContentType.JSON).header("Content-Type", "application/json;charset=UTF-8")
                    .body(jsonObject.toString()).expect().log().all().statusCode(HttpStatus.SC_BAD_REQUEST).when()
                    .post("/blog/user/2/post");
        }

        @Test
        public void RemovedUserCannotAddPost() throws Exception {
            JSONObject jsonObject = new JSONObject().put("entry", "Test post 3");
            RestAssured.given().accept(ContentType.JSON).header("Content-Type", "application/json;charset=UTF-8")
                    .body(jsonObject.toString()).expect().log().all().statusCode(HttpStatus.SC_BAD_REQUEST).when()
                    .post("/blog/user/3/post");
        }
}