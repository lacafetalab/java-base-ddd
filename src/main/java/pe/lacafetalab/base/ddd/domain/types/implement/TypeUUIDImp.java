package pe.lacafetalab.base.ddd.domain.types.implement;

import java.util.UUID;

import pe.lacafetalab.base.ddd.domain.libraries.UUID5;
import pe.lacafetalab.base.ddd.domain.types.TypeUUID;

public class TypeUUIDImp extends TypeUUID {
	public TypeUUIDImp(String uuid) {
		super(uuid);
	}

	public static TypeUUIDImp create(String value) {
		return new TypeUUIDImp(value);
	}

	public static TypeUUIDImp randon() {
		return new TypeUUIDImp(UUID.randomUUID().toString());
	}

	public static TypeUUID fromString(String value) {
		return new TypeUUIDImp(UUID5.fromUTF8(UUID5.POLYGENEA_NAMESPACE, value).toString());
	}

	public static TypeUUID fromClass(Class<?> clazz) {
		return new TypeUUIDImp(UUID5.fromUTF8(UUID5.POLYGENEA_NAMESPACE, clazz.getName()).toString());
	}
}