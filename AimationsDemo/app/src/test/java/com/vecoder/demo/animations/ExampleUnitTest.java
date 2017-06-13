package com.vecoder.demo.animations;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void uuid_fromString_isCorrect() throws Exception{
        String s = "com.intellimec.telematics.allianz_ims_internal";
        UUID uuid = UUID.fromString("00002415-0000-1000-8000-00805F9B34FB");

        assertNotNull(uuid);

        UUID uuid2 = UUID.nameUUIDFromBytes(s.getBytes());
        assertNotNull(uuid2);

        String s2 = "com.intellimec.telematics.allianz_ims_internal";
        UUID uuid3 = UUID.nameUUIDFromBytes(s2.getBytes());
        assertNotNull(uuid3);

        String suuid2 = uuid2.toString();
        String suuid3 = uuid3.toString();

        assertEquals(suuid2, suuid3);


        String s4 = "com.intellimec.telematics.allianz_ims_interna";
        UUID uuid4 = UUID.nameUUIDFromBytes(s4.getBytes());
        assertNotNull(uuid4);

        String suuid4 = uuid4.toString();

        assertNotEquals(suuid4, suuid3);
    }
}