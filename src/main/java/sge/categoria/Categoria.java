package sge.categoria;

import sge.usuario.Cliente;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Categoria {

	@Id
	@GeneratedValue	
	private int id;
	
	private String categoria;
	private double cargoFijo;
	private double cargoVariable;

	public Categoria() {

	}

	public Categoria(String valorCategoria, double valorCargoFijo, double valorCargoVariable) {
		this.categoria = valorCategoria;
		this.cargoFijo = valorCargoFijo;
		this.cargoVariable = valorCargoVariable;
	}
	
	public void setearCategoria(String valorCategoria, double valorCargoFijo, double valorCargoVariable) {
		this.categoria = valorCategoria;
		this.cargoFijo = valorCargoFijo;
		this.cargoVariable = valorCargoVariable;
	}
	
	public void definirCategoriaCliente(Cliente unCliente) {
		if(unCliente.consumoCliente() <= 150){ unCliente.setCategoria(new Categoria("R1", 18.76,  0.644));}
		else if( unCliente.consumoCliente() <= 325 )	{unCliente.setCategoria(new Categoria("R2", 35.32,  0.644));}
		else if( unCliente.consumoCliente() <= 400 )	{unCliente.setCategoria(new Categoria("R3", 60.71,  0.681));}
		else if( unCliente.consumoCliente() <= 450 )	{unCliente.setCategoria(new Categoria("R4", 71.74,  0.738));}
		else if( unCliente.consumoCliente() <= 500 )	{unCliente.setCategoria(new Categoria("R5", 110.38, 0.794));}
		else if( unCliente.consumoCliente() <= 600 )	{unCliente.setCategoria(new Categoria("R6", 220.75, 0.832));}
		else if( unCliente.consumoCliente() <= 700 )	{unCliente.setCategoria(new Categoria("R7", 443.59, 0.851));}
		else if( unCliente.consumoCliente() <= 1400 )	{unCliente.setCategoria(new Categoria("R8", 545.96, 0.851));}
		else {unCliente.setCategoria(new Categoria("R9", 887.19, 0.851));}
	}
	
	public double calcularTarifa(Cliente unCliente ) {
		this.definirCategoriaCliente( unCliente );
		return this.getCargoVariable() * unCliente.consumoCliente() + this.getCargoFijo();
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(double cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	
}