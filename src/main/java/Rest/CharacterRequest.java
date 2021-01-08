package Rest;
import org.json.JSONArray;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class CharacterRequest {


    public static Response response;
    public static String jsonAsString;

    String Base_Url = "https://breakingbadapi.com/";
    String Path = "api/";
    String Endpoint = "characters";


    public CharacterRequest Get() {
        RestAssured.baseURI = "https://breakingbadapi.com/";
        Response response = RestAssured.given().when().get(Path + Endpoint).then().
                contentType(ContentType.JSON).
                extract().response();
        JsonPath js = response.jsonPath();
        String name = js.get("name");
        //String id = js.get("id");
        //String Walter_White_ID = js.getString("char_id");
        System.out.println(name);
        //jsonAsString = response.asString();

        return this;
    }

    public CharacterRequest listing() {
        RequestSpecification myreq = RestAssured.given();

        Response MyRes;
        MyRes = myreq.get("https://breakingbadapi.com/api/characters");
        String jsonResponse = MyRes.asString();
       // System.out.println("Full String is" + jsonResponse);


        JSONArray jsonArray = new JSONArray(jsonResponse);
        for (int i = 0; i < jsonArray.length(); i++) {
            org.json.JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            String value1 = jsonObject1.optString("char_id");
            String value2 = jsonObject1.optString("name");
            if (value2.equals("Walter White")){
                System.out.println(value2 + "  has the id of: " + value1 );
                get("https://breakingbadapi.com/api/characters/"+value1).prettyPrint();
            }
        }
        return this;
    }
}
/*
    public CharacterRequest Mapper_Response(){
        ArrayList<Map<String,?>> jsonAsArrayList = from(jsonAsString).get("");

        return this;
    }

    public CharacterRequest Walter_White(){
        List<String> character_name = response.path("name");
        for (String character : character_name){

        }

            return this;
    }*/


/*"char_id": 1,
  "name": "Walter White",*/