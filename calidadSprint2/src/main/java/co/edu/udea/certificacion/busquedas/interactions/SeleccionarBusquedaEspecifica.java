package co.edu.udea.certificacion.busquedas.interactions;

import co.edu.udea.certificacion.busquedas.userinterfaces.SpecificSearchPageUserInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarBusquedaEspecifica implements Task {

    private final String valor;

    public SeleccionarBusquedaEspecifica(String valor) {
        this.valor = valor;
    }

    public static SeleccionarBusquedaEspecifica conValor(String valor) {
        return instrumented(SeleccionarBusquedaEspecifica.class, valor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SpecificSearchPageUserInterface.BOTON_SPECIFIC_SEARCH),
                Click.on(SpecificSearchPageUserInterface.CAMPO_SPECIFIC_FIELD),
                Click.on(SpecificSearchPageUserInterface.OPCION_NUMBER_OF_CARBONS),
                Click.on(SpecificSearchPageUserInterface.OPERADOR_SELECT),
                Click.on(SpecificSearchPageUserInterface.OPERADOR_EQUAL_TO_NEXT),
                Enter.theValue(valor).into(SpecificSearchPageUserInterface.CAMPO_NUMERO),
                Click.on(SpecificSearchPageUserInterface.BOTON_CONSULT)
        );
    }
}
