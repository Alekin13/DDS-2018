package Usuario;

import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue
	private int id;
	@Column(name="nombre")
	private String categoria;
	@Column(name="cargoFijo")
	private double cargoFijo;
	@Column(name="cargoVariable")
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
	
	public void definirCategoriaCliente(Cliente unCliente){
		if(unCliente.consumoCliente() <= 150){ 
			unCliente.setCategoria("R1");
			this.setearCategoria("R1", 18.76,  0.644);
		}
		else if( unCliente.consumoCliente() <= 325){
			unCliente.setCategoria("R2");
			this.setearCategoria("R2", 35.32,  0.644);
		}
		else if(unCliente.consumoCliente() <= 400){
			unCliente.setCategoria("R3");
			this.setearCategoria("R3", 60.71,  0.681);
		}
		else if(unCliente.consumoCliente() <= 450){
			unCliente.setCategoria("R4");
			this.setearCategoria("R4", 71.74,  0.738);
		}
		else if(unCliente.consumoCliente() <= 500){
			unCliente.setCategoria("R5");
			this.setearCategoria("R5", 110.38, 0.794);
		}	
		else if(unCliente.consumoCliente() <= 600){
			unCliente.setCategoria("R6");
			this.setearCategoria("R6", 220.75, 0.832);
		}
		else if(unCliente.consumoCliente() <= 700){
			unCliente.setCategoria("R7");
			this.setearCategoria("R7", 443.59, 0.851);
		}
		else if(unCliente.consumoCliente() <= 1400){
			unCliente.setCategoria("R8");
			this.setearCategoria("R8", 545.96, 0.851);
		}
		else{
			unCliente.setCategoria("R9");
			this.setearCategoria("R9", 887.19, 0.851);
		}
	}
	
	public double calcularTarifa(Cliente unCliente ) {
		this.definirCategoriaCliente(unCliente);
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