package pe.lacafetalab.base.ddd.domain.types;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeInteger extends TypeBase<Integer> {

	public TypeInteger(Integer value) {
		super(value);
	}

	public TypeInteger(String value, BadRequestException ex) {
		super(org.apache.commons.lang3.math.NumberUtils.isDigits(value)
				? org.apache.commons.lang3.math.NumberUtils.createInteger(value)
				: null);
	}

	public void verifyGreaterThanZero(BadRequestException ex) {
		if (value() == null || value() <= 0) {
			throw ex;
		}
	}

	public void verifyMinorThanZero(BadRequestException ex) {
		if (value() == null || value() >= 0) {
			throw ex;
		}
	}

	@Override
	public String toString() {
		if (this.isNull()) {
			return "";
		}
		return Integer.toString(this.value());
	}
}
