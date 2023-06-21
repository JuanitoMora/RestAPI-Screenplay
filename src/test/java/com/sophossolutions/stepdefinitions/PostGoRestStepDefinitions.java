package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecutePostToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class PostGoRestStepDefinitions {

    @When("proporciona la informacion del usuario {string}")
    public void proporcionaLaInformacionDelUsuario(String endpoint, DataTable userInformation) {
        theActorInTheSpotlight().attemptsTo(ExecutePostToken.createUser(endpoint, userInformation));
    }

    @Then("valida que la respuesta tenga el nombre {string} y el status code sea {int}")
    public void validaQueLaRespuestaTengaElNombreYElStatusCodeSea(String name, Integer statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode).body("data.name", equalTo(name))));
    }
}
