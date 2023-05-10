package ec.formos.test.entity;

import ec.formos.test.util.Constants;

public class Fruit {

	private Integer id;

	private String name;

	private Integer stockInit;

	private Integer stockCurrent;

	public Fruit() {
		super();
	}

	public Fruit(Integer id, String name, Integer stockInit, Integer stockCurrent) {
		super();
		this.id = id;
		this.name = name;
		this.stockInit = stockInit;
		this.stockCurrent = stockCurrent;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStockInit() {
		return stockInit;
	}

	public void setStockInit(Integer stockInit) {

		this.stockInit = stockInit; 
	}

	public Integer getStockCurrent() {
		return stockCurrent;
	}

	public void setStockCurrent(Integer stockCurrent) {
		this.stockCurrent = stockCurrent;
	}

}
