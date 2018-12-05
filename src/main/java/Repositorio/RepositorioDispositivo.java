package Repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Dispositivo.Dispositivo;
import Dispositivo.DispositivoFactory;
import Dispositivo.DispositivoMaestro;
import Usuario.Administrador;

public class RepositorioDispositivo {

	private EntityManager em;
	
	public RepositorioDispositivo(EntityManager manager) {
		this.em = manager;
	}
	
	public List<DispositivoMaestro> listarMaestros() {
		List<DispositivoMaestro> lista = new ArrayList<>();
		DispositivoMaestro fact = new DispositivoMaestro();
		lista.add(fact.aireAcondicionado2200());
		lista.add(fact.aireAcondicionado3500());
		lista.add(fact.heladera());
		lista.add(fact.heladeraFreezer());
		lista.add(fact.lamparaAlogena100w());
		lista.add(fact.lamparaAlogena11w());
		lista.add(fact.lamparaAlogena15w());
		lista.add(fact.lamparaAlogena20w());
		lista.add(fact.lamparaAlogena40w());
		lista.add(fact.lamparaAlogena60w());
		lista.add(fact.lavarropas5k());
		lista.add(fact.lavarropas5kgCalendadorDeAgua());
		lista.add(fact.lavarropasSemiAutomatico5kg());
		lista.add(fact.microondas());
		lista.add(fact.pcDeEscritorio());
		lista.add(fact.plancha());
		lista.add(fact.tvLCD40());
		lista.add(fact.tvLED40());
		lista.add(fact.tvLED32());
		lista.add(fact.tvLED24());
		lista.add(fact.tvTubo21());
		lista.add(fact.tvTubo29_34());
		lista.add(fact.ventiladorDePie());
		lista.add(fact.ventiladorDeTecho());
		
		return lista;
	}

	public void agregarMaestro(Dispositivo dispositivo) {
		
		em.getTransaction().begin();
		em.persist(dispositivo);
		em.getTransaction().commit();

	}

	public void agregarDispositivosMaestro(List<DispositivoMaestro> dispositivos) {
		
		for (DispositivoMaestro dispositivo : dispositivos) {
			em.getTransaction().begin();
			em.persist(dispositivo);
			em.getTransaction().commit();

		}
		
		
	}
}
