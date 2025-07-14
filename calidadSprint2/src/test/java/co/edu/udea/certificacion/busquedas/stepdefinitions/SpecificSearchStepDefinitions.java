package co.edu.udea.certificacion.busquedas.stepdefinitions;

import co.edu.udea.certificacion.busquedas.interactions.SeleccionarCampoSpecificField;
import co.edu.udea.certificacion.busquedas.tasks.NavigateToSearchPageTask;
import co.edu.udea.certificacion.busquedas.userinterfaces.SpecificSearchPageUserInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;

public class SpecificSearchStepDefinitions {

    @Managed(driver = "chrome")
    public WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
        usuario.attemptsTo(NavigateToSearchPageTask.page()); // Asegura que llegue a la página
    }

    @When("realizo una búsqueda específica con el número {int}")
    public void realizoBusquedaEspecificaConNumero(Integer numero) {
        usuario.attemptsTo(
                // 1. Clic botón Specific Search
                Click.on(SpecificSearchPageUserInterface.BOTON_SPECIFIC_SEARCH),

                // 2. Seleccionar campo "NUMBER_OF_CARBONS"
                SeleccionarCampoSpecificField.conValor("NUMBER_OF_CARBONS"),

                // 3. Seleccionar operador "Equal to the next number"
                Click.on(SpecificSearchPageUserInterface.OPERADOR_SELECT),
                Click.on(SpecificSearchPageUserInterface.OPERADOR_EQUAL_TO_NEXT),

                // 4. Ingresar número
                Enter.theValue(numero.toString()).into(SpecificSearchPageUserInterface.CAMPO_NUMERO),

                // 5. Click en botón Consultar
                Click.on(SpecificSearchPageUserInterface.BOTON_CONSULT)
        );
    }

    @Then("los resultados muestran {string} en la columna correspondiente")
    public void validarResultado(String valorEsperado) {
        usuario.attemptsTo(
                Ensure.that(SpecificSearchPageUserInterface.RESULTADO_EN_COLUMNA(valorEsperado)).isDisplayed()
        );
    }
}
