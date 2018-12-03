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
		List<DispositivoEstado> resultList = (List<DispositivoEstado>) dbhelper.entityManager().createNativeQuery("select e.* from Dispositivo d, Dispositivo_Estados e where DISP_CLIENTE_ID = :idCliente and idDispositivo = DISP_ID and DATE(fechaDeCambioDeEstado) between STR_TO_DATE( " + '"' + fDesde.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() + '"' + ",  '%d/%m/%Y') " + " and " + " STR_TO_DATE( " + '"' + fHasta.plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() + '"' + ",  '%d/%m/%Y')", DispositivoEstado.class).setParameter("idCliente", hogar.getId()).getResultList();
		
		for(DispositivoEstado e : resultList){
			consumo += e.getConsumoEstadoPasado();
		}
		
		System.out.println("Hogar: " + hogar.getApellido() + " " + hogar.getNombre() + " Consumio: " + consumo);
		
	}
	
	public void consumoTransformadorxPeriodo(Transformador trans, LocalDateTime fDesde, LocalDateTime fHasta) {
		
		EntityManagerHelper dbhelper = new EntityManagerHelper();
		double consumo = 0;
		
		@SuppressWarnings("unchecked")
		List<DispositivoEstado> resultList = (List<DispositivoEstado>) dbhelper.entityManager().createNativeQuery("select e.* from Dispositivo d, Dispositivo_Estados e, usuario u WHERE DISP_CLIENTE_ID = u.id and e.idDispositivo = d.DISP_ID and u.transformador_id = :transformador and DATE(fechaDeCambioDeEstado) between STR_TO_DATE( " + '"' + fDesde.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() + '"' + ",  '%d/%m/%Y') " + " and " + " STR_TO_DATE( " + '"' + fHasta.plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() + '"' + ",  '%d/%m/%Y')", DispositivoEstado.class).setParameter("transformador", trans.getId()).getResultList();
		
		for(DispositivoEstado e : resultList){
			consumo += e.getConsumoEstadoPasado();
		}
		
		trans.setConsumo(trans.getConsumo()+consumo);
		dbhelper.modificar(trans);
		System.out.println("Transformador: " + trans.getId() + " Consumio: " + consumo);
		
	}
}
