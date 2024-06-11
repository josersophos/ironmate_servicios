package com.sophos.gft.runners.soap;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/soap/convertir_numero_letras_ingles.feature",
        glue = "com.sophos.gft.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ConvertirNumeroLetrasInglesRunner {

}
