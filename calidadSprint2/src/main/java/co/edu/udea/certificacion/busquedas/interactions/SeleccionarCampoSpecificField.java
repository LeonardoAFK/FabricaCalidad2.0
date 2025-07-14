package co.edu.udea.certificacion.busquedas.interactions;

import co.edu.udea.certificacion.busquedas.userinterfaces.SpecificSearchPageUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarCampoSpecificField implements Interaction {

    private final String valor;

    public SeleccionarCampoSpecificField(String valor) {
        this.valor = valor;
    }

    public static SeleccionarCampoSpecificField conValor(String valor) {
        return Tasks.instrumented(SeleccionarCampoSpecificField.class, valor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SpecificSearchPageUserInterface.CAMPO_SPECIFIC_FIELD),
                WaitUntil.the(SpecificSearchPageUserInterface.OPCION_NUMBER_OF_CARBONS, isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(SpecificSearchPageUserInterface.OPCION_NUMBER_OF_CARBONS)
        );
    }
}
