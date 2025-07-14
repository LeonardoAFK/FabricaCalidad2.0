package co.edu.udea.certificacion.busquedas.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToSearchPageTask implements Task {

    private static final String URL = "https://www.npdbejecol.com/vista/moleculas/reportes/landingPage.view.vista.php";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL)
        );
    }

    public static NavigateToSearchPageTask page() {
        return new NavigateToSearchPageTask();
    }
}
