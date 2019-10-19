package ui;

import model.*;
import java.util.*;
import exceptions.*;

public class Main {
	private WorldCup system;
	private Scanner scan;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
	
	public Main() {
		system = new WorldCup("resources/people.csv");
		scan = new Scanner(System.in);
	}

	private void showMenu() {
		int userSelection = 0;
		
		do {
			options();
			userSelection = scan.nextInt();
			scan.nextLine();
			try {
				switch(userSelection) {
				case 1:
					System.out.println("Por favor digite el id de la persona");
					String id = scan.nextLine();
					
					if(system.findSpectator(id) == "") {
						throw new PersonNotFound("EL ID NO COINCIDE CON NINGUN ESPECTADOR");	
					}else {
						long t1 = System.nanoTime();
						System.out.println(system.findSpectator(id));
						long t2 = System.nanoTime();
						System.out.println("El tiempo que tardo en encontrarlo es:" + (t2-t1) +" nanosegs");
					}
				break;
				case 2:
					System.out.println("Por favor digite el id del competidor");
					id = scan.nextLine();
					
					try {
						long t1 = System.nanoTime();
						System.out.println(system.findCompetitor(id));
						long t2 = System.nanoTime();
						
						System.out.println("El tiempo que tardo en encontrarlo es:" + (t2-t1) + " nanosegs");
					}catch(CompetitorNotFound e) {
						System.out.println(e.getMessage());
					}
				break;
				case 3:
					System.out.println("Digite el pais del que desea saber los competidores");
					String country = scan.nextLine();
					
					System.out.println(system.showCompetitorsOfACountry(country));
				break;
				case 4:
					System.out.println("Digite el pais del que desea saber los espectadores");
					country = scan.nextLine();
					
					System.out.println(system.showSpectatorsOfACountry(country));
				break;
				case 5:
					System.out.println("Gracias por usar nuestro programa. Regrese pronto");
				break;
				}
			}catch(InputMismatchException e) {
				System.out.println("DIGITE UNA OPCION VALIDA.");
				scan.nextLine();
			}catch(PersonNotFound e) {
				System.out.println(e.getMessage());
			}
		}while(userSelection != 5);
	}

	private void options() {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("**********************************************************************************************************************************************");
		System.out.println("Escoja una de las siguientes opciones:");
		System.out.println("1. Buscar espectador por id");
		System.out.println("2. Buscar competidor por id");
		System.out.println("3. Mostrar lista de competidores de un pais");
		System.out.println("4. Mostrar arbol de espectadores de un pais");
		System.out.println("5. Salir");
		System.out.println("**********************************************************************************************************************************************");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
}
