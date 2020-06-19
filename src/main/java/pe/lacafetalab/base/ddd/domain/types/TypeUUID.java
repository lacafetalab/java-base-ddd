package pe.lacafetalab.base.ddd.domain.types;

import java.util.UUID;

import pe.lacafetalab.base.ddd.domain.code.SharedCode;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public abstract class TypeUUID extends TypeString {

    public TypeUUID(String uuid) {
        super(uuid);
        isValidate();
    }

    private void isValidate() {
        if (isNull()) {
            return;
        }
        try {
            UUID.fromString(value());
        } catch (IllegalArgumentException exception) {
            throw new BadRequestException(SharedCode.BAD_UUID_VALUE, errorUuidValueNotValid());
        }
    }

    protected String errorUuidValueNotValid() {
        return "Uuid value no valid";
    }
}