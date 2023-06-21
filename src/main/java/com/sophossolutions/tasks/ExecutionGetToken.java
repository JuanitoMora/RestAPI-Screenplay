package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecutionGetToken implements Task {

    private final String endpoint;
    private final String id;

    public ExecutionGetToken(String endpoint, String id) {
        this.endpoint = endpoint;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint.concat(id)).with(
                requestSpecification -> requestSpecification.auth().oauth2(ApiConstants.TOKEN)));

        //Ver en consola la respuesta de la ejecución
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecutionGetToken getInformation(String endpoint, String id) {
        return Tasks.instrumented(ExecutionGetToken.class, endpoint, id);
    }
}
