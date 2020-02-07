package pe.lacafetalab.base.ddd.domain.types;


import pe.lacafetalab.base.ddd.domain.code.SharedCode;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeId extends TypeUUID {

    public TypeId(String id) {
        super(id);
        if (isNull()) {
            throw new BadRequestException(SharedCode.create(2), "El id no puede ser nulo");
        }
    }
}
