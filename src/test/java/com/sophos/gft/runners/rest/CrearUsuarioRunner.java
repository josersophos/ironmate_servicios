package com.sophos.gft.runners.rest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/rest/crear_usuario.feature",
        glue = "com.sophos.gft.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class CrearUsuarioRunner {

}
