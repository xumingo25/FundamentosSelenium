package codigo.unidad2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ClaseBase {
    // 2 - atributos (caracteristicas)
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ClaseBase(WebDriver driver){
        this.driver = driver;
    }//Constructor

    // 3 - mètodos (acciones)

    //Clicks, esperas, busquedas, sendKeys

    public void click(By localizador){
        try {
            this.driver.findElement(localizador).click();
        } catch (Exception e) {
            System.out.println("ocurrio un error lanzado el clic...se intento con el locator: "+localizador.toString());
            throw new RuntimeException(e);
        }
    }

    public void click(WebElement elemento){
        try {
            elemento.click();
        } catch (Exception e) {
            System.out.println("ocurrio un error lanzado el clic...se intento con el elemento: "+elemento.toString());
            throw new RuntimeException(e);
        }
    }

    public String obtenerTexto(By localizador){
        try {
            return this.driver.findElement(localizador).getText();
        } catch (Exception e) {
            System.out.println("ocurrio un error obteniendo el texto...se intento con el locator: "+localizador.toString());
            throw new RuntimeException(e);
        }
    }

    public String obtenerTexto(WebElement elemento){
        try {
            return elemento.getText();
        } catch (Exception e) {
            System.out.println("ocurrio un error obteniendo el texto...se intento con el elemento: "+elemento.toString());
            throw new RuntimeException(e);
        }
    }

    public void agregarTexto(By localizador,String texto){
        try {
            this.driver.findElement(localizador).sendKeys(texto);
        } catch (Exception e) {
            System.out.println("ocurrio un error obteniendo el textbox...se intento con el locator: "+localizador.toString());
            throw new RuntimeException(e);
        }
    }

    public void agregarTexto(WebElement elemento,String texto){
        try {
            elemento.sendKeys(texto);
        } catch (Exception e) {
            System.out.println("ocurrio un error obteniendo el textbox...se intento con el elemento: "+elemento.toString());
            throw new RuntimeException(e);
        }
    }

    //Esperas
    public void prepararEsperas(Duration tiempo){
        try {
            this.driver.manage().timeouts().scriptTimeout(tiempo);
            this.driver.manage().timeouts().implicitlyWait(tiempo);
            this.driver.manage().timeouts().pageLoadTimeout(tiempo);
        } catch (Exception e) {
            System.out.println("ocurrio un error asignando el tiempo de espera de "+tiempo.toString()+ " Segundos.");
            throw new RuntimeException(e);
        }
    }

    public void esperarPorElementoAClickear(By localizador){
         wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(localizador)).click();
        } catch (Exception e) {
            System.out.println("Ocurrio un error esperando por el locator: "+localizador.toString());
            throw new RuntimeException(e);
        }

    }

    public void esperarPorElementoAClickear(WebElement elemento){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(elemento)).click();
        } catch (Exception e) {
            System.out.println("Ocurrio un error esperando por el web element: "+elemento.toString());
            throw new RuntimeException(e);
        }

    }



}
