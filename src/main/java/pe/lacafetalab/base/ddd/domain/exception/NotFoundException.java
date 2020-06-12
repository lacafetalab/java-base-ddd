package pe.lacafetalab.base.ddd.domain.exception;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.code.EnumCodeType;

public class NotFoundException extends AppException {
	private static final long serialVersionUID = 1L;

	private static final int STATUS_CODE = 404;

	public <C extends Enum<C> & EnumCodeType> NotFoundException(C code) {
		super(STATUS_CODE, code, StringUtils.EMPTY, null, null);
	}

	/**
	 * Instanstiate a NotFoundException object.
	 *
	 * @deprecated Try to use the one with code EnumCodeType enum object parameter.
	 * 
	 */
	@Deprecated
	public NotFoundException(Integer code) {
		super(STATUS_CODE, code, StringUtils.EMPTY, null, null);
	}

	public <C extends Enum<C> & EnumCodeType> NotFoundException(C code, String message) {
		super(STATUS_CODE, code, message, null, null);
	}

	/**
	 * Instanstiate a NotFoundException object.
	 *
	 * @deprecated Try to use the one with code EnumCodeType enum object parameter.
	 * 
	 */
	@Deprecated
	public NotFoundException(Integer code, String message) {
		super(STATUS_CODE, code, message, null, null);
	}
}