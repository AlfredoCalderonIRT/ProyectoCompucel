package Interface;

import java.util.List;

import Domain.Computadora;

public interface MetodosBusquedaAvanzada {
	
	//Metodos de busqueda avanzada
	
	//Buscar por marca
	public List<Computadora> buscarXmarca(String marca);
	
	//Buscar por Sistema Operativo
	public List<Computadora> buscarXso(String SO);
	
	//Buscar por clave
	public Computadora buscarXclave(String clave);
	
	//Buscar por marca y modelo
	public Computadora buscarMarcaModelo(String marca, String clave);
	
	
	
	
	
	
	
	
	

}
