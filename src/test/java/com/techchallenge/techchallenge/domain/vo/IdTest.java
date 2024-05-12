package com.techchallenge.techchallenge.domain.vo;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdTest {

    @Test
    public void testWithId() {
        String idString = "123e4567-e89b-12d3-a456-426614174000";
        Id id = Id.withId(idString);
        Assertions.assertEquals(UUID.fromString(idString), id.getValue());
    }

    @Test
    public void testWithoutId() {
        Id id = Id.withoutId();
        Assertions.assertNotNull(id.getValue());
    }
}