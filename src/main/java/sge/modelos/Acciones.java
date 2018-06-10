package sge.modelos;

public interface Acciones {
	public abstract void ejecutar();

}

/* OK, acciones es el command, porque es quien tiene el ejecutar adentro.
 * TODAS las acciones de las que te hable en CA_Actuador, van a implementar esta interfaz.
 */
