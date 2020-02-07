package pe.lacafetalab.base.ddd.domain.types

import pe.lacafetalab.base.ddd.domain.code.SharedCode
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException
import pe.lacafetalab.base.ddd.domain.types.implement.TypeUUIDImp
import spock.lang.Specification

class TypeUUIDSpec extends Specification {
    void 'get value'() {
        expect:
            TypeUUIDImp.create(a).value() == b
        where:
            a                                      || b
            '9eccbece-f4df-4565-83fa-8f118b29ec45' || '9eccbece-f4df-4565-83fa-8f118b29ec45'
            null                                   || null
    }

    void 'get toString'() {
        expect:
            TypeUUIDImp.create(a).toString() == b
        where:
            a                                      || b
            '9eccbece-f4df-4565-83fa-8f118b29ec45' || '9eccbece-f4df-4565-83fa-8f118b29ec45'
            null                                   || ''
    }

    void 'is null'() {
        expect:
            TypeUUIDImp.create(a).isNull() == b
        where:
            a                                      || b
            '9eccbece-f4df-4565-83fa-8f118b29ec45' || false
            null                                   || true
    }

    void 'len string'() {
        expect:
            TypeUUIDImp.create(a).length() == b
        where:
            a                                      || b
            '9eccbece-f4df-4565-83fa-8f118b29ec45' || 36
            null                                   || 0
    }

    void 'invalid uuid'() {

        when:
            TypeUUIDImp.create('invalid uuid')
        then:
            thrown BadRequestException
    }

    void 'generate uuid randon'() {

        when:
            def stringUuid = TypeUUIDImp.randon()
            def typeUUID = TypeUUIDImp.create(stringUuid.value())
        then:
            typeUUID.equals(stringUuid)
    }

    void 'generate uuid fromString'() {
        expect:
        TypeUUIDImp.fromString(a).value() == b
        where:
        a                                              || b
        'a'                                            || '4f3f2898-69e3-5a0d-820a-c4e87987dbce'
        'ab'                                           || '710a586f-e1aa-54ec-93a9-85a85aa0b725'
        'abc'                                          || '6cb8e707-0fc5-5f55-88d4-d4fed43e64a8'
        'A'                                            || '9759785f-95f6-554a-ba7a-c3e586ec5609'
        'AB'                                           || '5d4a3987-48c9-54a4-b128-2f98d6a6ad9b'
        'ABC'                                          || '023b07ac-415c-5b40-a2d6-304ba342be20'
        'ñ'                                            || 'b235281d-3cc2-597e-8560-0a232d4d3244'
        'áéíóú'                                        || '0add9a3b-3db2-5075-989b-d32941ce940d'
        'ÁÉÍÓÚ'                                        || '9130f319-8957-5689-95af-cfd855ae8301'
        '4f3f2898-69e3-5a0d-820a-c4e87987dbce'         || 'd1a39a7e-42da-5f2c-93b5-05dee61a921f'
        'recipe.service.shared.domain.code.SharedCode' || '60b376b5-4eef-53b2-b4a5-0f865f2999b9'
    }

    void 'generate uuid fromString class'() {
        expect:
        TypeUUIDImp.fromClass(a).value() == b
        where:
        a                || b
        SharedCode.class || '705a31ad-f7c6-5ae6-9104-46ebed4f8f27'

    }

}
