package codigo.unidad1;

import org.openqa.selenium.By; //localizar elementos web
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver; //simular el browser
import org.openqa.selenium.chrome.ChromeDriver; //simular el driver de chrome

public class Ejemplo1 {

    public static void main (String[] args) throws InterruptedException {

        //Enlace al webdriver con el browser
        //Decirle al sistema que el navegador sera manipulado por un driver
        //que se encuentra en la ruta del proyecto

        //Crear un string para almacenar la ruta del driver de chrome
        //String rutaDriver = "C:\\Users\\domin\\IdeaProjects\\Clase2Selenium\\src\\test\\resources\\drivers\\chromedriver.exe";
        String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        //configurar a traves de los property del sistema, la variable webdriver.chrome.driver
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instanciar un navegador de chrome
        WebDriver driver = new ChromeDriver();

        //Maximizar el navegador
        driver.manage().window().maximize();

        //levantar el navegador
        driver.get("https://google.com");

        //Se deja en espera el hilo de ejecuciòn 5 segundos
        Thread.sleep(5000);
        //Mensajes en la consola de java
        System.out.println("La url actual es: "+driver.getCurrentUrl());

        //Funciones de navegaciòn
        driver.navigate().to("https://sitio.consorcio.cl/");
        //Se deja en espera el hilo de ejecuciòn 5 segundos
        Thread.sleep(5000);
        //Mensajes en la consola de java
        System.out.println("La url actual es: "+driver.getCurrentUrl());

        //Localizar el elemento web
        By locatorLinkHazteCliente = By.linkText("Hazte Cliente");

        //Un BY es una estrategia de busqueda (ID,LINKTEXT,CLASS,TAGNAME,XPATH,

        //Crear un objeto que simule el link / boton / textBox / dropdrown list
        //WebElement linkHazteCliente = driver.findElement(locatorLinkHazteCliente);

        //linkHazteCliente.click();

        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "new-header";
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("new-header")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(locatorLinkHazteCliente).click();

        Thread.sleep(3000);

        //TXT RUT (name="rut")
        driver.findElement(By.name("rut")).sendKeys("123456789");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@for='nacionalidadChileno']")).click();

        String resultadoEsperado = "El Rut ingresado no es válido";

        String resultadoObtenido = driver.findElement(By.cssSelector("div[class='error-message'] span")).getText();

        if(resultadoObtenido.equalsIgnoreCase(resultadoEsperado)){
            System.out.println("Funciono!!!");
        }else{
            System.out.println("ocurrio un error validando los textos de salida.");
            System.out.println("resultado esperado: "+ resultadoEsperado);
            System.out.println("resultado obtenido: "+resultadoObtenido);
        }


        //driver.navigate().back();

        //refrescar la pàgina web
        Thread.sleep(2000);
        //Mensajes en la consola de java
        //.out.println("La url actual es: "+driver.getCurrentUrl());

        //driver.navigate().refresh();

        //refrescar la pàgina web
        //Thread.sleep(2000);

        //cerrar el navegador
        driver.close();



    }



}
