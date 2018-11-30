package Entrega5;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.Test;

import Dispositivo.DispositivoInteligente;
import SensorActuador.ACT_CambiarTemperatura;
import SensorActuador.CondicionTemperaturaAlta;
import SensorActuador.Regla;
import SensorActuador.SensorTemperatura;

public class TestMQtt {

	
	public static void main(String[] args) throws MqttException, InterruptedException {
		
		DispositivoInteligente dispositivo = new DispositivoInteligente("Aire Acondicionado", "3500 frigorias", "I", "No", 1.613, 90, 360, "A");
		ACT_CambiarTemperatura actuador = new ACT_CambiarTemperatura();
		CondicionTemperaturaAlta condicion = new CondicionTemperaturaAlta();
		Regla regla = new Regla(condicion, actuador, dispositivo);
		SensorTemperatura sensor = new SensorTemperatura(0, "C");
		sensor.addObserver(regla);
		dispositivo.setValorInherente(40);
		dispositivo.setSensor(sensor);
		dispositivo.setActuador(actuador);
		System.out.println("Llega");
		sensor.suscripcion();
		
	}
}
