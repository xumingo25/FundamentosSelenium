package codigo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class TestCases {
    //NO ESTA AQUI
    WebDriver driver;
    static int contador = 0;

    @BeforeAll
    public static void preparacionClase(){
        System.out.println("Se esta preparando el driver...");
        String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);
    }

    @AfterAll
    public static void posEjecucion(){
        System.out.println("Se finalizo ejecuciòn de pruebas");
        System.out.println(" pruebas lanzadas: "+contador);
        System.out.println("Emitiendo informe de resultados...");
        System.out.println("Subiendo resultados a ALM / Jira / etc");
    }


    @BeforeEach
    public void preCondiciones(){
        //PRE CONDICIONES
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://sitio.consorcio.cl/");
        System.out.println("Se esta preparando el test "+ contador++);
    }

    @AfterEach
    public void posCondiciones(){
        //POS CONDICIONES
        driver.close();
        System.out.println("Se cierra browser asociado a ejecuciòn del test "+ contador);
    }


    @Test
    public void TC001() throws InterruptedException {
        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        shadow.findElement(locatorLinkHazteCliente).click();

        driver.findElement(By.name("rut")).sendKeys("123456789");

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        Assertions.assertEquals("El Rut ingresado no es válido",driver.findElement(By.cssSelector("div[class='error-message'] span")).getText());
    }

    @Test
    public void TC002() throws InterruptedException {
        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        shadow.findElement(locatorLinkHazteCliente).click();

        driver.findElement(By.name("rut")).sendKeys("123456789");

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        Assertions.assertEquals("El Rut ingresado no es válido",driver.findElement(By.cssSelector("div[class='error-message'] span")).getText());
    }

    @Test
    public void TC003() throws InterruptedException {
        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        shadow.findElement(locatorLinkHazteCliente).click();

        driver.findElement(By.name("rut")).sendKeys("123456789");

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        Assertions.assertEquals("El Rut ingresado no es válido",driver.findElement(By.cssSelector("div[class='error-message'] span")).getText());
    }

}
