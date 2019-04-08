package TestFramework;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import nasaAPIs.*;

public class GetNasaSearch {
	  
	private static Logger log =LogManager.getLogger(GetNasaSearch.class.getName());
	
	Properties prop=new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//env.properties");
		prop.load(fis);
		
		log.info("Host information " + prop.getProperty("HOST"));
		RestAssured.baseURI= prop.getProperty("HOST");
	}

	@Test
	public void GetSearch()
	{
		
		Response res = given().
	       param("q","apollo 11").
	       param("description","moon landing").
	       param("media_type","image").
	       param("location","National").
	    when().
	    get(resources.searchGetData()).
	    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	       body("collection.version",equalTo("1.0")).and().
	       body("collection.metadata.total_hits",equalTo(17)).and().
	       body("collection.items[0].data[0].location",equalTo("National Air and Space Museum")).and().
	       header("Server", "nginx/1.4.6 (Ubuntu)").
	       extract().response();
	
		JsonPath js= ReusableMethods.rawToJson(res);
		log.info(js);
	}
	
	@Test
	public void GetAsset()
	{
		Response res = 
			given().       
			when().
		    get(resources.assetGet()+"as11-40-5874").
		    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("collection.href",equalTo("https://images-api.nasa.gov/asset/as11-40-5874")).
		       header("Connection", "keep-alive").
		       extract().response();
		String str = res.toString();
		log.info(str);
	}
}
