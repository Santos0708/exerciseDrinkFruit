package ec.formos.test.bo;

import java.util.Date;

import ec.formos.test.entity.Ingredient;
import ec.formos.test.entity.Inventory;
import ec.formos.test.util.Constants;

/***
 * Class:
 * 
 * @author Santiago.Simbaña
 * @since
 *
 */

public class LogicalBusiness {

	public Inventory registerMovementInitial(Ingredient ingredient, String movement) {
		Inventory inventory = null;

		if (movement.equalsIgnoreCase(Constants.TYPE_MOVEMENT_INIT)) {
			inventory = new Inventory();
			inventory.setId(ingredient.getId());
			inventory.setIngredient(ingredient);
			inventory.setTransaction(movement);
			inventory.setStockFinal((double) ingredient.getStockInit());
			inventory.setStockInit((double) ingredient.getStockInit());
			inventory.setDateTran(new Date());
		}
		return inventory;
	}

}
