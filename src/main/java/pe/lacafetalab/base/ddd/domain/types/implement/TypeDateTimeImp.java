package pe.lacafetalab.base.ddd.domain.types.implement;

import java.time.LocalDateTime;

import pe.lacafetalab.base.ddd.domain.types.TypeDateTime;

public class TypeDateTimeImp extends TypeDateTime {
	public TypeDateTimeImp(LocalDateTime value) {
		super(value);
	}

	public static TypeDateTime create(int year, int month, int day) {
		LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
		return new TypeDateTimeImp(dateTime);
	}

	public static TypeDateTime create(int year, int month, int day, int hour, int minute, int second) {
		LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
		return new TypeDateTimeImp(dateTime);
	}

	public static TypeDateTime now() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dateTime = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(),
				now.getMinute(), now.getSecond());
		return new TypeDateTimeImp(dateTime);
	}
}
