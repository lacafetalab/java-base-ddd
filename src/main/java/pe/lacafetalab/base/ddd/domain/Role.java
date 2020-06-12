package pe.lacafetalab.base.ddd.domain;

import pe.lacafetalab.base.ddd.domain.code.SharedCode;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.base.ddd.domain.types.TypeString;

public class Role extends TypeString {

	public Role(String value) {
		super(value);
		verifyIsNotBlank(new BadRequestException(SharedCode.BAD_ROLE_VALUE, "The role must not be empty"));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			throw new BadRequestException(SharedCode.BAD_ROLE_VALUE,
					"obj wih one you want to compare must be not null");
		}
		Role objRole = (Role) obj;
		return value().equals(objRole.value());
	}

	@Override
	public String toString() {
		return "Role [value()=" + value() + "]";
	}
}