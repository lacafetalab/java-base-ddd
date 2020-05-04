package pe.lacafetalab.base.ddd.domain.types;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeString extends TypeBase<String> {

	public TypeString(String value) {
		super(value);
	}

	public int length() {
		if (this.isNull()) {
			return 0;
		}
		return this.value().length();
	}

	public void verifyNotBlank(BadRequestException ex) {
		if (StringUtils.isBlank(value())) {
			throw ex;
		}
	}

	public void verifyMaxLength(int maxLength, BadRequestException ex) {
		if (value().length() > maxLength) {
			throw ex;
		}
	}

	public void verifyMinLength(int minLength, BadRequestException ex) {
		if (value().length() < minLength) {
			throw ex;
		}
	}

	@Override
	public String toString() {
		if (this.isNull()) {
			return "";
		}
		return this.value();
	}
}
