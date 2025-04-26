package codigo.unidad2.tests;

import codigo.unidad2.pages.HomePage;
import codigo.unidad2.pages.RegisterPage;
import codigo.unidad2.utils.DataDriven;
import codigo.unidad2.utils.PropertiesDriven;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class TestCases {
    //Definir Atributos
    private WebDriver driver; //NULL

    //Pages
    private HomePage home; //NULL
    private RegisterPage register; //NULL
    private static String browser;
    private static String ruta;
    private static String property;
    private ArrayList<String> datosCP; //null

    @BeforeAll
    public static void preparacionSuite(){

        System.out.println("Preparando suite de pruebas...");
        System.out.println("seteando properties del driver");
        browser = PropertiesDriven.getProperty("browser");
        ruta = System.getProperty("user.dir")+ PropertiesDriven.getProperty("rutaDriver");
        property = PropertiesDriven.getProperty("propertyDriver");
    }

    @BeforeEach
    public void preparacionTests(){
        datosCP = new ArrayList<String>(); // arreglo sin nada (tamaño 0)
        home = new HomePage(driver);
        home.conexionDriver(browser,ruta,property);
        register = new RegisterPage(home.getDriver());
        home.prepararEsperas(Duration.ofSeconds(20));
        home.cargarSitio(PropertiesDriven.getProperty("url")); //NO DEBERIAMOS DEJAR EN DURO PARAMETROS DE CONFIGURACIÒN
        home.maximizarBrowser();
    }

    @AfterEach
    public void posTests(){

    }

    @Test
    public void TC001_ErrorCreacionCta(){
        datosCP = DataDriven.getData("TC001_ErrorCreacionCta");
        home.irHazteCliente();
        register.ingresarRut(datosCP.get(1)); //NO DEBERIAMOS PASAR DATA EN DURO
        register.seleccionarNacionalidadChilena();
        Assertions.assertEquals(datosCP.get(2),register.obtenerMensajeError()); //NO DEBERIAMOS PASAR DATA EN DURO
    }

    @Test
    public void TC0002_ErrorCreacionCta2_RutEmpresa(){
        datosCP = DataDriven.getData("TC0002_ErrorCreacionCta2_RutEmpresa");
        home.irHazteCliente();
        register.ingresarRut(datosCP.get(1)); //NO DEBERIAMOS PASAR DATA EN DURO
        register.seleccionarNacionalidadChilena();
        Assertions.assertEquals(datosCP.get(2),register.obtenerMensajeError()); //NO DEBERIAMOS PASAR DATA EN DURO
    }

}
