import sge.modelos.dispositivos.DispositivoEstandar;
import sge.view.Presentacion;

public class SGE {

	public static void main(String[] args) {
		/**Hace una demostracion por consola de los Datos que posee*/
		Presentacion.mostrarConsola();
		
		DispositivoEstandar dispositivo = new DispositivoEstandar();
		dispositivo.setNombreDispositivo("Heladera Patrick");
		System.out.println(dispositivo.getNombreDispositivo());
		
	}
}