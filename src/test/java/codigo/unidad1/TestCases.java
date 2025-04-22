package codigo.unidad1;

import codigo.unidad2.utils.DataDriven;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestCases {
    //NO ESTA AQUI
    WebDriver driver;
    static int contador = 0;
    private ArrayList<String> datosCP; //null

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
        datosCP = new ArrayList<String>(); // arreglo sin nada (tamaño 0)
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
    public void TC001_ErrorCreacionCta() throws InterruptedException {
        datosCP = DataDriven.getData("TC001_ErrorCreacionCta");

        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        shadow.findElement(locatorLinkHazteCliente).click();

        driver.findElement(By.name("rut")).sendKeys(datosCP.get(1));

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        Assertions.assertEquals(datosCP.get(2),driver.findElement(By.cssSelector("div[class='error-message'] span")).getText());
    }

    @Test
    public void TC0002_ErrorCreacionCta2_RutEmpresa() throws InterruptedException {
        datosCP = DataDriven.getData("TC0002_ErrorCreacionCta2_RutEmpresa");
        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        shadow.findElement(locatorLinkHazteCliente).click();

        driver.findElement(By.name("rut")).sendKeys(datosCP.get(1));

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        Assertions.assertEquals(datosCP.get(2),driver.findElement(By.cssSelector("div[class='error-message'] span")).getText());
    }

    @Test
    public void TC0003_ErrorCreacionCta2_RutEmpresa() throws InterruptedException {
        datosCP = DataDriven.getData("TC0003_ErrorCreacionCta2_RutEmpresa");

        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        shadow.findElement(locatorLinkHazteCliente).click();

        driver.findElement(By.name("rut")).sendKeys(datosCP.get(1));

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        Assertions.assertEquals(datosCP.get(2),driver.findElement(By.cssSelector("div[class='error-message'] span")).getText());
    }

}
