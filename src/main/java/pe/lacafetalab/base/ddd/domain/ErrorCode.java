package pe.lacafetalab.base.ddd.domain;

public enum ErrorCode {

	BAD_ID_VALUE_NULL(1), BAD_NUM_ROUND_DECIMALS(2), BAD_UUID_VALUE(3);

	private int value;

	ErrorCode(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

}
