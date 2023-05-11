package ec.formos.test.entity;
/***
 * Class:
 * 
 * @author Santiago.Simbaña
 * @since
 *
 */

public class Ingredient {
	private Integer id;

	private String name;

	private Integer stockInit;

	private Integer stockCurrent;

	private String measure;

	public Ingredient() {
		super();
	}

	public Ingredient(Integer id, String name, Integer stockInit, Integer stockCurrent, String measure) {
		super();
		this.id = id;
		this.name = name;
		this.stockInit = stockInit;
		this.stockCurrent = stockCurrent;
		this.measure = measure;

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

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", stockInit=" + stockInit + ", stockCurrent=" + stockCurrent
				+ ", measure=" + measure + "]";
	}

}
