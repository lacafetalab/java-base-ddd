package pe.lacafetalab.base.ddd.domain.code;

public enum SharedCode implements EnumCodeType {

	UNKNOWN_ERROR(1), TOKEN_EXPIRED(2), BAD_CREDENTIALS(3), BAD_ROLE_VALUE(4), UNEXPECTED_ROLE(5), BAD_ID_VALUE_NULL(6),

	BAD_NUM_ROUND_DECIMALS(7), BAD_UUID_VALUE(8);

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