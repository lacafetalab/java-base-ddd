package pe.lacafetalab.base.ddd.domain.types

import pe.lacafetalab.base.ddd.domain.types.implement.TypeIntegerImp
import spock.lang.Specification

class TypeIntegerSpec extends Specification {
    void 'get value'() {
        expect:
            TypeIntegerImp.create(a).value() == b
        where:
            a    || b
            1    || 1
            0    || 0
            -1   || -1
            null || null
    }

    void 'get toString'() {
        expect:
            TypeIntegerImp.create(a).toString() == b
        where:
            a    || b
            1    || '1'
            0    || '0'
            -1   || '-1'
            null || ''
    }

    void 'is null'() {
        expect:
            TypeIntegerImp.create(a).isNull() == b
        where:
            a    || b
            1    || false
            0    || false
            -1   || false
            null || true
    }

    void 'hashCode integer'() {
        expect:
            TypeIntegerImp.create(a).hashCode() == b
        where:
            a    || b
            1    || 32
            0    || 31
            -1   || 30
            null || 31
    }

    void 'equals integer'() {
        expect:
            TypeIntegerImp.create(a).equals(b) == c
        where:
            a    | b                        || c
            1    | TypeIntegerImp.create(1) || true
            1    | 1                        || false
            1    | TypeIntegerImp.create(2) || false
            null | 5                        || false
            null | null                     || false
    }

    void 'equals especial integer'() {
        when:
            def type1 = TypeIntegerImp.create(1)
            def typeNull = TypeIntegerImp.create(null)
        then:
            type1.equals(type1)
            !typeNull.equals(type1)

    }
}
