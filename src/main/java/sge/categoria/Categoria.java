package sge.categoria;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import sge.usuario.Cliente;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "categoria", "cargoFijo", "cargoVariable" })

public class Categoria {

	@JsonProperty("categoria")
	private String categoria;

	@JsonProperty("cargoFijo")
	private double cargoFijo;

	@JsonProperty("cargoVariable")
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
	
	//Setea la categoria que le corresponde y sus cargos
	//	public void definirCategoriaCliente(double consumo, Categoria categoria) {
	//		if(consumo <= 150){ categoria.setearCategoria("R1", 18.76,  0.644);}
	//		else if(consumo <= 325 )	{categoria.setearCategoria("R2", 35.32,  0.644);}
	//		else if(consumo <= 400 )	{categoria.setearCategoria("R3", 60.71,  0.681);}
	//		else if(consumo <= 450 )	{categoria.setearCategoria("R4", 71.74,  0.738);}
	//		else if(consumo <= 500 )	{categoria.setearCategoria("R5", 110.38, 0.794);}
	//		else if(consumo <= 600 )	{categoria.setearCategoria("R6", 220.75, 0.832);}
	//		else if(consumo <= 700 )	{categoria.setearCategoria("R7", 443.59, 0.851);}
	//		else if(consumo <= 1400 )	{categoria.setearCategoria("R8", 545.96, 0.851);}
	//		else 						{categoria.setearCategoria("R9", 887.19, 0.851);}
	//	}

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
	
	//Deberia calcular el total de la cuenta por mes
	//	public double calcularTarifa(Categoria categoria, double consumo) {
	//		categoria.definirCategoriaCliente(consumo, categoria);
	//		double tarifa = categoria.getCargoVariable()*consumo + categoria.getCargoFijo();
	//		return tarifa;
	//	}
	//	

	//Deberia calcular el total de la cuenta por mes
	public double calcularTarifa( Cliente unCliente ) {
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

	public void setCargoFijo(Float cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(Float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	
}