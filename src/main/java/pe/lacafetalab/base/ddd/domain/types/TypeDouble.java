package pe.lacafetalab.base.ddd.domain.types;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.utils.NumberUtils;

public abstract class TypeDouble extends TypeBase<Double> {

	public TypeDouble(Double value) {
		super(value);
	}

	public TypeDouble(String value, BadRequestException ex) {
		super(org.apache.commons.lang3.math.NumberUtils.isCreatable(value)
				? org.apache.commons.lang3.math.NumberUtils.createDouble(value)
				: null);
	}

	public Double roundValue(int numDecimals) {
		return NumberUtils.round(value(), numDecimals);
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
		TypeDouble other = (TypeDouble) obj;
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
		return Double.toString(this.value());
	}

}
