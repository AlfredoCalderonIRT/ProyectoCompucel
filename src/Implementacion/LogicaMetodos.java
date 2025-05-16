package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Domain.Computadora;
import Interface.MetodosBusquedaAvanzada;
import Interface.MetodosCRUD;

public class LogicaMetodos implements MetodosCRUD, MetodosBusquedaAvanzada {

	private List<Computadora> listaCPU = new ArrayList<Computadora>();
	private boolean validarDato = false;

	@Override
	public int guardarRegistro(Computadora cpu) {

		for (Computadora c : listaCPU) {
			if (c.getMarca().equalsIgnoreCase(cpu.getMarca()) && c.getClave().equalsIgnoreCase(cpu.getClave())) {
				validarDato = true;
				return 2;

			}
		}

		if (!validarDato) {
			listaCPU.add(cpu);
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public List<Computadora> mostrarRegistros() {

		if (listaCPU.isEmpty()) {
			return null;
		} else {
			return new ArrayList<>(listaCPU);
		}

	}

	@Override
	public int editarRegistro(Computadora cpu) {
		for(int i=0;i<listaCPU.size();i++) {
			if(listaCPU.get(i).getClave().equalsIgnoreCase(cpu.getClave())) {
				listaCPU.set(i, cpu);
				return 1;
			}
		}
		return 0;

	}



	@Override
	public List<Computadora> buscarXmarca(String marca) {
		List<Computadora> filtroMarca = new ArrayList<Computadora>();
		if (listaCPU.isEmpty()) {
			return null;
		} else {
			for (Computadora c : listaCPU) {
				if (c.getMarca().equalsIgnoreCase(marca)) {
					filtroMarca.add(c);
				}
			}
			return filtroMarca;
		}
	}

	@Override
	public List<Computadora> buscarXso(String SO) {
		List<Computadora> filtroMarca = new ArrayList<Computadora>();
		if (listaCPU.isEmpty()) {
			return null;
		} else {
			for (Computadora c : listaCPU) {
				if (c.getSo().equalsIgnoreCase(SO)) {
					filtroMarca.add(c);
				}
			}
			return filtroMarca;
		}
	}

	@Override
	public Computadora buscarXclave(String clave) {

		if (listaCPU.isEmpty()) {
			return null;
		} else {
			for (Computadora c : listaCPU) {
				if (c.getClave().equalsIgnoreCase(clave)) {
					return c;
				}
			}
		}

		return null;
	}

	@Override
	public Computadora buscarMarcaModelo(String marca, String clave) {
		if(listaCPU.isEmpty()) {
			return null;
			
		}else {
			for(Computadora c : listaCPU) {
				if(c.getClave().equalsIgnoreCase(clave)&&c.getMarca().equalsIgnoreCase(marca)) {
					return c;
				}
			}
		}
		return null;
	}

	@Override
	public void eliminarRegistro(String clave) {
		listaCPU.removeIf(e -> e.getClave().equalsIgnoreCase(clave));
		
		
	}

	

}
