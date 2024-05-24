package com.techchallenge.techchallenge.core.domain.vo;

import java.util.UUID;

/**
 * Represents an identifier for a domain object.
 */
public class Id {

    private final UUID uuid;

    public Id(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Creates a new Id instance with the specified UUID value.
     *
     * @param id the UUID value for the Id
     * @return a new Id instance
     */
    public static Id withId(String id) {
        return new Id(UUID.fromString(id));
    }

    /**
     * Represents an identifier for a domain object.
     */
    public static Id withoutId() {
        return new Id(UUID.randomUUID());
    }

    public UUID getValue() {
        return uuid;
    }

    public String toString() {
        return uuid.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Id id = (Id) o;
        return uuid.equals(id.uuid);
    }

    public int hashCode() {
        return uuid.hashCode();
    }
}