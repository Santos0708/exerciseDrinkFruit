package ec.formos.test.entity;

import java.util.List;

/***
 * Class:
 * 
 * @author Santiago.Simbaña
 * @since
 *
 */
public class Formula {

	private List<Ingredient> listIngredients;
	private Integer measure;
	private Integer quantitySale;

	
	
	public Formula() {
		super();
	}

	public Formula(List<Ingredient> listIngredients, Integer quantitySale, Integer measure) {
		super();
		this.listIngredients = listIngredients;
		this.quantitySale = quantitySale;
		this.measure = measure;
	}

	public List<Ingredient> getListIngredients() {
		return listIngredients;
	}

	public void setListIngredients(List<Ingredient> listIngredients) {
		this.listIngredients = listIngredients;
	}

	public Integer getQuantitySale() {
		return quantitySale;
	}

	public void setQuantitySale(Integer quantitySale) {
		this.quantitySale = quantitySale;
	}

	public Integer getMeasure() {
		return measure;
	}

	public void setMeasure(Integer measure) {
		this.measure = measure;
	}
	
	
	
}
