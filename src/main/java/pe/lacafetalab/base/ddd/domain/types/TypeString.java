package pe.lacafetalab.base.ddd.domain.types;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeString extends TypeBase<String> {

	public TypeString() {
		super();
	}

	public TypeString(String value) {
		super(value);
	}

	public boolean isEmpty() {
		return StringUtils.isBlank(value());
	}

	public int length() {
		if (this.isNull()) {
			return 0;
		}
		return this.value().length();
	}

	public void verifyIsNotBlank(String name, int errorCode) {
		verifyIsNotBlank(new BadRequestException(errorCode, String.format("The %s must not be blank", name)));
	}

	public void verifyIsNotBlank(BadRequestException ex) {
		if (StringUtils.isBlank(value())) {
			throw ex;
		}
	}

	public void verifyIsNotEmpty(String name, int errorCode) {
		verifyIsNotEmpty(new BadRequestException(errorCode, String.format("The %s must not be empty", name)));
	}

	public void verifyIsNotEmpty(BadRequestException ex) {
		if (StringUtils.isEmpty(value())) {
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

	public void verifyIsAlphaNumeric(BadRequestException ex) {
		if (!StringUtils.isAlphanumeric(value())) {
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
