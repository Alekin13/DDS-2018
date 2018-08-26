package sge.helperClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.optim.linear.Relationship;

import sge.dispositivo.Dispositivo;
import sge.properties.ManejoProperties;
import sge.simplexSolver.SimplexFacade;
import sge.usuario.*;

public class SGEHelperClass {
	/* SGEHelperClasses esta destinado a facilitar el manejo de funciones que nada
	 * tengan que ver con los requerimientos principales, para cumplir con los 
	 * principios SOLID, no sobreasignar tareas que no son propias de una clase 
	 * */
	
	public List<Double> generarListaAuxiliarDeCeros(List<Dispositivo> listaDispositivos){
		List<Double> listaDeCeros = new ArrayList<Double>();
		
		for(int i=0; i<listaDispositivos.size(); ++i) {
			listaDeCeros.add((double) 0);			
		}
		
		return listaDeCeros;
	}
	
	
	public void generarFuncionEconomica(List<Dispositivo> listaDispositivos, SimplexFacade sf) {
		List<Double> listaFuncionEconomica = new ArrayList<Double>();
		double[] arrayFuncionEconomica;
		
		for(int i=0; i<listaDispositivos.size(); ++i) {
			listaFuncionEconomica.add((double) 1);			
		}
		
		arrayFuncionEconomica = listaFuncionEconomica.stream().mapToDouble(f -> f).toArray();
		sf.crearFuncionEconomica(arrayFuncionEconomica);		
	}
	
	
	public void setearLimiteConsumoMensual(List<Dispositivo> listaDispositivos, SimplexFacade sf) throws IOException {
		List<Double> listaCoeficientes = new ArrayList<Double>();
		double[] arrayCoeficientes;
		ManejoProperties manejoPropertiesAuxiliar = new ManejoProperties();
		
	    for (Dispositivo d: listaDispositivos) {
			listaCoeficientes.add(d.obtenerCoeficiente());		
		}
		
	    arrayCoeficientes = listaCoeficientes.stream().mapToDouble(f -> f).toArray();
		sf.agregarRestriccion(Relationship.LEQ, manejoPropertiesAuxiliar.obtenerLimiteConsumoMensual(), arrayCoeficientes);	
	}
	
	
	public void setearRestriccionesConsumo(List<Dispositivo> listaDispositivos, SimplexFacade sf) throws IOException {
		List<Double> listaUbicacionEnEcuacion = new ArrayList<Double>();
		double[] arrayUbicacionEnEcuacion;
		
		listaUbicacionEnEcuacion = this.generarListaAuxiliarDeCeros(listaDispositivos);
		
		for(int i = 0; i < listaDispositivos.size(); ++i) {
			Dispositivo d = listaDispositivos.get(i);
			listaUbicacionEnEcuacion.set(i, (double)1);
			// se van alterando los valores en el array
			if(i != 0) {
				listaUbicacionEnEcuacion.set((i-1), (double)0);
			}
			
			arrayUbicacionEnEcuacion = listaUbicacionEnEcuacion.stream().mapToDouble(f -> f).toArray();
			
			sf.agregarRestriccion(Relationship.GEQ, d.obtenerUsoMensualMinHS(), arrayUbicacionEnEcuacion);
			sf.agregarRestriccion(Relationship.LEQ, d.obtenerUsoMensualMaxHS(), arrayUbicacionEnEcuacion);
		}
	}
	
	public List<Dispositivo> filtrarDispositivoHeladera(Cliente unUsuario) throws FileNotFoundException, IOException {
		List<Dispositivo> listaAuxiliar = new ArrayList<Dispositivo>();
		
		listaAuxiliar.addAll(unUsuario.getDispositivos()); 
			
		for(Dispositivo d : unUsuario.getDispositivos()) {
		
			String aux = d.obtenerNombreDispositivo();
			
			if (aux.equals(new String("heladera"))) {
				listaAuxiliar.remove(d);
			}
		}		
	
		return listaAuxiliar;
		
	}

}
