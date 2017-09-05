package Tests.BaseEndpoint;

import TestHQ.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObjects.BaseEndpointsPage.get_GetVersion;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

public class Test_BaseEndpoints extends BaseTestClass {

    @BeforeClass(alwaysRun = true)
    public static void setBaseUri() {

    }

    @Test(groups = {"smoke-L1"}, description = "Get User information - External API.")
    public static void test_getInfo(){
        given().header("Accept", "application/json").header("Authorization", ENTWINE_BASIC_AUTHORIZATION_KEY).
        when().get(BaseURL + "/").
        then().log().all().body("version", equalTo("v1.0.0")).
                            body("url", equalTo(BaseURL.replace("/api", "").replace("admin", "api")));
    }

    @Test(groups = {"smoke-L1"}, description = "Get The APIs version - External API.")
    public static void test_getVersions(){
        given().header("Accept", "application/json").header("Authorization", ENTWINE_BASIC_AUTHORIZATION_KEY).
                when().get(BaseURL + get_GetVersion).
                then().
                log().
                all().
                body("default", equalTo("v1.0.0")).
                body("versions", everyItem(not(isEmptyOrNullString())));
    }

    @Test
    public static void test_getDefaultVersion(){

    }

    @Test(groups = {"smoke-L1"}, description = "Get user information - External API.")
    public static void test_getUserInfo()
    {
        given().
                log().all().
                header("Accept", "application/json").
                header("Authorization", ENTWINE_BASIC_AUTHORIZATION_KEY).
        when().
                log().all().
                get(BaseURL + "/info/me").
        then().
                log().all().
                body("provider", equalTo("system")).
                body("name", equalTo("System Administrator")).
                body("userrole", equalTo("ROLE_USER_YWRtaW4=")).
                body("email", not(isEmptyOrNullString())).
                body("username", not(isEmptyOrNullString())).
         extract();
    }

    @Test
    public static void test_getUserRoles(){

    }

    @Test
    public static void test_getCurrentOrganization(){

    }

    @Test
    public static void test_getOrganizationProperties(){

    }

    @Test
    public static void test_postRepopulateExternalIndex(){

    }




}


