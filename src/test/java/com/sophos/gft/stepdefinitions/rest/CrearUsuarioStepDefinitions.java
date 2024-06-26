package com.sophos.gft.stepdefinitions.rest;

import static com.sophos.gft.exceptions.CodigoRespuestaEsperadaIncorrectoException.CODIGO_ESPERADO_INCORRECTO;
import static com.sophos.gft.exceptions.ValoresEsperadosIncorrectosException.VALORES_ESPERADOS_INCORRECTOS;
import static com.sophos.gft.models.builder.EmpleadoBuilder.con;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.sophos.gft.exceptions.CodigoRespuestaEsperadaIncorrectoException;
import com.sophos.gft.exceptions.ValoresEsperadosIncorrectosException;
import com.sophos.gft.questions.VerificarCodigoRespuesta;
import com.sophos.gft.questions.rest.VerificarCreacionUsuario;
import com.sophos.gft.tasks.rest.CrearUsuario;


import io.cucumber.java.es.Cuando;

import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import net.thucydides.core.util.EnvironmentVariables;

public class CrearUsuarioStepDefinitions {

    private EnvironmentVariables environmentVariables;


    @Cuando("^(.*) crea su usuario con su nombre y su puesto de trabajo que es: (.*)$")
    public void crearUsuario(String nombreActor, String puestoTrabajo) {
        theActorCalled(nombreActor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(
                        CrearUsuario.enElSistema(con().elNombre(nombreActor).yPuestoTrabajo(puestoTrabajo)));
    }

    @Entonces("^el observa que el usuario es creado exitosamente$")
    public void observarCreacionUsuarioExitoso() {
        theActorInTheSpotlight()
                .should(
                        seeThat(VerificarCodigoRespuesta.delServicio(201))
                                .orComplainWith(
                                        CodigoRespuestaEsperadaIncorrectoException.class, CODIGO_ESPERADO_INCORRECTO));
        theActorInTheSpotlight()
                .should(
                        seeThat(VerificarCreacionUsuario.deLaRespuesta())
                                .orComplainWith(
                                        ValoresEsperadosIncorrectosException.class, VALORES_ESPERADOS_INCORRECTOS));
    }
}
