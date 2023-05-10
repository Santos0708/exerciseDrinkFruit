package ec.formos.test.entity;

import java.util.Date;

public class Inventory {

	private Integer id;

	private Fruit fruit;

	private Double stockInit;

	private String transaction;

	private Double valueSale;

	private Double stockFinal;

	private Date dateTran;

	public Inventory() {
		super();
	}

	public Inventory(Integer id, Fruit fruit, Double stockInit, String transaction, Double valueSale, Double stockFinal,
			Date dateTran) {
		super();
		this.id = id;
		this.fruit = fruit;
		this.stockInit = stockInit;
		this.transaction = transaction;
		this.valueSale = valueSale;
		this.stockFinal = stockFinal;
		this.dateTran = dateTran;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public Double getStockInit() {
		return stockInit;
	}

	public void setStockInit(Double stockInit) {
		this.stockInit = stockInit;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public Double getValueSale() {
		return valueSale;
	}

	public void setValueSale(Double valueSale) {
		this.valueSale = valueSale;
	}

	public Double getStockFinal() {
		return stockFinal;
	}

	public void setStockFinal(Double stockFinal) {
		this.stockFinal = stockFinal;
	}

	public Date getDateTran() {
		return dateTran;
	}

	public void setDateTran(Date dateTran) {
		this.dateTran = dateTran;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", fruit=" + fruit.getName() + ", stockInit=" + stockInit + ", transaction=" + transaction
				+ ", valueSale=" + valueSale + ", stockFinal=" + stockFinal + ", dateTran=" + dateTran + "]";
	}

}
