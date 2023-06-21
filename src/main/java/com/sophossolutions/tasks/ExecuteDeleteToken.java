package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class ExecuteDeleteToken implements Task {

    private final String endpoint;
    private final String id;

    public ExecuteDeleteToken(String endpoint, String id) {
        this.endpoint = endpoint;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(endpoint.concat(id)).with(requestSpecification -> requestSpecification.auth().oauth2(ApiConstants.TOKEN)));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecuteDeleteToken deleteUser(String endpoint, String id) {
        return Tasks.instrumented(ExecuteDeleteToken.class, endpoint, id);
    }
}
