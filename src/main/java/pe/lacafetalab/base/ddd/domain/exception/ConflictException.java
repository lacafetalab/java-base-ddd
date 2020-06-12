package pe.lacafetalab.base.ddd.domain.exception;

import pe.lacafetalab.base.ddd.domain.code.EnumCodeType;

public class ConflictException extends AppException {
	private static final long serialVersionUID = 1L;
	private static final int STATUS_CODE = 409;

	public <C extends Enum<C> & EnumCodeType> ConflictException(C code) {
		this(code, "");
	}

	/**
	 * Instanstiate a ConflictException object.
	 *
	 * @deprecated Try to use the one with code EnumCodeType enum object parameter.
	 * 
	 */
	@Deprecated
	public ConflictException(Integer code) {
		this(code, "");
	}

	public <C extends Enum<C> & EnumCodeType> ConflictException(C code, String message) {
		this(code, message, null);
	}

	/**
	 * Instanstiate a ConflictException object.
	 *
	 * @deprecated Try to use the one with code EnumCodeType enum object parameter.
	 * 
	 */
	@Deprecated
	public ConflictException(Integer code, String message) {
		this(code, message, null);
	}

	public <C extends Enum<C> & EnumCodeType> ConflictException(C code, String message, Object data) {
		super(STATUS_CODE, code, message, data, null);
	}

	/**
	 * Instanstiate a ConflictException object.
	 *
	 * @deprecated Try to use the one with code EnumCodeType enum object parameter.
	 * 
	 */
	@Deprecated
	public ConflictException(Integer code, String message, Object data) {
		super(STATUS_CODE, code, message, data, null);
	}
}