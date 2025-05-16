package Interface;

import java.util.List;

import Domain.Computadora;

public interface MetodosCRUD {
	
	//Declaracion de CRUD basico
	
	//Crear registro
	public int guardarRegistro(Computadora cpu);
	
	//Mostrar registros
	public List<Computadora> mostrarRegistros();
	
	//Editar registro
	public int editarRegistro(Computadora cpu);
	
	//Borrar registro
	public void eliminarRegistro(String clave);
	
}
