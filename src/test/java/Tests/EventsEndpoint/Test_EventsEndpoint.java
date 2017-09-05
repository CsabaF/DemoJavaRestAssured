package Tests.EventsEndpoint;

import TestHQ.BaseTestClass;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static PageObjects.EventsEndpointsPage.delete_DeleteEvent;
import static PageObjects.EventsEndpointsPage.post_CreateEvent;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

public class Test_EventsEndpoint extends BaseTestClass {

    // Static variables for test
    private static String eventId;

    @BeforeClass(alwaysRun = true)
    public static void setBaseUri() {
    }

    @Test(groups = {"smoke-L1"})
    public static void test_importEvent(){

        eventId =
                given().
                        header("Accept", "application/json").
                        header("Authorization", ENTWINE_BASIC_AUTHORIZATION_KEY).
                        header("Content-type", "application/json").
                        body("{\"acl\":[{\"allow\":true,\"action\":\"write\",\"role\":\"ROLE_ADMIN\"}],\"metadata\":[{\"flavor\":\"dublincore/episode\",\"fields\":[{\"id\":\"title\",\"value\":\"Captivating title\"}]}]}").
                        when().
                        post(BaseURL + "/events/import").
                        then().
                        log().all().
                        contentType(ContentType.JSON).
                        statusCode(201).
                        body("identifier", not(isEmptyOrNullString())).extract().path("identifier");
    }

    @Test(dependsOnMethods = "test_importEvent", groups = {"regression", "smoke-L1"}, description = "Description here")
    public static void test_deleteEvent(){

        ValidatableResponse res =
                given().
                        header("Accept", "application/json").
                        header("Authorization", ENTWINE_BASIC_AUTHORIZATION_KEY).
                        header("Content-type", "application/json").
                        when().
                        delete(BaseURL + delete_DeleteEvent(eventId)).
                        then();
        res.body(isEmptyOrNullString()).statusCode(204);
    }

    @DataProvider
    public Object[][] CreateEventJSONDataFiles() {
        return new Object[][]{
                {"CreateEventACL.JSON", "CreateEventMetadata.JSON", "CreateEventWorkFlowProcessing.JSON"}
        };
    }

    @Test(dataProvider = "CreateEventJSONDataFiles", groups = {"smoke-L1"}, enabled = false)
    public static void test_createEvent(final String createEventACLfile, final String createEventMetadataFile, final String createEventWorkFlowProcessFile) {
        String acl = readJsonFileToString(ProjectRootDir + "/src/test/java/TestData/" + createEventACLfile);
        String metadata = readJsonFileToString(ProjectRootDir + "/src/test/java/TestData/" + createEventMetadataFile);
        String workflowProcess = readJsonFileToString(ProjectRootDir + "/src/test/java/TestData/" + createEventWorkFlowProcessFile);

        given().header("Accept", "application/json").header("Authorization", ENTWINE_BASIC_AUTHORIZATION_KEY).
                when().log().all().queryParam("metadata", metadata).
                queryParam("processing", workflowProcess).
                queryParam(acl).post(BaseURL + post_CreateEvent).
                then().statusCode(201);
    }

}
