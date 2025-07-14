package co.edu.udea.certificacion.busquedas.stepdefinitions;

import co.edu.udea.certificacion.busquedas.tasks.NavigateToSearchPageTask;
import co.edu.udea.certificacion.busquedas.userinterfaces.SearchPageUserInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.actions.Hit;
import co.edu.udea.certificacion.busquedas.interactions.BuscarPorTexto;



public class SimpleSearchStepDefinitions {

    @Managed(driver = "chrome")
    public WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que estoy en la página de búsqueda de fórmulas moleculares")
    public void queEstoyEnLaPaginaDeBusqueda() {
        usuario.attemptsTo(
                NavigateToSearchPageTask.page()
        );
    }

    @When("realizo la búsqueda con la cadena {string}")
    public void realizoLaBusquedaConLaCadena(String texto) {
        usuario.attemptsTo(
                BuscarPorTexto.con(texto)
        );
    }

    @And("espero a que se actualice la tabla de resultados")
    public void esperoActualizacion() {
        // Puedes dejarlo vacío o agregar waits si hay delays
    }

    @Then("la tabla muestra fórmulas que contienen la cadena {string}")
    public void verificarCadenaEnTabla(String texto) {
        usuario.attemptsTo(
                Ensure.that(SearchPageUserInterface.RESULTADO_CON_CADENA(texto)).isDisplayed()
        );
    }

    @And("la fórmula {string} aparece en los resultados")
    public void verificarFormulaEspecifica(String formula) {
        usuario.attemptsTo(
                Ensure.that(SearchPageUserInterface.RESULTADO_CON_CADENA(formula)).isDisplayed()
        );
    }
}
