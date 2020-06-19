package pe.lacafetalab.base.ddd.domain.types;

import pe.lacafetalab.base.ddd.domain.code.SharedCode;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class TypeDate extends TypeBase<Date> {

    public TypeDate() {
        super();
    }

    public TypeDate(Date value) {
        super(value);
    }

    public TypeDate(Long value) {
        super(value != null ? new Date(value) : null);
    }


    public TypeDate(String value) {
        super(null);
        if (value == null) {
            return;
        }
        try {
            this.setValue(formatter().parse(value));
        } catch (ParseException e) {
            throw new BadRequestException(SharedCode.BAD_STRING_DATE_VALUE, this.invalidVoValue());
        }
    }

    protected String invalidVoValue() {
        return "El formato de fecha no es correcto";
    }

    protected void setNow() {
        this.setValue(new Date());
    }

    public String formatDate() {
        if (this.isNull()) {
            return "";
        }
        return formatter().format(this.value());
    }

    private SimpleDateFormat formatter() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZxxx");
    }


    @Override
    public String toString() {
        return this.formatDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeDate)) return false;
        TypeDate that = (TypeDate) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
