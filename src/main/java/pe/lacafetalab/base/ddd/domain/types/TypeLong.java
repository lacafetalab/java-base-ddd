package pe.lacafetalab.base.ddd.domain.types;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeLong extends TypeBase<Long> {

	public TypeLong() {
		super();
	}

	public TypeLong(Long value) {
		super(value);
	}

	public TypeLong(Long value, boolean ifNullZero) {
		super(ifNullZero && value == null ? Long.valueOf(0) : value);
	}

	public boolean isZero() {
		return value() != null && value() == 0;
	}

	public TypeLong(String value, BadRequestException ex) {
		super(org.apache.commons.lang3.math.NumberUtils.isDigits(value)
				? org.apache.commons.lang3.math.NumberUtils.createLong(value)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value() == null) ? 0 : value().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeLong other = (TypeLong) obj;
		if (value() == null) {
			if (other.value() != null)
				return false;
		} else if (!value().equals(other.value()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (this.isNull()) {
			return "";
		}
		return Long.toString(this.value());
	}
}
