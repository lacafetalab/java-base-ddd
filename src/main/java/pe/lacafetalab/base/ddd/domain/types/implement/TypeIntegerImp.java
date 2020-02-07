package pe.lacafetalab.base.ddd.domain.types.implement;

import pe.lacafetalab.base.ddd.domain.types.TypeInteger;

final public class TypeIntegerImp extends TypeInteger {
    TypeIntegerImp(Integer value) {
        super(value);
    }

    public static TypeIntegerImp create(Integer value) {
        return new TypeIntegerImp(value);
    }
}