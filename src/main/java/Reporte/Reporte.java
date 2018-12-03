package Reporte;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Dispositivo.DispositivoEstado;
import Helper.EntityManagerHelper;
import Usuario.Cliente;
import Zona.Transformador;

public class Reporte {

	public void consumoHogarxPeriodo(Cliente hogar, LocalDateTime fDesde, LocalDateTime fHasta) {
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		double consumo = 0;
		
		@SuppressWarnings("unchecked")
		List<DispositivoEstado> resultList = (List<DispositivoEstado>) dbhelper.entityManager().createNativeQuery("select e.* from Dispositivo d, Dispositivo_Estados e where DISP_CLIENTE_ID = 1 and idDispositivo = DISP_ID and DATE_FORMAT(STR_TO_DATE(fechaDeCambioDeEstado, '%Y-%m-%d'), '%d/%m/%Y') between " + '"' +fDesde.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()+ '"' + " and " + '"' +fHasta.plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()+ '"' , DispositivoEstado.class).getResultList();
		
		for(DispositivoEstado e : resultList){
			consumo += e.getConsumoEstadoPasado();
		}
		
		System.out.println("Hogar: " + hogar.getApellido() + " " + hogar.getNombre() + " Consumio: " + consumo);
		
	}
	
	public void consumoTransformadorxPeriodo(Transformador trans, LocalDateTime fDesde, LocalDateTime fHasta) {
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		double consumo = 0;
		
		@SuppressWarnings("unchecked")
		List<DispositivoEstado> resultList = (List<DispositivoEstado>) dbhelper.entityManager().createNativeQuery("select e.* from Dispositivo d, Dispositivo_Estados e, transformador t where DISP_CLIENTE_ID = 1 and idDispositivo = DISP_ID and DATE_FORMAT(STR_TO_DATE(fechaDeCambioDeEstado, '%Y-%m-%d'), '%d/%m/%Y') between " + '"' +fDesde.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()+ '"' + " and " + '"' +fHasta.plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()+ '"' , DispositivoEstado.class).getResultList();
		
		for(DispositivoEstado e : resultList){
			consumo += e.getConsumoEstadoPasado();
		}
		
		//System.out.println("Hogar: " + hogar.getApellido() + " " + hogar.getNombre() + " Consumio: " + consumo);
		
	}
}
