package codigo.unidad2.pages;

import codigo.unidad2.utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ClaseBase {
    //CENTRALIZAR LOCALIZADORES
    By localorHazteCliente = By.linkText("Hazte Cliente");
    By locatorHeader = By.cssSelector("new-header");
    //constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //la homepage no tiene un driver...dicho driver se obtendra de la base...a traves del constructor de la superclase
    //2) Atributos (Caracteristicas)

    //3) Mètodos (Acciones)

    //DEFINIR ACCIONES
    public void irHazteCliente(){
        click(esperarPorElementoAClickear(buscarElementoWebEnShadowDOM(obtenerShadowDOM(locatorHeader),localorHazteCliente)));
        //click(esperarPorElementoAClickear(localorHazteCliente));
        //click(localorHazteCliente);
    }




}
