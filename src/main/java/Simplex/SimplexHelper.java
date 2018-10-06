package Simplex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import Dispositivo.Dispositivo;
import Usuario.Cliente;

public class SimplexHelper {

	public List<Dispositivo> filtrarDispositivoHeladera(Cliente unUsuario) throws FileNotFoundException, IOException {
		
		List<Dispositivo> lista = new ArrayList<Dispositivo>();
		
		for(Dispositivo dispositivo : unUsuario.getDispositivos()){
			if (dispositivo.getEquipoConcreto() != "Heladera"){
				System.out.println(dispositivo.getEquipoConcreto());
				lista.add(dispositivo);
			}
		}		
	
		return lista;
	}
	
	public void setearRestriccionesConsumo(List<Dispositivo> listaDispositivos, SimplexFacade sf) throws IOException {
		List<Double> listaUbicacionEnEcuacion = new ArrayList<Double>();
		double[] arrayUbicacionEnEcuacion;
		
		listaUbicacionEnEcuacion = this.generarListaAuxiliarDeCeros(listaDispositivos);
		
		for(int i = 0; i < listaDispositivos.size(); ++i) {
			Dispositivo d = listaDispositivos.get(i);
			listaUbicacionEnEcuacion.set(i, (double)1);
			// se van alterando los valores en el array
			if(i != 0)
				listaUbicacionEnEcuacion.set((i-1), (double)0);
			
			arrayUbicacionEnEcuacion = listaUbicacionEnEcuacion.stream().mapToDouble(f -> f).toArray();
			
			sf.agregarRestriccion(Relationship.GEQ, d.getUsoMensualMinHs(), arrayUbicacionEnEcuacion);
			sf.agregarRestriccion(Relationship.LEQ, d.getUsoMensualMaxHs(), arrayUbicacionEnEcuacion);
		}
	}
	
	public void setearLimiteConsumoMensual(List<Dispositivo> lista, SimplexFacade simplex) throws IOException {
		
		List<Double> coeficientes = new ArrayList<Double>();
		double[] arrayCoeficientes;
		
		for (Dispositivo dispositivo: lista){
			coeficientes.add(dispositivo.getConsumoKwH());		
		}
		
	    arrayCoeficientes = coeficientes.stream().mapToDouble(f -> f).toArray();
		simplex.agregarRestriccion(Relationship.LEQ, 440640, arrayCoeficientes);	
	}
	
	public void generarFuncionEconomica(List<Dispositivo> lista, SimplexFacade simplex) {
		List<Double> listaFuncionEconomica = new ArrayList<Double>();
		double[] arrayFuncionEconomica;
		
		for(int i=0; i< lista.size(); ++i){
			listaFuncionEconomica.add((double) 1);			
		}
		
		arrayFuncionEconomica = listaFuncionEconomica.stream().mapToDouble(f -> f).toArray();
		simplex.crearFuncionEconomica(arrayFuncionEconomica);		
	}
	
	public List<Double> generarListaAuxiliarDeCeros(List<Dispositivo> lista){
		List<Double> listaDeCeros = new ArrayList<Double>();
		
		for(int i=0; i< lista.size(); ++i) {
			listaDeCeros.add((double) 0);			
		}
		
		return listaDeCeros;
	}
	
	public List<Dispositivo> obtenerResultados(double z, PointValuePair variables, List<Dispositivo> dispositivos){
	
		List<Dispositivo> dispositivosSobrepasados = new ArrayList<Dispositivo>();
		int inicio = 0;
		int cantidad = dispositivos.size();
	
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
		simplexFacade.crearFuncionEconomica(1,1,1,1,1,1,1,1);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, 0.06, 0.75, 0.64, 0.1275, 0.4, 0.08, .011, 1.013);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 0, 1);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360,0, 0, 0, 0, 0, 0, 0, 1);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 1, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 0, 0, 1, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 1, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 0, 1, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 60, 0, 0, 0, 0, 1, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 1, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 6, 0, 0, 0, 1, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 30, 0, 0, 0, 1, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 3, 0, 0, 1, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 15, 0, 0, 1, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 3, 0, 1, 0, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 30, 0, 1, 0, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 120, 1, 0, 0, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 1, 0, 0, 0, 0, 0, 0, 0);
		PointValuePair solucion = simplexFacade.resolver();
	
		z = solucion.getValue();
		variables = solucion;
	
		for (Dispositivo dispositivo : dispositivos){
			if (inicio < cantidad){
				if (variables.getPoint()[inicio] <= dispositivo.getConsumoKwH()){ /* consumo */
					System.out.println(variables.getPoint()[inicio]);
					System.out.println(dispositivo.getConsumoKwH()); /* consumo */
					dispositivosSobrepasados.add(dispositivo);
				}
			inicio=inicio+1;
			}
		}
		
		return dispositivosSobrepasados;
	}

}