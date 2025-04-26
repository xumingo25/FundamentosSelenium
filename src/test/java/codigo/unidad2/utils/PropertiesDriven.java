package codigo.unidad2.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {

    private static Properties prop; //null

    public static String getProperty(String key){
        prop = new Properties(); //properties

        String rutaFile= System.getProperty("user.dir")+"\\src\\test\\resources\\projectProperties.properties";

        try {
            InputStream input = new FileInputStream(rutaFile);

            prop.load(input);

        } catch (FileNotFoundException e) {
            System.out.println("Fallo el cargar properties...Error en ruta del archivo. Ruta ingresada: "+rutaFile);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Fallo el cargar properties...Error al interpretar el archivo.");
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);
    }

}
