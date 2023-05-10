package ec.formos.test.bo;

import java.util.Date;
import java.util.Random;

import ec.formos.test.entity.Fruit;
import ec.formos.test.entity.Inventory;
import ec.formos.test.util.Constants;

public class LogicalSales {

	public void Sales() {
		System.out.println("ventas");
	}

	public Inventory registerMovement(Fruit fruit, String movement) {
		Inventory inventory = null;

		if (movement.equalsIgnoreCase(Constants.TYPE_MOVEMENT_INIT)) {
			inventory = new Inventory();
			inventory.setId(Math.abs(new Random().nextInt()));
			inventory.setFruit(fruit);
			inventory.setTransaction(movement);
			inventory.setStockFinal((double) fruit.getStockInit());
			inventory.setStockInit((double) fruit.getStockInit());
			inventory.setDateTran(new Date());

		} else if (movement.equalsIgnoreCase(Constants.TYPE_MOVEMENT_SALE)) {

		}

		return inventory;
	}

}
