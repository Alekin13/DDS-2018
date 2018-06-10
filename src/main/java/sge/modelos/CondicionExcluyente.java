package sge.modelos;


import sge.modelos.Condicion;

public class CondicionExcluyente implements Condicion {

	private Condicion primera;
	private Condicion segunda;
	
	public CondicionExcluyente(Condicion primera, Condicion segunda) {
		this.primera = primera;
		this.segunda = segunda;
	}

	@Override
	public Boolean cumple(Integer medicion) {
		return primera.cumple(medicion) || segunda.cumple(medicion);
	}
}
