package Rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;

import static io.restassured.RestAssured.get;


public class CharacterRequest {


    public static Response response;


    String Base_Url = "https://breakingbadapi.com/";
    String Path = "api/";
    String Endpoint = "characters";


    public CharacterRequest Get() {
        RestAssured.baseURI = Base_Url;
        Response response = RestAssured.given().when().get(Path + Endpoint).then().
                contentType(ContentType.JSON).
                extract().response();

        Pojo[] returnedCharacters = response.getBody().as(Pojo[].class);
        for (Pojo returnedCharacter : returnedCharacters) {
            System.out.println("Character Name: " + returnedCharacter.getName());
            System.out.println("Portrayed: " + returnedCharacter.getPortrayed());
            System.out.println("------------------------------------------------------");
        }
        return this;
    }

    public CharacterRequest listing() {
        RequestSpecification Request = RestAssured.given();
        Response MyRes;
        MyRes = Request.get(Base_Url+Path+Endpoint);
        String jsonResponse = MyRes.asString();

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

