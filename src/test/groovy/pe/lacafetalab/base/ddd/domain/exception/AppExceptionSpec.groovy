package pe.lacafetalab.base.ddd.domain.exception

import pe.lacafetalab.base.ddd.domain.code.SharedCode
import pe.lacafetalab.base.ddd.domain.ErrorCode
import spock.lang.Specification

class AppExceptionSpec extends Specification {

    void 'get lanza el error generico'() {
        when:
            throw new AppException(400, SharedCode.create(ErrorCode.BAD_ID_VALUE_NULL), "error A")
        then:
            thrown AppException
    }


    void 'get value'() {
        when:
            throw new AppException(a, SharedCode.create(ErrorCode.BAD_ID_VALUE_NULL), c)
        then:
            def error = thrown(AppException)
            error.getStatusCode() == d
            error.getCode() == e
            error.getMessage() == f

        where:
            a   | b | c       || d    | e         | f
            400 | 1 | "texto" || 400 || 400000001 | "texto"
    }
}
