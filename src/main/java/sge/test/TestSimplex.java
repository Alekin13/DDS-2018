package sge.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sge.dispositivo.Dispositivo;
import sge.dispositivo.DispositivoEstandar;
import sge.dispositivo.DispositivoInteligente;
import sge.simplexSolver.SimplexFacade;
import sge.simplexSolver.SimplexHelper;
import sge.test.FactoryDispositivos;
public class TestSimplex {

	SimplexHelper simplexHelper = new  SimplexHelper();
	PointValuePair variables;
	List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	double z;
	@Before
	public void setup() {
		
		FactoryDispositivos factory = new FactoryDispositivos();
		
		DispositivoInteligente tvLed40 = factory.tvLED40();
		dispositivos.add(tvLed40);
		DispositivoInteligente lamparaAlogena11w = factory.lamparaAlogena11w();
		dispositivos.add(lamparaAlogena11w);
		DispositivoEstandar lavarropasSemiAutomatico5kg = factory.lavarropasSemiAutomatico5kg();
		dispositivos.add(lavarropasSemiAutomatico5kg);
		DispositivoEstandar pcDeEscritorio = factory.pcDeEscritorio();
		dispositivos.add(pcDeEscritorio);
		DispositivoInteligente aireAcondicionado2200 = factory.aireAcondicionado2200();
		dispositivos.add(aireAcondicionado2200);
		DispositivoEstandar microondas = factory.microondas();
		dispositivos.add(microondas);
		DispositivoEstandar plancha = factory.plancha();
		dispositivos.add(plancha);
		DispositivoInteligente ventiladorDeTecho = factory.ventiladorDeTecho();
		dispositivos.add(ventiladorDeTecho);

		/*
		 tvLed40.setPeriodos(factoryPeriodo.periodos10Horas());
		lamparaAlogena11w.setPeriodos(factoryPeriodo.periodos10Horas());
		lavarropasSemiAutomatico5kg.setHorasEncendido(10);
		pcDeEscritorio.setPeriodos(factoryPeriodo.periodos24Horas());
		aireAcondicionado2200.setPeriodos(factoryPeriodo.periodos10Horas());
		microondas.setHorasEncendido(14);
		plancha.setHorasEncendido(10);
		ventiladorDeTecho.setPeriodos(factoryPeriodo.periodos10Horas());
		 */
		
	}
	@Test
	public void testSimplexhelper() {
		List<Dispositivo> dispositivosSobrepasados = null;
		dispositivosSobrepasados = simplexHelper.obtenerResultados(z, variables, dispositivos);
		Assert.assertEquals("Cantidad de dispositivos sobre pasados",0, dispositivosSobrepasados.size());
	}
	@Test
	public void testEjemploEntrega8Dispositivos() {
		/**
			En este test se minimizará el siguiente modelo de programación lineal:
			- Función económica:
				f(x0,x1, x2) = x7+ x6+ x5+ x4+ x3+ x2+ x1+ x0
				En donde:
					
					- x0 -> Aire acondicionado 2200w cuyo consumo kWh es 1.013
					- x1 -> Lampara de 11w cuyo consumo kWh es 0.011
					- x2 -> Es un televisor LED de 40” cuyo consumo kWh es 0.08
					- x3 -> Computadora de escritorio cuyo consumo kWh es 0.4
					- x4 -> Es un semi-Automático de 5 kg  cuyo consumo kwH es 0.1275
					- x5 -> Microondas cuyo consumo kWh es 0.64
					- x6 -> Plancha cuyo consumo kWh es 0.75
					- x7 -> Ventilador cuyo consumo kWh es 0.06
					
			- Enfoque (GoalType):
				Maximización
			- Restricciones:
				1) 0.06x7 + 0.75x6 + 0.64x5 + 0.1275x4 + 0.4x3 + 0.08x2 + 0.011x1 + 1.013x0 <= 440640
				2) x0 >= 90
				3) x0 <= 360
				4) x1 >= 90
				5) x1 <= 360
				6) x2 >= 90
				7) x2 <= 360
				8) x3 >= 60
				9) x3 <= 360
				10) x4 >= 6
				11) x4 <= 30
				12) x5 >= 3
				13) x5 <= 15
				14) x6 >= 3
				15) x6 <= 30
				16) x7 >= 120
				17) x7 <= 360
				8) Todas las variables son no negativas (NonNegativeConstraint(true))
			NOTA: 
				- >= : Relationship.GEQ
				- <= : Relationship.LEQ
				- =  : Relationship.EQ
		 */
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
		simplexFacade.crearFuncionEconomica(1,1,1,1,1,1,1,1);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, 0.06, 0.75, 0.64, 0.1275, 0.4, 0.08, .011, 1.013);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 0, 1);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360,0, 0, 0, 0, 0, 0, 0, 1);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 0, 1, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 0, 0, 1, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 90, 0, 0, 0, 0, 0, 1, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 0, 1, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 60, 0, 0, 0, 0, 1, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 0, 0, 0, 0, 1, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 6, 0, 0, 0, 1, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 30, 0, 0, 0, 1, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 3, 0, 0, 1, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 15, 0, 0, 1, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 3, 0, 1, 0, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 30, 0, 1, 0, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.GEQ, 120, 1, 0, 0, 0, 0, 0, 0, 0);
		simplexFacade.agregarRestriccion(Relationship.LEQ, 360, 1, 0, 0, 0, 0, 0, 0, 0);
		PointValuePair solucion = simplexFacade.resolver();
		Assert.assertEquals(1875, solucion.getValue(), 0.01); 		//Valor de Z
		Assert.assertEquals(360, solucion.getPoint()[0], 0.01); 	// <--- X7
		Assert.assertEquals(30, solucion.getPoint()[1], 0.01); 		// <--- X6
		Assert.assertEquals(15, solucion.getPoint()[2], 0.01); 		// <--- X5
		Assert.assertEquals(30, solucion.getPoint()[3], 0.01); 		// <--- X4
		Assert.assertEquals(360, solucion.getPoint()[4], 0.01);		// <--- X3
		Assert.assertEquals(360, solucion.getPoint()[5], 0.01); 	// <--- X2
		Assert.assertEquals(360, solucion.getPoint()[6], 0.01); 	// <--- X1
		Assert.assertEquals(360, solucion.getPoint()[7], 0.01); 	// <--- X0		
		
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(0).getConsumoKwH() + " - " + dispositivos.get(0).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(1).getConsumoKwH() + " - " + dispositivos.get(1).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(2).getConsumoKwH() + " - " + dispositivos.get(2).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(3).getConsumoKwH() + " - " + dispositivos.get(3).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(4).getConsumoKwH() + " - " + dispositivos.get(4).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(5).getConsumoKwH() + " - " + dispositivos.get(5).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(6).getConsumoKwH() + " - " + dispositivos.get(6).getNombreDispositivo());
		System.out.println("Dispositivo: " + dispositivos.size() + " - " + dispositivos.get(7).getConsumoKwH() + " - " + dispositivos.get(7).getNombreDispositivo());
		
	}
}
