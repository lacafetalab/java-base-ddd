package pe.lacafetalab.base.ddd.domain.types;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeBoolean extends TypeBase<Boolean> {

	public TypeBoolean(Boolean value) {
		super(value);
	}

	public TypeBoolean(String value) {
		super(BooleanUtils.toBooleanObject(value));
	}

	public void verifyIsValid(String value, BadRequestException ex, boolean allowNull) {
		if (StringUtils.isNotBlank(value) && !value.toLowerCase().equals("true")
				&& !value.toLowerCase().equals("false")) {
			throw ex;
		} else if (!allowNull && StringUtils.isBlank(value)) {
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
		TypeBoolean other = (TypeBoolean) obj;
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
		return Boolean.toString(this.value());
	}
}
