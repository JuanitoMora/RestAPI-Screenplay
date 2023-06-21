package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecutionGetToken;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static org.hamcrest.CoreMatchers.equalTo;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetGoRestStepDefinitions {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} establece la base url {string} del servicio")
    public void estableceLaBaseUrlDelServicio(String actorName, String baseURL) {
        theActorCalled(actorName).whoCan(CallAnApi.at(baseURL));
    }

    @When("consulta en el endpoint {string} por id {string}")
    public void consultaEnElEndpointPorId(String endpoint, String id) {
        theActorInTheSpotlight().attemptsTo(ExecutionGetToken.getInformation(endpoint, id));
    }

    @Then("valida que el status code sea {int} y la respuesta contenga el nombre {string}")
    public void validaQueElStatusCodeSeaYLaRespuestaContengaElNombre(Integer status, String name) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status).body("data.name",equalTo(name))));
    }
}
