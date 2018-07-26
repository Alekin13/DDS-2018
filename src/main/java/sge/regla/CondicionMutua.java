package sge.regla;


import sge.regla.Condicion;


public class CondicionMutua implements Condicion {

	private Condicion primera;
	private Condicion segunda;
	
	public CondicionMutua(Condicion primera, Condicion segunda) {
		this.primera = primera;
		this.segunda = segunda;
	}

	@Override
	public Boolean cumple(Integer medicion) {
		return primera.cumple(medicion) && segunda.cumple(medicion);
	}
}
