package com.sophos.gft.tasks.soap;

import static com.sophos.gft.utils.UtilidadesSoap.obtenerRequestSoap;
import static com.sophos.gft.utils.enums.EnumRequestSoap.CONVERTIR_NUMERO_LETRAS_INGLES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.io.IOException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.steps.StepInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertirNumero implements Task {

  private static final String ENDPOINT = "/webservicesserver/NumberConversion.wso";
  private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);
  private String numeroConvertir;

  public ConvertirNumero(String numeroConvertir) {
    this.numeroConvertir = numeroConvertir;
  }

  public static ConvertirNumero enIngles(String numeroConvertir) {
    return instrumented(ConvertirNumero.class, numeroConvertir);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(ENDPOINT)
            .with(
                request ->
                    request
                        .header("Content-Type", "text/xml; charset=utf-8")
                        .body(obtenerRequestConvertirNumeroConData())));
  }

  private String obtenerRequestConvertirNumeroConData() {
    try {
      return obtenerRequestSoap(CONVERTIR_NUMERO_LETRAS_INGLES.getPathArchivo())
          .replace("{numeroConvertir}", numeroConvertir);
    } catch (IOException e) {
      LOGGER.info("Error al obtener el xml con los datos: " + e);
      return null;
    }
  }
}
