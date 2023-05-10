package ec.formos.test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ec.formos.test.bo.LogicalSales;
import ec.formos.test.entity.Fruit;
import ec.formos.test.entity.Inventory;
import ec.formos.test.util.Constants;

public class DrinkFruit {

	/**
	 * Initialize fruit
	 */
	static List<Inventory> registerInventory = new ArrayList<Inventory>();

	static Fruit strawberry;
	static Fruit banana;
	static Fruit mango;

	static Inventory inventory = new Inventory();
	static LogicalSales logic = new LogicalSales();

	/***
	 * 
	 * @param options
	 */
	public static void printMenu(String[] options) {
		for (String option : options) {
			System.out.println(option);
		}
		System.out.print("Choose your option : ");
	}

	public static void main(String[] args) {

		initFruits();

		System.out.println("***********************************************");
		System.out.println("*******  Blended Fruit Drink ******************");
		System.out.println("***********************************************");
		System.out.println("*******  Autor: Santiago Simbaña **************");
		System.out.println("*******  Date: 12/05/2023    ******************");
		System.out.println("***********************************************");

		String[] options = { "1- Inventory Reports ", "2- Sales ", "3- Other ", "4- Exit", };
		String[] sabores = { "		1. Strawberry", "		2. banana", "		3. mango" };

		Scanner scanner = new Scanner(System.in);

		int option = 1;
		while (option != 4) {
			printMenu(options);
			try {
				option = scanner.nextInt();
				switch (option) {
				case 1:
					reportMovements();
					break;
				case 2:
					printMenu(sabores);
					Scanner scannerSabor = new Scanner(System.in);
					int sabor = 0;
					switch (scannerSabor.nextInt()) {
					case 1:
						System.out.println("seleccciono s");
						saleDrink(Constants.ID_FRUIT_STRAWBERRY);
						break;
					case 2:
						System.out.println("seleccciono b");
						saleDrink(Constants.ID_FRUIT_BANANA);
						break;
					case 3:
						System.out.println("seleccciono m");
						saleDrink(Constants.ID_FRUIT_MANGO);
						break;
					default:
						System.out.println("opcion no valida");
						break;
					}
					break;
				case 3:

					break;
				case 4:

					System.out.println("Thanks for use ");
					System.exit(0);

				}
			} catch (Exception ex) {
				System.out.println("Please enter an integer value between 1 and " + options.length);
				scanner.next();
			}
		}
	}

	/***
	 * 
	 */
	private static void initFruits() {
		System.out.println("Objects Init");
		strawberry = new Fruit(Constants.ID_FRUIT_STRAWBERRY, Constants.FRUIT_STRAWBERRY,
				(250 * Constants.FRUIT_DRINK_ML_100 / Constants.FRUIT_STRAWBERRY_GR),
				Constants.VALUE_INITIAL_STOCK_FRUIT);
		banana = new Fruit(Constants.ID_FRUIT_BANANA, Constants.FRUIT_BANANA,
				(460 * Constants.FRUIT_DRINK_ML_100 / Constants.FRUIT_STRAWBERRY_GR),
				Constants.VALUE_INITIAL_STOCK_FRUIT);
		mango = new Fruit(Constants.ID_FRUIT_MANGO, Constants.FRUIT_MANGO,
				(896 * Constants.FRUIT_DRINK_ML_100 / Constants.FRUIT_STRAWBERRY_GR),
				Constants.VALUE_INITIAL_STOCK_FRUIT);
		addMovement(strawberry, Constants.TYPE_MOVEMENT_INIT);
		addMovement(banana, Constants.TYPE_MOVEMENT_INIT);
		addMovement(mango, Constants.TYPE_MOVEMENT_INIT);
	}

	private static void option2(Integer numberDrink) {
		System.out.println("Thanks for choosing option " + numberDrink);
	}

	private static void saleDrink(Integer idFruit) {
		System.out.println("ID FRUIT" + idFruit);
		
//		System.out.println("Ingrese cantidad de bebidas:");
//		Scanner scannerDrink = new Scanner(System.in);
		
	}

	/**
	 * Report of movements
	 */
	private static void reportMovements() {
		System.out.println("Report of movements ");
		for (Inventory inventory : registerInventory) {
			System.out.println(inventory.toString());
		}
	}

	/**
	 * Register for movements
	 * 
	 * @param fruitAction
	 * @param movement
	 */
	private static void addMovement(Fruit fruitAction, String movement) {
		System.out.println("Thanks for choosing option 3");
		Inventory temp = logic.registerMovement(fruitAction, movement);
		registerInventory.add(temp);

		System.out.println(" Sixe: " + registerInventory.size());
	}

}
