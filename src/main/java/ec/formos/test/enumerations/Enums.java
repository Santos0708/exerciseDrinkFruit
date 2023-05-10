package ec.formos.test.enumerations;

public enum Enums {
	SALE("SL", "Sales"), ACTIVO("IT", "Init");

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
