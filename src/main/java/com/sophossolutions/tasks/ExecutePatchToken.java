package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import org.apache.hc.core5.http.HttpHeaders;

import java.util.Map;

public class ExecutePatchToken implements Task {

    private String endpoint;
    private String id;
    private Map<String, String> body;

    public ExecutePatchToken(String endpoint, String id, DataTable body) {
        this.endpoint = endpoint;
        this.id = id;
        this.body = body.asMap(String.class, String.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to(endpoint.concat(id)).with(requestSpecification -> requestSpecification.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .auth().oauth2(ApiConstants.TOKEN).body(body)));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecutePatchToken editUser(String endpoint, String id, DataTable body) {
        return Tasks.instrumented(ExecutePatchToken.class, endpoint, id, body);
    }
}
