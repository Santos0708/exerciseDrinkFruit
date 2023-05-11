package ec.formos.test.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ec.formos.test.bo.LogicalBusiness;
import ec.formos.test.entity.Formula;
import ec.formos.test.entity.Ingredient;
import ec.formos.test.entity.Inventory;
import ec.formos.test.enumerations.Enums;
import ec.formos.test.util.Constants;

public class DrinkFruit {

	/**
	 * Initialize fruit
	 */
	static List<Inventory> registerInventory = new ArrayList<Inventory>();
	static List<Ingredient> listIngredients = new ArrayList<Ingredient>();

	static Formula formulaGeneral = new Formula();
	static Inventory inventory = new Inventory();
	static LogicalBusiness logicBusiness = new LogicalBusiness();

	/***
	 * Main execution method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		initIngredients();

		System.out.println("***********************************************");
		System.out.println("*******  Blended Fruit Drink ******************");
		System.out.println("***********************************************");
		System.out.println("*******  Autor: Santiago Simbaña **************");
		System.out.println("*******  Date: 12/05/2023    ******************");
		System.out.println("***********************************************");

		String[] options = { "1- Inventory Reports ", "2- Sales ", "3- Other ", "4- Exit", };
		String[] flavorOptions = { "		[1]. Strawberry", "		[2]. banana", "		[3]. mango", "    [4] Return" };

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
					System.out.println("=============>  SALES <=============");
					Scanner scannerFlavor = new Scanner(System.in);
					System.out.println("=============> Enter number of drinks:");
					int cantidad = scannerFlavor.nextInt();
					int optionDrink = 1;
					while (optionDrink != flavorOptions.length) {
						printMenu(flavorOptions);
						try {
							optionDrink = scannerFlavor.nextInt();
							switch (optionDrink) {
							case 1:
								saleDrink(Constants.ID_FRUIT_STRAWBERRY, cantidad);
								break;
							case 2:

								saleDrink(Constants.ID_FRUIT_BANANA, cantidad);
								break;
							case 3:
								saleDrink(Constants.ID_FRUIT_MANGO, cantidad);
								break;
							}

						} catch (Exception ex) {
							System.err.println(ex.getCause());
							System.out.println(Constants.MSG_OPTION_INVALID + flavorOptions.length);
							scannerFlavor.next();
						}
					}

					break;
				case 3:

					break;
				case 4:
					System.out.println("Thanks for use ");
					System.gc();
					System.exit(0);

				}
			} catch (Exception ex) {
				System.out.println(Constants.MSG_OPTION_INVALID + options.length);
				scanner.next();
			}
		}

	}

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

	/***
	 * initializes the ingredient objects
	 */
	private static void initIngredients() {
		System.out.println("Objects Init");

		listIngredients.add(new Ingredient(Constants.ID_FRUIT_STRAWBERRY, Constants.FRUIT_STRAWBERRY,
				(250 * Constants.MEASURE_MIX_ML / Constants.FRUIT_STRAWBERRY_GR), Constants.VALUE_INITIAL_STOCK_FRUIT,
				Enums.MILLILITER.getCode()));

		listIngredients.add(new Ingredient(Constants.ID_FRUIT_BANANA, Constants.FRUIT_BANANA,
				(460 * Constants.MEASURE_MIX_ML / Constants.FRUIT_BANANA_GR), Constants.VALUE_INITIAL_STOCK_FRUIT,
				Enums.MILLILITER.getCode()));

		listIngredients.add(new Ingredient(Constants.ID_FRUIT_MANGO, Constants.FRUIT_MANGO,
				(896 * Constants.MEASURE_MIX_ML / Constants.FRUIT_MANGO_GR), Constants.VALUE_INITIAL_STOCK_FRUIT,
				Enums.MILLILITER.getCode()));

		listIngredients.add(new Ingredient(Constants.ID_ICE, Constants.ICE, (4500), Constants.VALUE_INITIAL_STOCK_FRUIT,
				Enums.MILLILITER.getCode()));

		listIngredients.add(new Ingredient(Constants.ID_MILK, Constants.MILK, (8600),
				Constants.VALUE_INITIAL_STOCK_FRUIT, Enums.MILLILITER.getCode()));

		listIngredients.add(new Ingredient(Constants.ID_SUGAR, Constants.SUGAR, 2000,
				Constants.VALUE_INITIAL_STOCK_FRUIT, Enums.GRAMS.getCode()));

		formulaGeneral.setListIngredients(new ArrayList<>());

		for (Ingredient ingredient : listIngredients) {
			addMovement(ingredient, Constants.TYPE_MOVEMENT_INIT);

			if (ingredient.getId() != Constants.ID_FRUIT_STRAWBERRY && ingredient.getId() != Constants.ID_FRUIT_BANANA
					&& ingredient.getId() != Constants.ID_FRUIT_MANGO) {
				formulaGeneral.getListIngredients().add(ingredient);
			}

		}
	}

	/***
	 * Consult the historical inventory of the ingredient
	 * 
	 * @return
	 */
	private static Inventory searchInventoryHist(Integer idIngredients) {
		return registerInventory.stream().filter((ing) -> ing.getIngredient().getId() == idIngredients)
				.max(Comparator.comparing(Inventory::getId)).orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Processes the sale of a drink
	 * 
	 * @param idFruit
	 * @param quantity
	 */
	private static void saleDrink(Integer idFruit, int quantity) {

		System.out.println("		************PROCCESS ORDER *************");
		// Get max identifier
		Integer maxInventoryId = registerInventory.stream().max(Comparator.comparing(Inventory::getId))
				.orElseThrow(NoSuchElementException::new).getId();

		Inventory inventoryHist = searchInventoryHist(idFruit);
		Formula formulaAux = new Formula();
		formulaAux.setListIngredients(new ArrayList<>());
		formulaAux.getListIngredients().addAll(formulaGeneral.getListIngredients());
		formulaAux.getListIngredients().add(inventoryHist.getIngredient());

		StringBuilder msg = new StringBuilder();
		Boolean hasError = false;

		List<Inventory> inventoryTemporal = new ArrayList<>();
		for (Ingredient ingredient : formulaAux.getListIngredients()) {
			maxInventoryId = maxInventoryId + 1;
			Integer quantityRequired = 0;
			if (ingredient.getId().equals(Constants.ID_FRUIT_STRAWBERRY)
					|| ingredient.getId().equals(Constants.ID_FRUIT_BANANA)
					|| ingredient.getId().equals(Constants.ID_FRUIT_MANGO)) {
				quantityRequired = (Constants.FORMULA_FRUIT_ML * (Constants.MEASURE_DRINK_ML / Constants.MEASURE_MIX_ML)
						* quantity);

			} else if (ingredient.getId().equals(Constants.ID_ICE)) {
				quantityRequired = (Constants.FORMULA_ICE_ML * (Constants.MEASURE_DRINK_ML / Constants.MEASURE_MIX_ML)
						* quantity);

			} else if (ingredient.getId().equals(Constants.ID_MILK)) {
				quantityRequired = (Constants.FORMULA_MILK_ML * (Constants.MEASURE_DRINK_ML / Constants.MEASURE_MIX_ML)
						* quantity);

			} else if (ingredient.getId().equals(Constants.ID_SUGAR)) {
				quantityRequired = (Constants.FORMULA_SUGAR_GR * (Constants.MEASURE_DRINK_ML / Constants.MEASURE_MIX_ML)
						* quantity);

			}

			Inventory inventoryAux = searchInventoryHist(ingredient.getId());
			if (inventoryAux.getStockFinal() < quantityRequired) {
				msg.append(Constants.MSG_AMOUNT_INVALID + " FOR INGREDIENT : " + inventoryAux.getIngredient().getName()
						+ " ** \r\n" + "REQUIRED QUANTITY " + quantityRequired + " ** \r\n" + "CURRENT QUANTITY "
						+ inventoryAux.getStockFinal());

				hasError = true;
			} else {
				Inventory newInventory = new Inventory();
				newInventory.setDateTran(new Date());
				newInventory.setId(maxInventoryId);
				newInventory.setTransaction(Constants.TYPE_MOVEMENT_SALE);
				newInventory.setValueSale((double) quantity);
				newInventory.setStockInit(inventoryAux.getStockFinal());
				newInventory.setIngredient(inventoryAux.getIngredient());
				newInventory.setStockFinal(inventoryAux.getStockFinal() - quantityRequired);
				inventoryTemporal.add(newInventory);
			}

		}
		if (!hasError) {
			System.out.println("regista la venta deinventaiors con la venta");
			registerInventory.addAll(inventoryTemporal);
		} else
			System.err.println(" ####################   ALERTS: ######  \n\n\n\n" + msg.toString());

		System.out.println("		************ END PROCCESS ORDER *************");

	}

	/**
	 * Inventory movement report
	 */
	private static void reportMovements() {
		System.out.println(" ============> Inventory Report <========================");
		for (Inventory inventory : registerInventory) {
			System.out.println(inventory.toString());
		}
		System.out.println(" ============> End Inventory Report <========================");
	}

	/**
	 * Register for movements
	 * 
	 * 
	 * @param fruitAction
	 * @param movement
	 */
	private static void addMovement(Ingredient ingredientAction, String movement) {
		registerInventory.add(logicBusiness.registerMovementInitial(ingredientAction, movement));
	}

}
