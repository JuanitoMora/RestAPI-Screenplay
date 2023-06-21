package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecutePatchToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PatchGoRestStepDefinitions {

    @When("se envia la informacion del usuario a modificar a traves del endpoint {string} por id {string}")
    public void seEnviaLaInformacionDelUsuarioAModificarATravesDelEndpointPorId(String endpoint, String id, DataTable userInformation) {
        theActorInTheSpotlight().attemptsTo(ExecutePatchToken.editUser(endpoint, id, userInformation));
    }

    @Then("se valida que el status code sea {int} contenga el nombre {string} y el estatus {string}")
    public void seValidaQueElStatusCodeSeaContengaElNombreYElEstatus(Integer statusCode, String name, String estatus) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode).body("data.name", equalTo(name))));
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode).body("data.status",equalTo(estatus))));
    }
}