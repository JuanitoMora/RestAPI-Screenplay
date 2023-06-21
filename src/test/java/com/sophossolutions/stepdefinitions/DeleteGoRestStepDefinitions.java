package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecuteDeleteToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.CoreMatchers.equalTo;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteGoRestStepDefinitions {

    @When("se consulta en el endpoint {string} el usuario a eliminar por id {string}")
    public void seConsultaEnElEndpointElUsuarioAEliminarPorId(String endpoint, String id) {
       theActorInTheSpotlight().attemptsTo(ExecuteDeleteToken.deleteUser(endpoint, id));
    }

    @Then("se valida que el status code sea {int} y el code sea {int}")
    public void seValidaQueElStatusCodeSeaYElCodeSea(Integer statuscode, Integer code) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statuscode).body("code", equalTo(code))));
    }
}
