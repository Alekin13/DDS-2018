package sge.procEjecSimplex;


import sge.usuario.*;

public class ProcesoEjecucionSimplex {
	private long rangoEjecucionSegs = 0;
	private Usuario unUsuario;
	
	public ProcesoEjecucionSimplex(long unRangoDeEjecucion, Usuario unUsuario) {
		rangoEjecucionSegs = unRangoDeEjecucion;
		unUsuario = unUsuario;
	}

	public long getRangoEjecucionSegs() {
		return rangoEjecucionSegs;
	}

	public void setRangoEjecucionSegs(long rangoEjecucionSegs) {
		this.rangoEjecucionSegs = rangoEjecucionSegs;
	}
	
	
}

//
//public class Restriccion{
//	private int minimo;
//	private int maximo;
//	private String nombreRestriccion;
//	
//	
//	
//	
//}