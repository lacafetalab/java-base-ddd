package pe.lacafetalab.base.ddd.domain.types;

import java.util.Optional;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeEnum<E extends Enum<E>> extends TypeBase<E> {

	public TypeEnum(E value) {
		super(value);
	}

	public TypeEnum(Class<E> clazz, String str, BadRequestException ex) {
		this(valueFrom(clazz, str).orElseThrow(() -> ex));
	}

	public final String name() {
		return value().name();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value() == null) ? 0 : value().hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeEnum other = (TypeEnum) obj;
		if (value() == null) {
			if (other.value() != null)
				return false;
		} else if (!value().equals(other.value()))
			return false;
		return true;
	}

	public static <E extends Enum<E>> Optional<E> valueFrom(Class<E> clazz, String str) {
		try {
			return Optional.of(Enum.valueOf(clazz, str));
		} catch (IllegalArgumentException | NullPointerException e) {
			return Optional.empty();
		}
	}

	public static <E extends Enum<E>> boolean isValid(Class<E> clazz, String str) {
		return valueFrom(clazz, str).isPresent();
	}

	@Override
	public final String toString() {
		return name();
	}
}