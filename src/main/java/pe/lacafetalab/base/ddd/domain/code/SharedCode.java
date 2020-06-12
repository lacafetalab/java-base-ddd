package pe.lacafetalab.base.ddd.domain.code;

public enum SharedCode implements EnumCodeType {

	BAD_ID_VALUE_NULL(1), BAD_NUM_ROUND_DECIMALS(2), BAD_UUID_VALUE(3),

	TOKEN_EXPIRED(4), BAD_CREDENTIALS(5), BAD_ROLE_VALUE(6), UNEXPECTED_ROLE(7);

	static String MODULE_CLASS = "00";

	private int value;

	SharedCode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	public String getModuleCode() {
		return MODULE_CLASS;
	}
}