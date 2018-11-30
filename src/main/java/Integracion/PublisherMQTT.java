package Integracion;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Scanner;

public class PublisherMQTT {
	Scanner scanner = new Scanner(System.in);
	
	
	public void setUpMQTTClient() throws MqttException  {
		MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
		
		System.out.println("== START Publisher ==");
		
		client.connect();


        while (true) {


            System.out.print("Ingresar mensaje:\t");
            String selection = scanner.nextLine();

            if (selection.equals("salir")) {
                break;
            } else {
                MqttMessage message = new MqttMessage();
                message.setPayload(selection.getBytes());
                client.publish("iot_data", message);
            }
        }

        client.disconnect();

        System.out.println("== END PUBLISHER ==");
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
}
