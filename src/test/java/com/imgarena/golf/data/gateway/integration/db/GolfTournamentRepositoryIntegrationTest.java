package com.imgarena.golf.data.gateway.integration.db;


import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.integration.util.IntegrationTestBase;
import com.imgarena.golf.data.gateway.testobject.GolfTournamentTestObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Class that tests the integration with JPA.
 */
public class GolfTournamentRepositoryIntegrationTest extends IntegrationTestBase {

  @Test
  @DisplayName("Should be able to save a record in the database")
  void shouldSaveRecordInDatabase() {
    // Given a valid record
    GolfTournament record = new GolfTournamentTestObject().build();

    // When the repository saves the record
    golfTournamentRepository.save(record);

    // Then one record should be in the repository
    Iterable<GolfTournament> savedRecords = golfTournamentRepository.findAll();
    Iterator<GolfTournament> iterator = savedRecords.iterator();

    if (iterator.hasNext()) {
      GolfTournament actual = iterator.next();

      // And the record should be saved as expected
      assertThat(actual)
          .usingRecursiveComparison()
          .ignoringFields("golfTournamentId")
          .isEqualTo(record);

      // And no more records should be in the repository
      assertFalse(iterator.hasNext(), "No more records should be in the repository");
    } else {
      fail("No records found in the repository");
    }
  }
}
