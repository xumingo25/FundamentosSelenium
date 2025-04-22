package codigo.unidad2.utils;

import codigo.unidad2.pages.HomePage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public static ArrayList<String> getData(String testCase) {

        ArrayList<String> data = new ArrayList<String>();

        //Instanciar un archivo
        FileInputStream file;
        try {
            file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\DataPruebas.xlsx");
        } catch (FileNotFoundException e) {
            System.out.println("Fallo el cargar el archivo...");
            throw new RuntimeException(e);
        }

        XSSFWorkbook excel;
        //Instanciar un excel
        try {
             excel = new XSSFWorkbook(file);
        } catch (IOException e) {
            System.out.println("Error al cargar el excel...");
            throw new RuntimeException(e);
        }

        int sheets = excel.getNumberOfSheets();

        System.out.println("la cantidad de hojas del excel es: "+sheets);

        //recorrer excell y obtener hoja con datos
        for(int i=0; i < sheets ; i++){
            if(excel.getSheetName(i).equalsIgnoreCase("HojaData")){
                //encontre la hoja con los datos
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                Row fila = filas.next();

                Iterator<Cell> celda = fila.cellIterator();

                int k = 0;
                int columna = 0;

                while(celda.hasNext()){
                    Cell celdaSeleccionada = celda.next();

                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        //Encontre la celda con el titulo de los casos de prueba
                        //Definir la columna con los test cases
                        columna = k;
                    }
                    k++;
                }

                while(filas.hasNext()){

                    Row r = filas.next();

                    if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(testCase)){

                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()){

                            Cell c = cv.next();

                            if(c.getCellType() == CellType.STRING){
                                //System.out.println(c.getStringCellValue());
                                data.add(c.getStringCellValue());
                            }else if(c.getCellType() == CellType.NUMERIC){
                                //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                                data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }


            }
        }

        return data;
    }
}
