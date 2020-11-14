package ui;
import model.MathApp;
import java.util.Scanner;

public class Main{

	//Global variable
	public Scanner lector;

	//Relationship
	private MathApp mainMathApp;

	public Main(){
		lector = new Scanner(System.in);
		mainMathApp = new MathApp();
	}

	public static void main(String[] args){
		System.out.println(
			"\n************************************************************************************************************************\n"+   
			"                                 Bienvenido a la aplicacion sobre teoria basica de conjuntos" 
		);
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!=8);
	}

	public int menu(){
		int option = 0;
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                               Seleccione una opcion para continuar"+
				"\n************************************************************************************************************************\n"+
				"      1. Crear un nuevo conjunto\n"+
				"      2. Eliminar un conjunto\n"+
				"      3. Agregar un elemento a un conjunto\n"+
				"      4. Eliminar un elemento de un conjunto\n"+
				"      5. Realizar una operacion entre dos conjuntos\n"+
				"      6. Conocer el contenido de un conjunto en especifico\n"+
				"      7. Conocer el contenido de todos los conjuntos creados\n"+
				"      8. Finalizar la aplicacion\n"
			);
			option = lector.nextInt(); lector.nextLine();
			switch (option){
				case 1:
					createSet();
					menu = false;
					break;
				case 2:
					deleteSet();
					menu = false;
					break;
				case 3:
					addElements();
					menu = false;
					break;
				case 4:
					deleteElement();
					menu = false;
					break;
				case 5:
					executeOperation();
					menu = false;
					break;
				case 6:
					displaySet();
					menu = false;
					break;
				case 7:
					displayAllSets();
					menu = false;
					break;
				case 8:
					System.out.println("\n************************************************************************************************************************\n"+"Gracias por utilizar nuestra aplicacion"+"\n************************************************************************************************************************\n");
					menu = false;
					break;
				default:
					System.out.println("\n************************************************************************************************************************\n"+"Error, opcion no valida");
					menu = false;
					break;		
			}
		} return option;
	}

	public void createSet(){
		String nameSet, message;
		boolean find = true;
		do{
			System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                                      Crear un conjunto"+
				"\n************************************************************************************************************************"
			);
			System.out.println("\nIngrese el nombre que desea darle al conjunto: ");
			nameSet = lector.nextLine();
			find = mainMathApp.verifySet(nameSet);
			if(!find){
				mainMathApp.addSet(nameSet);
				message = "\nEl conjunto ha sido agregado exitosamente";
				System.out.println(message);
			} else{
				message = "\nEl nombre ya ha sido asignando a otro conjunto, intentelo nuevamente";
				System.out.println(message);
			}
		} while(find);
	}

	public void deleteSet(){
		String message;
		boolean find;
		do{
			System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                                     Eliminar un conjunto"+
				"\n************************************************************************************************************************"
			);
			System.out.println("\nIngrese el nombre del conjunto que desea eliminar: ");
			String nameSet = lector.nextLine();
			find = mainMathApp.verifySet(nameSet);
			if(find){
				mainMathApp.removeSet(nameSet);
				message = "\nEl conjunto ha sido eliminado exitosamente";
				System.out.println(message);
			} else{
				message = "\nEl conjunto no existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(!find);	
	}

	public void addElements(){
		String nameSet, message;
		boolean find;
		int number;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                               Agregar un elemento a un conjunto"+
			"\n************************************************************************************************************************"
		);
		do{
			System.out.println("\nIngrese el nombre del conjunto: ");
			nameSet = lector.nextLine();
			find = mainMathApp.verifySet(nameSet);
			if(!find){
				message = "\nEl conjunto no existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(!find);
		do{	
			System.out.println("\nDigite el numero entero que desea agregar: ");
			number = lector.nextInt();
			message = mainMathApp.addElementMessage(nameSet,number);
			System.out.println(message);
		} while(message.equals("\nEl elemento ya existe, intentelo nuevamente"));	
	}

	public void deleteElement(){
		String nameSet, message;
		int number;
		boolean find;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                              Eliminar un elemento de un conjunto"+
			"\n************************************************************************************************************************"
		);
		do{	
			System.out.println("\nIngrese el nombre del conjunto: ");
			nameSet = lector.nextLine();
			find = mainMathApp.verifySet(nameSet);
			if(!find){
				message = "\nEl conjunto no existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(!find);
		do{	
			System.out.println("\nDigite el numero entero que desea eliminar: ");
			number = lector.nextInt();
			message = mainMathApp.removeElementMessage(nameSet,number);
			System.out.println(message);
		} while(message.equals("\nEl elemento no existe, intentelo nuevamente"));		
	}

	public void executeOperation(){
		String message, name1, name2, newName;
		boolean find;
		int option = 0;
		do{
		   	System.out.println(
		   		"\n************************************************************************************************************************\n"+
		   		"                                               Realizar una operacion"+
		   		"\n************************************************************************************************************************\n"+
		   		"      Escoga el tipo de operacion que desea llevar a cabo:\n"+
		   		"      1. Union\n"+
		   		"      2. Interseccion\n"+
		   		"      3. Diferencia\n"+
		   		"      4. Diferencia simetrica\n"
		   	);
			option = lector.nextInt(); lector.nextLine();
			if (option!=1 && option!=2 && option!=3 && option!=4){
				message = "\nIngrese una opcion correcta";
				System.out.println(message);
			}
		} while(option!=1 && option!=2 && option!=3 && option!=4);
		do{
		   	System.out.println("\nIngrese el nombre del primer conjunto para realizar la operacion: ");
		   	name1 = lector.nextLine();
		   	find = mainMathApp.verifySet(name1);
		   	if(!find){
				message = "\nEl conjunto no existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(!find);	
		do{
		   	System.out.println("\nIngrese el nombre del segundo conjunto para realizar la operacion: ");
		   	name2 = lector.nextLine();
		   	find = mainMathApp.verifySet(name2);
		   	if(!find){
				message = "\nEl conjunto no existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(!find);
		do{
		   	System.out.println("\nIngrese un nombre para el nuevo conjunto que representara la operacion: ");
		   	newName = lector.nextLine();
		   	find = mainMathApp.verifySet(newName);
		   	if(find){
				message = "\nEl conjunto ya existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(find);		
		switch (option){
		   	case 1:	
		   		message = mainMathApp.showUnionOperation(name1,name2,newName);
		   		System.out.println(message);
				break;
			case 2:
		   		message = mainMathApp.showIntersection(name1,name2,newName);
		   		System.out.println(message);
				break;
			case 3:
		   		message = mainMathApp.showDifferenceOperation(name1,name2,newName);
		   		System.out.println(message);
				break;
			case 4:
				message = mainMathApp.showSymmetricDifferenceOperation(name1,name2,newName);
				System.out.println(message);
				break;
		}
	}

	public void displaySet(){
		String message, name;
		boolean find;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                              Conocer los elementos de un conjunto"+
			"\n************************************************************************************************************************"
		);
		do{
			System.out.println("\nIngrese el nombre del conjunto: ");
			name = lector.nextLine();
			find = mainMathApp.verifySet(name);
			if(!find){
				message = "\nEl conjunto no existe, intentelo nuevamente";
				System.out.println(message);
			}
		} while(!find);
		message = mainMathApp.showInfoSet(name);
		System.out.println(message);
	}

	public void displayAllSets(){
		String message = mainMathApp.showInfoSets();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                               Conocer todos conjuntos creados"+
			"\n************************************************************************************************************************"+
			message
		);
	}
}