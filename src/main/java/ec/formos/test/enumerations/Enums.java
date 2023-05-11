package ec.formos.test.enumerations;

/***
 * Class:
 * 
 * @author Santiago.Simbaña
 * @since
 *
 */
public enum Enums {
	SALE("SL", "Sales"), INITT("IT", "Init"), MILLILITER("ML", "MILLILITER"), GRAMS("GR", "GRAMS");

	private String code;
	private String name;

	private Enums(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
