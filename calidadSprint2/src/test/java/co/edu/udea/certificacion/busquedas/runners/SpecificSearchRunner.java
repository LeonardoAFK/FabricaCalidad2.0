package co.edu.udea.certificacion.busquedas.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/moleculas/specific_search.feature",
        glue = "co.edu.udea.certificacion.busquedas.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SpecificSearchRunner {
}

