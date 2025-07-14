package co.edu.udea.certificacion.busquedas.interactions;

import co.edu.udea.certificacion.busquedas.userinterfaces.SearchPageUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarPorTexto implements Task {

    private final String texto;

    public BuscarPorTexto(String texto) {
        this.texto = texto;
    }

    public static BuscarPorTexto con(String texto) {
        return instrumented(BuscarPorTexto.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(texto).into(SearchPageUserInterface.INPUT_BUSQUEDA),
                Hit.the(Keys.ENTER).into(SearchPageUserInterface.INPUT_BUSQUEDA)
        );
    }
}
