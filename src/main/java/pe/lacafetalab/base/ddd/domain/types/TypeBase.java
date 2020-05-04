package pe.lacafetalab.base.ddd.domain.types;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeBase<T> {
	private T value;

	public TypeBase(T value) {
		this.value = value;
	}

	public T value() {
		return this.value;
	}

	public boolean isNull() {
		return this.value == null;
	}

	public void verifyIsNotNull(String name, int errorCode) {
		verifyIsNotNull(new BadRequestException(errorCode, String.format("The %s must not be null", name)));
	}

	public void verifyIsNotNull(BadRequestException ex) {
		if (value() == null) {
			throw ex;
		}
	}

	public void verifyIsNotEmpty(String name, int errorCode) {
		verifyIsNotEmpty(new BadRequestException(errorCode, String.format("The %s must not be null", name)));
	}

	public void verifyIsNotEmpty(BadRequestException ex) {
		if (StringUtils.isBlank(value().toString())) {
			throw ex;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeBase other = (TypeBase) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	abstract public String toString();
}
