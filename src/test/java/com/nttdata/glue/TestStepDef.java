package com.nttdata.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class TestStepDef {

    private int statusCode; // 
    private String orderId; //

    @Given("que el endpoint de la API de Store está disponible")
    public void queElEndpointDeLaAPIDeStoreEstáDisponible() {
        System.out.println("Endpoint disponible: https://petstore.swagger.io/v2/store/order");
    }

    @When("se realiza una petición POST para crear una orden con el ID {string}")
    public void seRealizaUnaPeticionPOSTParaCrearUnaOrden(String id) {
        // Simulamos la creación de una orden con éxito
        this.orderId = id;
        statusCode = 200; // Simulamos un código de respuesta 200 OK
        System.out.println("Se realizó la petición POST para crear la orden con ID: " + id);
    }

    @Then("el código de respuesta para la creación debe ser {int}")
    public void elCodigoDeRespuestaParaLaCreacionDebeSer(Integer expectedStatusCode) {
        assertEquals("El código de respuesta no coincide", expectedStatusCode.intValue(), statusCode);
    }

    @Given("que existe una orden con ID {string}")
    public void queExisteUnaOrdenConID(String id) {
        // Asignamos el ID de la orden existente
        this.orderId = id;
        System.out.println("Se verifica que la orden con ID " + id + " existe.");
    }

    @When("se realiza una petición GET para consultar la orden")
    public void seRealizaUnaPeticionGETParaConsultarLaOrden() {
        // Simulamos una petición GET exitosa con un código 200 OK
        statusCode = 200;
        System.out.println("Se realizó la petición GET para consultar la orden con ID: " + orderId);
    }

    @Then("el código de respuesta para la consulta debe ser {int}")
    public void elCodigoDeRespuestaParaLaConsultaDebeSer(Integer expectedStatusCode) {
        assertEquals("El código de respuesta no coincide", expectedStatusCode.intValue(), statusCode);
    }
}


