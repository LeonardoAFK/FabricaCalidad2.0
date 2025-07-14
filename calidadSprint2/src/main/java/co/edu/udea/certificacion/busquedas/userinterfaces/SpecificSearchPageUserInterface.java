package co.edu.udea.certificacion.busquedas.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SpecificSearchPageUserInterface {

    public static final Target BOTON_SPECIFIC_SEARCH = Target.the("botón Specific Search")
            .located(By.xpath("//a[@onclick='busquedaSpecificSearch()']"));

    public static final Target CAMPO_SPECIFIC_FIELD = Target.the("dropdown de campo Specific Field")
            .located(By.id("select2-campoBusqueda-container"));

    public static final Target OPCION_NUMBER_OF_CARBONS = Target.the("opción NUMBER_OF_CARBONS")
            .located(By.xpath("//li[contains(@id,'select2-campoBusqueda-result') and contains(text(),'NUMBER_OF_CARBONS')]"));

    public static final Target OPERADOR_SELECT = Target.the("dropdown de Search Operator")
            .located(By.id("SelectCampoBusqueda"));

    public static final Target OPERADOR_EQUAL_TO_NEXT = Target.the("opción Equal to the next number")
            .located(By.xpath("//*[@id='SelectCampoBusqueda']/option[2]"));

    public static final Target CAMPO_NUMERO = Target.the("campo Number")
            .located(By.id("ClavesBusqueda"));

    public static final Target BOTON_CONSULT = Target.the("botón Consult")
            .located(By.xpath("//*[@id='criteriosBusqueda']/div[4]/div/button[2]"));

    public static Target RESULTADO_EN_COLUMNA(String valor) {
        return Target.the("resultado con valor " + valor)
                .located(By.xpath("//*[@id='datatables']//tbody//td[text()='" + valor + "']"));
    }
}
