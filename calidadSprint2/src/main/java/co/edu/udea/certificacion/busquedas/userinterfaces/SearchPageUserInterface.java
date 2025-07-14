package co.edu.udea.certificacion.busquedas.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchPageUserInterface {

    // Campo de búsqueda simple
    public static final Target INPUT_BUSQUEDA = Target.the("campo de búsqueda")
            .located(By.id("claves"));

    // Fila que contiene una fórmula específica
    public static Target RESULTADO_CON_CADENA(String texto) {
        return Target.the("resultado que contiene la cadena " + texto)
                .located(By.xpath("//*[@id='datatables']//tbody//td[contains(text(),'" + texto + "')]"));

    }
}
