package Server;

import spark.Spark;
import spark.debug.DebugScreen;

public class Server2000 {
	public static void main(String[] args) {
		Spark.port(8080);
		Spark.threadPool(4);
		DebugScreen.enableDebugScreen();
		Router.configure();
	}
}