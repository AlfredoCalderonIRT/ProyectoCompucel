package Domain;

public class Computadora {

	// Declaracion de atributos de clase

	private String tipo, marca, clave, so;
	private float precio;
	private int stock;

	public Computadora(String tipo, String marca, String clave, String so, float precio, int stock) {
		this.tipo = tipo;
		this.marca = marca;
		this.clave = clave;
		this.so = so;
		this.precio = precio;
		this.stock = stock;

	}

	@Override
	public String toString() {
		return "Computadora [clave=" + clave + ", marca=" + marca + ", so=" + so + ", tipo=" + tipo + ", precio="
				+ precio + ", stock=" + stock + "]\n";
	}

	// Encapsulamiento de clase
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
