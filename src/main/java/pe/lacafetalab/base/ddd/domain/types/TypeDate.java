package pe.lacafetalab.base.ddd.domain.types;

import java.util.Date;

public abstract class TypeDate extends TypeBase<Date> {

	public TypeDate() {
		super();
	}

	public TypeDate(Date value) {
		super(value);
	}

	public TypeDate(Long value) {
		super(value != null ? new Date(value) : null);
	}

	@Override
	public String toString() {
		return value().toString();
	}
}
