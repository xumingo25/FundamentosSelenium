package codigo.unidad2.pages;

import codigo.unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends ClaseBase {

    //BY
    By locatorRut = By.name("rut");
    By locatorNacionalidadChilena = By.xpath("//label[@for='nacionalidadChileno']");
    By localorErrorRutInvalido = By.cssSelector("div[class='error-message'] span");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //ACCIONES
    public void ingresarRut(String rut){
        agregarTexto(esperarPorElementoVisible(buscarElementoWeb(locatorRut)),rut);
    }

    public void seleccionarNacionalidadChilena(){
        click(esperarPorElementoAClickear(locatorNacionalidadChilena));
    }

    public String obtenerMensajeError(){
        return obtenerTexto(esperarPorElementoVisible(buscarElementoWeb(localorErrorRutInvalido)));
    }


}
