package pe.lacafetalab.base.ddd.domain.types.implement;

import pe.lacafetalab.base.ddd.domain.types.TypeDouble;

final public class TypeDoubleImp extends TypeDouble {
    public TypeDoubleImp(Double value) {
        super(value);
    }

    public static TypeDoubleImp create(Double value) {
        return new TypeDoubleImp(value);
    }
}
