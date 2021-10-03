package com.imgarena.golf.data.gateway.unit.api.v1;


import com.imgarena.golf.data.gateway.api.v1.EpochMapperV1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class for {@link EpochMapperV1}.
 */
public class EpochMapperV1Test {
  @Test
  @DisplayName("Should map a String version of a date to an epoch equivalent, in seconds")
  void shouldMapToEpoch() {
    // Given a date in the valid format
    final String date = "09/07/21";

    // When it is mapped to the epoch value
    final long actual = EpochMapperV1.from(date);

    // Then the actual value is as expected
    assertEquals(1625788800, actual, "Values should match");
  }
}
