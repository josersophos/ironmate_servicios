package com.sophos.gft.stepdefinitions.soap;

import static com.sophos.gft.exceptions.CodigoRespuestaEsperadaIncorrectoException.CODIGO_ESPERADO_INCORRECTO;
import static com.sophos.gft.exceptions.ValoresEsperadosIncorrectosException.VALORES_ESPERADOS_INCORRECTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.sophos.gft.exceptions.CodigoRespuestaEsperadaIncorrectoException;
import com.sophos.gft.exceptions.ValoresEsperadosIncorrectosException;
import com.sophos.gft.questions.VerificarCodigoRespuesta;
import com.sophos.gft.questions.soap.VerificarConversionNumero;
import com.sophos.gft.tasks.soap.ConvertirNumero;

import io.cucumber.java.es.Cuando;

import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import net.thucydides.core.util.EnvironmentVariables;

public class ConvertirNumeroLetrasInglesStepDefinitions {

    private EnvironmentVariables environmentVariables;


    @Cuando("^(.*) envia el numero (.*)$")
    public void enviarNumero(String nombreActor, String numeroConvertir) {
        theActorCalled(nombreActor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.soap.baseUrl")))
                .attemptsTo(ConvertirNumero.enIngles(numeroConvertir));
    }

    @Entonces("^deberia ver el numero en ingles: (.*)$")
    public void observarNumeroEnIngles(String numeroIngles) {
        theActorInTheSpotlight()
                .should(
                        seeThat(VerificarCodigoRespuesta.delServicio(200))
                                .orComplainWith(
                                        CodigoRespuestaEsperadaIncorrectoException.class, CODIGO_ESPERADO_INCORRECTO));
        theActorInTheSpotlight()
                .should(
                        seeThat(VerificarConversionNumero.enIngles(numeroIngles))
                                .orComplainWith(
                                        ValoresEsperadosIncorrectosException.class, VALORES_ESPERADOS_INCORRECTOS));
    }
}