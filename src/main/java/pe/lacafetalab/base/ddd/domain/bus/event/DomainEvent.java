package pe.lacafetalab.base.ddd.domain.bus.event;

import pe.lacafetalab.base.ddd.domain.types.implement.TypeDateTimeImp;
import pe.lacafetalab.base.ddd.domain.types.implement.TypeUUIDImp;

import java.io.Serializable;
import java.util.HashMap;

public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = TypeUUIDImp.randon().value();
        this.occurredOn = TypeDateTimeImp.now().formatDateTime();
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.occurredOn = occurredOn;
    }

    protected DomainEvent() {
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    );

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }
}
