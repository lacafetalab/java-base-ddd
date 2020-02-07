package pe.lacafetalab.base.ddd.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class BadRequestException extends AppException {

    private static final Logger LOG = LoggerFactory.getLogger(BadRequestException.class.getName());


    private static final int STATUS_CODE = 400;

    /**
     * recomendaciones para el code
     * se antepone el status code
     * para el modulo shared poner 00, es muy improbable que tengas mas de 99  agregates
     * y luego poner un codigo para describir el error
     * ejemplo : 400 00 xxx
     *
     * @param code
     */
    public BadRequestException(AppCode code) {
        super(STATUS_CODE, code, "");
        LOG.error(this.getCode().toString());
    }

    public BadRequestException(AppCode code, String message) {
        super(STATUS_CODE, code, message);
        LOG.error(this.getCode().toString() + " - " + this.getMessage());
    }

}