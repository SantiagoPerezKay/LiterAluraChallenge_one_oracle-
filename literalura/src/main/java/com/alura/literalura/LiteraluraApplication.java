package com.alura.literalura;

import com.alura.literalura.api.GutendexClient;
import com.alura.literalura.model.Libro;
import com.alura.literalura.service.AutorService;
import com.alura.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);

	}
@Autowired
	GutendexClient gutendexClient;
@Autowired
	LibroService libroService;
@Autowired
	AutorService autorService;
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		System.out.println("===== Bienvenido a LiterAlura =====");

		do {
			System.out.println("\nSeleccione una opción:");
			System.out.println("1 - buscar libro en la api, ingrese el nombre de libro a buscar");
			System.out.println("2 -mostrar todos los libros agregados");
			System.out.println("3 - mostrar autores agregados");
			System.out.println("4 -  mostrar autores en un año determinado");
			System.out.println("5 - ..");
			System.out.println("6 - Salir");
			System.out.print("Ingrese opción: ");

			String entrada = scanner.nextLine();

			try {
				opcion = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Por favor, ingrese un número válido.");
				continue;
			}

			switch (opcion) {
				case 1:
					System.out.println("ingrese nombre de libro a buscar");
					String nombreLibro =  scanner.nextLine();

					Libro resultado = libroService.buscarYGuardar(nombreLibro);
					if (resultado != null) {
						System.out.println("Libro guardado: " + resultado.toString());
					} else {
						System.out.println("No se encontró el libro.");
					}


					break;
				case 2:
					System.out.println("lista de todos los libros: ");
					libroService.mostrarTodosLibros();
					break;
				case 3:
					System.out.println("lista de todos los autores: ");
					autorService.mostrarAutores();
					break;
				case 4:

					System.out.println("autor en un año determinado: ingrese el año menor a buscar ");
					Integer anio1=scanner.nextInt();
						System.out.println("autor en un año determinado: ingrese el año menor a buscar ");
						Integer anio2=scanner.nextInt();
					autorService.mostrarAutoresVivos(anio1,anio2);

					break;
				case 6:
					System.out.println("Saliendo... ¡Hasta luego!");
					break;
				default:
					System.out.println("Opción no válida.");
			}

		} while (opcion != 6);

		scanner.close();
	}
}
