package pe.lacafetalab.base.ddd.domain.utils;

import pe.lacafetalab.base.ddd.domain.code.SharedCode;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

public class NumberUtils {

	public static int getFirstDigit(int number) {
		return Integer.valueOf(String.valueOf(String.valueOf(number).charAt(0)));
	}

	public static Double round(Double value, int numDecimals) {
		if (value == null) {
			return null;
		}
		if (numDecimals < 1) {
			throw new BadRequestException(SharedCode.BAD_NUM_ROUND_DECIMALS,
					String.format("Value for numDecimals[%d] not valid", numDecimals));
		}
		double exp = Math.pow(10.0, numDecimals);
		return Math.round(value.doubleValue() * exp) / exp;
	}
}