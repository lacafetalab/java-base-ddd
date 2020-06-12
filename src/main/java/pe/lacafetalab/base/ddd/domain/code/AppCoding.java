package pe.lacafetalab.base.ddd.domain.code;

public class AppCoding {

	public static <C extends Enum<C> & EnumCodeType> Integer value(Integer statusCode, C code) {
		String concatcode = statusCode.toString().concat(value(code));
		return Integer.parseInt(concatcode);
	}

	public static <C extends Enum<C> & EnumCodeType> String value(C code) {
		return code.getModuleCode().concat(formatCode(code));
	}

	private static <C extends Enum<C> & EnumCodeType> String formatCode(C code) {
		return String.format("%04d", code.value());
	}

}
