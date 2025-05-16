package Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Domain.Computadora;
import Implementacion.LogicaMetodos;

public class PrincipalCompuCel {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Declaramos una variable de scanner para ingresar los datos
		Scanner sc = new Scanner(System.in);

		// Declaramos los metodos a utilizar
		LogicaMetodos imp = new LogicaMetodos();

		// Variables
		String clave, marca, tipo, so = null;
		float precio = 0;
		int stock;
		int selecSO = 0;
		boolean verificarDatos = false;
		Computadora compuTemp = null;

		// Variable para opcion

		int menu = 0, subMenu = 0;
		List<Computadora> listaRegistros = new ArrayList<Computadora>();
		// Objetos de prueba

		// Menu Principal

		do {
			System.out.println("\n===== MENU COMPUCEL =====");

			System.out.println("1.-Agregar equipo");
			System.out.println("2.-Mostrar registros");
			System.out.println("3.-Buscar por clave");
			System.out.println("4.-Buscar por marca");
			System.out.println("5.-Buscar por Sistema Operativo");
			System.out.println("6.-Editar registro");
			System.out.println("7.-Eliminar registro");
			System.out.println("8.-Agregar datos de prueba");
			System.out.println("9.-Salir");
			System.out.println("Ingrese una opcion: ");
			menu = Integer.parseInt(sc.nextLine());
			try {

				switch (menu) {

				// Agregar Registro
				case 1:
					System.out.println("Tipo de equipo: ");
					tipo = sc.nextLine();
					System.out.println("Marca del equipo: ");
					marca = sc.nextLine();
					System.out.println("Clave del equipo: ");
					clave = sc.nextLine();
					while (true) {
						System.out.println("Sistema Operatido del equipo: ");
						System.out.println("1.-Windows 10");
						System.out.println("2.-Windows 11");
						System.out.println("3.-Distribución linux");
						System.out.println("4.-MacOS");
						selecSO = Integer.parseInt(sc.nextLine());
						if (selecSO > 0 && selecSO <= 4) {
							switch (selecSO) {
							case 1:
								so = "Windows 10";
								break;
							case 2:
								so = "Windows 11";
								break;
							case 3:
								so = "Distribución linux";
								break;
							case 4:
								so = "MacOS";
								break;

							default:
								break;
							}
							verificarDatos = true;
							break;
						} else {
							System.out.println("Valor invalido, intentalo de nuevo");
						}

					}

					while (true) {
						System.out.println("Precio del equipo: ");
						precio = Float.parseFloat(sc.nextLine());
						if (precio == 0) {
							System.out.println("Precio invalido, no se puede introducir 0 como precio");

						} else if (precio <= 0) {
							System.out.println("Precio invalido, no se puede introducir valores negativos");
						} else {
							break;
						}

					}
					while (true) {
						System.out.println("Piezas: ");
						stock = Integer.parseInt(sc.nextLine());
						if (stock < 0) {
							System.out.println("Stock invalido, no se puede introducir valores negativos");
						} else if (stock == 0) {
							System.out.println("Stock invalido, no se puede introducir 0 como stock");
						} else {
							break;
						}
					}

					int guardar = imp.guardarRegistro(new Computadora(tipo, marca, clave, so, precio, stock));
					switch (guardar) {
					case 1:
						System.out.println("Registro exitoso");
						break;
					case 2:
						System.out.println("Marca y clave duplicado, verifica los datos");
						break;
					case 0:
						System.out.println("Ha ocurrido un error, verifica los datos e intentalo de nuevo");
						break;
					default:
						break;
					}

					break;

				case 2:
					listaRegistros = imp.mostrarRegistros();

					if (listaRegistros == null) {
						System.out.println("No se encontraron registros");
					} else {
						System.out.println("Registros encontrados:\n");
						for (Computadora c : listaRegistros) {
							if (c.getStock() != 0) {
								System.out.println("Marca: " + c.getMarca());
								System.out.println("Tipo: " + c.getTipo());
								System.out.println("Clave: " + c.getClave());
								System.out.println("Sistema Operativo: " + c.getSo());
								System.out.println("Precio: " + c.getPrecio());
								System.out.println("Stock: " + c.getStock());
								System.out.println("\n");
							}
						}
						
					}

					break;

				case 3:
					System.out.println("Ingrese la clave del producto a buscar: ");
					clave = sc.nextLine();
					compuTemp = imp.buscarXclave(clave);
					if (compuTemp != null) {
						System.out.println("\nMarca: " + compuTemp.getMarca());
						System.out.println("Tipo: " + compuTemp.getTipo());
						System.out.println("Clave: " + compuTemp.getClave());
						System.out.println("Sistema Operativo: " + compuTemp.getSo());
						System.out.println("Precio: " + compuTemp.getPrecio());
						System.out.println("Stock: " + compuTemp.getStock());
						System.out.println("\n");
					} else {
						System.out.println("Registro no encontrado, verifica los datos e intentalo de nuevo\n");
					}
					break;
				case 4:
					System.out.println("Ingrese la marca: ");
					marca = sc.nextLine();

					listaRegistros = imp.buscarXmarca(marca);
					if (listaRegistros!=null) {
						System.out.println("Registros encontrados: ");
						for (Computadora c : imp.buscarXmarca(marca)) {
							System.out.println("\nMarca: " + c.getMarca());
							System.out.println("Tipo: " + c.getTipo());
							System.out.println("Clave: " + c.getClave());
							System.out.println("Sistema Operativo: " + c.getSo());
							System.out.println("Precio: " + c.getPrecio());
							System.out.println("Stock: " + c.getStock());
							System.out.println("\n");
						}
						
					} else {
						System.out.println("Registros no encontrados, verifica los datos e intentalo de nuevo\n");
					}

					break;
				case 5:
					System.out.println("Ingrese el Sistema Operativo: ");
					so = sc.nextLine();

					listaRegistros = imp.buscarXso(so);

					if (listaRegistros!=null) {
						System.out.println("Registros encontrados: ");
						for (Computadora c : listaRegistros) {
							System.out.println("\nMarca: " + c.getMarca());
							System.out.println("Tipo: " + c.getTipo());
							System.out.println("Clave: " + c.getClave());
							System.out.println("Sistema Operativo: " + c.getSo());
							System.out.println("Precio: " + c.getPrecio());
							System.out.println("Stock: " + c.getStock());
							System.out.println("\n");
						}
					} else {
						System.out.println("Registros no encontrados, verifica los datos e intentalo de nuevo\n");
					}
					break;
				case 6:

					System.out.println("Ingrese la marca: ");
					marca = sc.nextLine();
					System.out.println("Ingrese la clave del producto");
					clave = sc.nextLine();
					compuTemp = imp.buscarMarcaModelo(marca, clave);
					if (compuTemp != null) {

						while (true) {
							System.out.println("Ingrese el nuevo sistema operativo: ");
							System.out.println("1.-Windows 10");
							System.out.println("2.-Windows 11");
							System.out.println("3.-Distribución linux");
							System.out.println("4.-MacOS");
							selecSO = Integer.parseInt(sc.nextLine());
							if (selecSO > 0 && selecSO <= 4) {
								switch (selecSO) {
								case 1:
									compuTemp.setSo("Windows 10");
									break;
								case 2:
									compuTemp.setSo("Windows 11");
									break;
								case 3:
									compuTemp.setSo("Distribución linux");
									break;
								case 4:
									compuTemp.setSo("MacOS");
									break;

								default:
									break;
								}

								break;
							} else {
								System.out.println("Valor invalido, intentalo de nuevo");
							}

						}
						if (imp.editarRegistro(compuTemp) == 1) {
							System.out.println("Registro modificado con exito");
						}

					} else {
						System.out.println("Registro no encontrado");
					}

					break;

				case 7:
					System.out.println("Ingrese la marca: ");
					marca = sc.nextLine();
					System.out.println("Ingrese la clave del producto");
					clave = sc.nextLine();
					compuTemp = imp.buscarMarcaModelo(marca, clave);
					if (compuTemp != null) {
						imp.eliminarRegistro(clave);
						System.out.println("Registro eliminado");

					} else {
						System.out.println("Registro no encontrado");
					}
					break;
				case 8:
					imp.guardarRegistro(new Computadora("Laptop", "HP", "HP123", "Windows 10", 14500.00f, 10));
					imp.guardarRegistro(new Computadora("Escritorio", "Dell", "DL456", "Windows 11", 18999.99f, 7));
					imp.guardarRegistro(
							new Computadora("Laptop", "Lenovo", "LN789", "Distribución linux", 13500.75f, 5));
					imp.guardarRegistro(new Computadora("All-in-One", "Apple", "AP321", "MacOS", 25999.99f, 3));
					imp.guardarRegistro(new Computadora("Mini PC", "ASUS", "AS654", "Windows 10", 9999.50f, 12));
					System.out.println("Datos de prueba agregados exitosamente");
					break;
				case 9:
					System.out.println("Saliendo del programa");
					menu = 9;
				default:
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor ingresa datos válidos.");
				sc.nextLine(); // Limpiar buffer
			} catch (Exception e) {
				System.out.println("Ocurrió un error inesperado: " + e.getMessage());
			}

		} while (menu < 9);

		sc.close();
	}

}
