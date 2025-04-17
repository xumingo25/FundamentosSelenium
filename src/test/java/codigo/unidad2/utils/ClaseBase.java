package codigo.unidad2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ClaseBase {
    // 2 - atributos (caracteristicas)
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

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

    public WebElement esperarPorElementoAClickear(By localizador){
         wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            return wait.until(ExpectedConditions.elementToBeClickable(localizador));
        } catch (Exception e) {
            System.out.println("Ocurrio un error esperando por el locator: "+localizador.toString());
            throw new RuntimeException(e);
        }

    }


    public WebElement esperarPorElementoAClickear(WebElement elemento){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            return wait.until(ExpectedConditions.elementToBeClickable(elemento));
        } catch (Exception e) {
            System.out.println("Ocurrio un error esperando por el web element: "+elemento.toString());
            throw new RuntimeException(e);
        }

    }

    public WebElement esperarPorElementoVisible(WebElement elemento){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            return wait.until(ExpectedConditions.visibilityOf(elemento));
        } catch (Exception e) {
            System.out.println("Ocurrio un error esperando por el web element: "+elemento.toString());
            throw new RuntimeException(e);
        }
    }

    //get() driver.get(url)
    public void cargarSitio(String url){
        this.driver.get(url);
    }

    //funciòn para esperar X Segundos
    public void esperarXSegundos(int milisegs){
        try {
            Thread.sleep(milisegs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement buscarElementoWeb(By localizador){
        try {
            return this.driver.findElement(localizador);
        } catch (Exception e) {
            System.out.println("Fallo al buscar elemento web. Localizador usado: "+localizador.toString());
            throw new RuntimeException(e);
        }
    }

    public WebElement buscarElementoWebEnShadowDOM(SearchContext context,By localizador){
        try {
            return context.findElement(localizador);
        } catch (Exception e) {
            System.out.println("Fallo al buscar elemento web. Localizador usado: "+localizador.toString());
            throw new RuntimeException(e);
        }
    }

    //Cerrar browser
    public void cerrarBrowser(){
        this.driver.close();
    }

    //Maximizar el browser
    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }

    //Conectar el webdriver (Chrome, rutaProyecto/src/test/resources/chromedriver.exe , wendriver.chrome.driver)
    public WebDriver conexionDriver(String browser,String ruta,String property){
        if(browser.equalsIgnoreCase("chrome")){
            //chrome
            System.setProperty(property,ruta);
            this.driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty(property,ruta);
            this.driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("explorer")){
            System.setProperty(property,ruta);
            this.driver = new InternetExplorerDriver();
        }

        return this.driver; //chrome
    }

    public SearchContext obtenerShadowDOM(By localizador){
        try {
            return this.driver.findElement(localizador).getShadowRoot();
        } catch (Exception e) {
            System.out.println("FALLO la identificaciòn del shadowDOM. Se probo el siguiente locator: "+localizador.toString());
            throw new RuntimeException(e);
        }
    }




}
