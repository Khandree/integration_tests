package edu.iis.mto.blog.rest.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Agata on 2017-06-20.
 */
public class SearchPostTest {

    @Test
    public void searchRemovedUserPosts() throws Exception {
        RestAssured.given().accept(ContentType.JSON).header("Content-Type", "application/json;charset=UTF-8")
                .expect().log().all().statusCode(HttpStatus.SC_NOT_FOUND).when()
                .get("/blog/user/3/post");
    }

    @Test
    public void correctLikeNumber() throws Exception {
        RestAssured.given().accept(ContentType.JSON).header("Content-Type", "application/json;charset=UTF-8")
                .expect().log().all().statusCode(HttpStatus.SC_OK).body("likesCount[1]", Matchers.equalTo(2)).when()
                .get("/blog/user/1/post");
    }
}
