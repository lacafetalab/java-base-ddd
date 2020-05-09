package pe.lacafetalab.base.ddd.domain.types;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeInteger extends TypeBase<Integer> {

	public TypeInteger() {
		super();
	}

	public TypeInteger(Integer value) {
		super(value);
	}

	public TypeInteger(Integer value, boolean ifNullZero) {
		super(ifNullZero && value == null ? Integer.valueOf(0) : value);
	}

	public boolean isZero() {
		return value() != null && value() == 0;
	}

	public TypeInteger(String value, BadRequestException ex) {
		super(org.apache.commons.lang3.math.NumberUtils.isDigits(value)
				? org.apache.commons.lang3.math.NumberUtils.createInteger(value)
				: null);
	}

	public void verifyIsGreaterThanZero(BadRequestException ex) {
		if (value() == null || value() <= 0) {
			throw ex;
		}
	}

	public void verifyIsGreaterThanOrEqualToZero(BadRequestException ex) {
		if (value() == null || value() < 0) {
			throw ex;
		}
	}

	public void verifyIsGreaterThanOrEqual(int limit, BadRequestException ex) {
		if (value() == null || value() < limit) {
			throw ex;
		}
	}

	public void verifyIsGreaterThan(int limit, BadRequestException ex) {
		if (value() == null || value() <= limit) {
			throw ex;
		}
	}

	public void verifyIsMinorThanZero(BadRequestException ex) {
		if (value() == null || value() >= 0) {
			throw ex;
		}
	}

	public void verifyIsMinorThanOrEqualToZero(BadRequestException ex) {
		if (value() == null || value() > 0) {
			throw ex;
		}
	}

	public void verifyIsMinorThanOrEqual(int limit, BadRequestException ex) {
		if (value() == null || value() > limit) {
			throw ex;
		}
	}

	public void verifyIsMinorThan(int limit, BadRequestException ex) {
		if (value() == null || value() >= limit) {
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
