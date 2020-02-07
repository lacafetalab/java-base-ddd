package pe.lacafetalab.base.ddd.domain.exception

import pe.lacafetalab.base.ddd.domain.code.SharedCode
import spock.lang.Specification

class AppExceptionSpec extends Specification {

    void 'get lanza el error generico'() {
        when:
            throw new AppException(400, SharedCode.create(1), "error A")
        then:
            thrown AppException
    }


    void 'get value'() {
        when:
            throw new AppException(a, SharedCode.create(b), c)
        then:
            def error = thrown(AppException)
            error.getStatusCode() == d
            error.getCode() == e
            error.getMessage() == f

        where:
            a   | b | c       || d    | e         | f
            400 | 5 | "texto" || 400 || 400000005 | "texto"
    }
}
