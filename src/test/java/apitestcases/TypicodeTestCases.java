/**
 * In TypicodeTestCases class , written all the API Test cases with it's validation. 
 * In a first test case taken the input from ExcelSheet. Rest of the test case's data is hard coded.
 * Based on, time availability will work data driven part. 
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-08-03
 */

package apitestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utility.ExcelUtility;

public class TypicodeTestCases {

	//Test case Description - 1. Fetch all the Users 
	@Parameters({"excelPath","sheetName"})
	@Test
	public void test_fetchAllUsers_get(String excelPath,String sheetName)

	{

		ExcelUtility excel=new ExcelUtility(excelPath, sheetName);
		baseURI=(String) excel.getCellData(1, 0);
		given().
		get("users/").
		then().
		statusCode(200);
		//.log().all();

	}
	// Test case Description - 2. Check if the user 'Chelsey Dietrich' exists in the users, please use the appropriate API's.
	@Test
	public void test_verifyChelsey_get()
	{
		baseURI ="https://jsonplaceholder.typicode.com/";
		given().
		get("users/").
		then().
		statusCode(200).
		body("name", hasItems("Chelsey Dietrich"));
		//.log().all();

	}

	// Test case Description - 3. Get all the posts for user 'Chelsey Dietrich'
	@Test
	public void test_verifyAllPost_get()
	{
		baseURI="https://jsonplaceholder.typicode.com/";
		given().
		get("users/5/posts").
		then().
		statusCode(200)
		.body("userId[1]" , equalTo(5));
		//.log().body();	
	}

	// Test case Description - 4. Check if post with title "optio dolor molestias sit" exists.
	@Test
	public void test_verifyPostTitle_get()
	{
		baseURI="https://jsonplaceholder.typicode.com/";
		given().
		get("users/5/posts").
		then().
		statusCode(200)
		.body("userId[3]" , equalTo(5))
		.body("title", hasItems("optio dolor molestias sit"));
		//.log().body();	
	}
	// Test case Description - 5. Update the above post with description "temporibus est consectetur dolore/net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem autnea et iure quam sed maxime ut distinctio quae"
	@Test
	public void test_updatePost_put()
	{

		JSONObject request=new JSONObject();

		request.put("body", "temporibus est consectetur dolore/net libero debitis vel velit laboriosam quia\\\\nipsum quibusdam qui itaque fuga rem autnea et iure quam sed maxime ut distinctio quae\");");
		baseURI="https://jsonplaceholder.typicode.com/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type", "application/json; charset=UTF-8").
		body(request.toJSONString()).

		when().
		put("/posts/44").

		then().
		statusCode(200);
		//log().all();

	}
	// Test case Description - 6. Retrive the comment associated with the above post and see if user with email "Lizeth@kellen.org" has commented on the post.
	@Test
	public void test_verifyEmailOnPost_get()
	{
		baseURI="https://jsonplaceholder.typicode.com/";
		given().
		get("/comments/219").
		then().
		statusCode(200)
		//.body(path, matcher, additionalKeyMatcherPairs)
		.body("postId" , equalTo(44))
		.body("id", equalTo(219))
		.body("email" , equalTo("Lizeth@kellen.org"));
		//.log().all();


	}

}
