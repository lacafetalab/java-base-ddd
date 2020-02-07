package pe.lacafetalab.base.ddd.domain.exception

import pe.lacafetalab.base.ddd.domain.code.SharedCode
import spock.lang.Specification

class NotFoundRequestExceptionSpec extends Specification {
    void 'lanza el error generico con texto'() {
        when:
            throw new NotFoundException(SharedCode.create(1), "error A")
        then:
            thrown NotFoundException
    }

    void 'lanza el error generico sin texto'() {
        when:
            throw new NotFoundException(SharedCode.create(1))
        then:
            thrown NotFoundException
    }
}
