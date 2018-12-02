package Repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

import Zona.Transformador;

public class RepositorioTransformadores {

	private EntityManager entityManager;

	public RepositorioTransformadores(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Transformador> listar() {
		List<Transformador> lista = entityManager.createQuery("SELECT t FROM Transformador t", Transformador.class)
				.getResultList();
		return lista;
	}

	public Transformador buscar(int id) {
		Transformador t = entityManager.find(Transformador.class, id);
		return t;
	}

	public List<Map<String, String>> consumoPromedioPorPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		List<Map<String, String>> reporte = new ArrayList<>();

		List<Transformador> transformadores = listar();

		for (Transformador transformador : transformadores) {
			Map<String, String> item = new HashMap<>();
			item.put("id", String.valueOf(transformador.getId()));
			item.put("latitud", String.valueOf(transformador.getLatitud()));
			item.put("longitud", String.valueOf(transformador.getLongitud()));
			item.put("cantidadClientesConectados", String.valueOf(transformador.getClientesConectados().size()));
			item.put("consumo", String.valueOf(transformador.consumoPromedioEntre(inicio, fin)));

			reporte.add(item);
		}

		return reporte;
	}
}
