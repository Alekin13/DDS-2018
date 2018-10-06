package Dispositivo;

public class DispositivoAdaptador extends DispositivoInteligente {

	public DispositivoAdaptador(DispositivoEstandar dispositivoEstandar) {
		super.setBajoConsumo(dispositivoEstandar.getBajoConsumo());
		super.setConsumoKwH(dispositivoEstandar.getConsumoKwH());
		super.setEquipoConcreto(dispositivoEstandar.getEquipoConcreto());
		super.setEstado("E");
		super.setNombreDispositivo(dispositivoEstandar.getNombreDispositivo());
		super.setTipoDispositivo("A");
		super.setUsoMensualMaxHs(dispositivoEstandar.getUsoMensualMaxHs());
		super.setUsoMensualMinHs(dispositivoEstandar.getUsoMensualMinHs());
				
	}

}
