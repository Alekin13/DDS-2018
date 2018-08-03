import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PruebaTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hola Jey!");
		Properties archivoPropiedades = new Properties();
		archivoPropiedades.load(new FileReader("src/main/java/restricciones.properties"));
		
		//System.out.println(archivoPropiedades.getProperty("aireacondicionado.frigorias"));
		
		//double doble = Double.parseDouble(archivoPropiedades.getProperty(tipo+".frigorias"));
		//System.out.println(doble); 
		
	}

}
