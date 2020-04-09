package pe.lacafetalab.base.ddd.domain.types.implement;

import pe.lacafetalab.base.ddd.domain.types.TypeId;

public class TypeIdImp extends TypeId {
	public TypeIdImp(String id) {
		super(id);
	}

	public static TypeId empty() {
		return new TypeIdImp(null);
	}

	public static TypeId create(String id) {
		return new TypeIdImp(id);
	}
}
