package pe.lacafetalab.base.ddd.domain.exception

import pe.lacafetalab.base.ddd.domain.code.SharedCode
import spock.lang.Specification

class BadRequestExceptionSpec extends Specification {
    void 'lanza el error generico con texto'() {
        when:
            throw new BadRequestException(SharedCode.BAD_ID_VALUE_NULL, "error A")
        then:
            thrown BadRequestException
    }

    void 'lanza el error generico sin texto'() {
        when:
            throw new BadRequestException(SharedCode.BAD_ID_VALUE_NULL)
        then:
            thrown BadRequestException
    }
}
