package pe.lacafetalab.base.ddd.domain.types

import pe.lacafetalab.base.ddd.domain.types.implement.TypeStringImp
import spock.lang.Specification

class TypeStringSpec  extends Specification{
    void 'get value'() {
        expect:
        TypeStringImp.create(a).value() == b
        where:
        a                 || b
        ''                || ''
        ' '               || ' '
        '_'               || '_'
        ' _'              || ' _'
        '"'               || '"'
        'abcdefghiABCDFG' || 'abcdefghiABCDFG'
        'aAáéíóúÁÉÍÓÚÑñ'  || 'aAáéíóúÁÉÍÓÚÑñ'
        null              || null
    }

    void 'get toString'() {
        expect:
        TypeStringImp.create(a).toString() == b
        where:
        a                 || b
        'abcdefghiABCDFG' || 'abcdefghiABCDFG'
        null              || ''
    }

    void 'is null'() {
        expect:
        TypeStringImp.create(a).isNull() == b
        where:
        a    || b
        ''   || false
        ""   || false
        'a'  || false
        ' '  || false
        null || true
    }

    void 'len string'() {
        expect:
        TypeStringImp.create(a).length() == b
        where:
        a              || b
        'a'            || 1
        'a-z'          || 3
        'ñÑ'           || 2
        'á'            || 1
        'áéíóúÁÉÍÓÚÑñ' || 12
        'á é'          || 3
        null           || 0
    }


    void 'hashCode string'() {
        expect:
        TypeStringImp.create(a).hashCode() == b
        where:
        a    || b
        'a'  || 128
        'b'  || 129
        'ab' || 3136
        null || 31
    }

    void 'equals string'() {
        expect:
        TypeStringImp.create(a).equals(b) == c
        where:
        a    | b                          || c
        'b'  | TypeStringImp.create('b')  || true
        'b'  | 'b'                        || false
        'a'  | TypeStringImp.create('aa') || false
        null | 5                          || false
        null | null                       || false
    }

    void 'equals especial string'() {
        when:
        def typea = TypeStringImp.create('a')
        def typeNull = TypeStringImp.create(null)
        then:
        typea.equals(typea)
        !typeNull.equals(typea)

    }

}
