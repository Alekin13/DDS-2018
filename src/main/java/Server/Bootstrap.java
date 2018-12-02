package Server;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import Dispositivo.DispositivoFactory;

public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {
	public static void main(String[] args) {
		new Bootstrap().init();
	}

	public void init() {

		withTransaction(() -> {
			
			DispositivoFactory maestro = new DispositivoFactory();
			persist(maestro.aireAcondicionado2200());
			persist(maestro.aireAcondicionado3500());
			persist(maestro.heladera());
			persist(maestro.heladeraFreezer());
			persist(maestro.lamparaAlogena100w());
			

		});

	}
}
