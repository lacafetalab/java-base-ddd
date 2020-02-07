package pe.lacafetalab.base.ddd.domain.types

import pe.lacafetalab.base.ddd.domain.types.implement.TypeDoubleImp
import spock.lang.Specification

class TypeDoubleSpec extends Specification {
    void 'get value'() {
        expect:
            TypeDoubleImp.create(a).value() == b
        where:
            a    || b
            1.0  || 1.0
            1    || 1.0
            0.0  || 0.0
            -1.0 || -1.0
            null || null
    }

    void 'get toString'() {
        expect:
            TypeDoubleImp.create(a).toString() == b
        where:
            a    || b
            1.0  || '1.0'
            1    || '1.0'
            0.0  || '0.0'
            -1.0 || '-1.0'
            null || ''
    }

    void 'is null'() {
        expect:
            TypeDoubleImp.create(a).isNull() == b
        where:
            a    || b
            1.0  || false
            1    || false
            0.0  || false
            -1.0 || false
            null || true
    }


    void 'hashCode Double'() {
        expect:
            TypeDoubleImp.create(a).hashCode() == b
        where:
            a    || b
            1.0  || 1072693279
            0.0  || 31
            -1.0 || -1074790369
            null || 31
    }

    void 'equals Double'() {
        expect:
            TypeDoubleImp.create(a).equals(b) == c
        where:
            a    | b                         || c
            1.0  | TypeDoubleImp.create(1.0) || true
            2.0  | 2.0                       || false
            3.0  | TypeDoubleImp.create(3)   || true
            3.0  | TypeDoubleImp.create(4.0) || false
            null | 5                         || false
            null | null                      || false
    }

    void 'equals especial Double'() {
        when:
            def type1 = TypeDoubleImp.create(1.0)
            def typeNull = TypeDoubleImp.create(null)
        then:
            type1.equals(type1)
            !typeNull.equals(type1)

    }
}
