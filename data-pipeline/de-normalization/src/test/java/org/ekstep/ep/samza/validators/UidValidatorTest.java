package org.ekstep.ep.samza.validators;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UidValidatorTest {

    @Test
    public void TestShouldBeInvalidWhenMapIsNull() {
        TimestampValidator timestampValidator = new TimestampValidator(null);

        assertTrue(timestampValidator.isInvalid());
    }

    @Test
    public void ShouldBeInvalidWhenMapIsEmpty() {
        TimestampValidator timestampValidator = new TimestampValidator(new HashMap<String, Object>());

        assertTrue(timestampValidator.isInvalid());
    }

    @Test
    public void ShouldBeInvalidWhenMapDoesNotHaveUidKey() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("some key", "some value");
        TimestampValidator timestampValidator = new TimestampValidator(map);

        assertTrue(timestampValidator.isInvalid());
    }
    @Test
    public void ShouldBeInvalidWhenUidKeyInMapIsEmpty() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("uid", "");
        TimestampValidator timestampValidator = new TimestampValidator(map);

        assertTrue(timestampValidator.isInvalid());
    }

    @Test
    public void ShouldBeValidWhenThereIsUidKeyInMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("uid", "2008-06-16T00:00:00 +0530");
        TimestampValidator timestampValidator = new TimestampValidator(map);

        assertFalse(timestampValidator.isInvalid());
    }

}