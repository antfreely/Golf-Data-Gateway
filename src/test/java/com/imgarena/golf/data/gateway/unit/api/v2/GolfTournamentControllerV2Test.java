package com.imgarena.golf.data.gateway.unit.api.v2;

import com.imgarena.golf.data.gateway.api.v2.GolfTournamentControllerV2;
import com.imgarena.golf.data.gateway.api.v2.GolfTournamentDtoV2;
import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.db.GolfTournamentRepository;
import com.imgarena.golf.data.gateway.testobject.GolfTournamentDtoV2TestObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit test class for {@link GolfTournamentControllerV2}.
 */
public class GolfTournamentControllerV2Test {
  @Test
  @DisplayName("Should save GolfTournament when a valid DTO is received")
  void shouldSaveGolfTournament() {
    // Setup
    GolfTournamentRepository golfTournamentRepository = mock(GolfTournamentRepository.class);
    GolfTournamentControllerV2 GolfTournamentControllerV2 = new GolfTournamentControllerV2(golfTournamentRepository);

    // Given a valid DTO
    GolfTournamentDtoV2 dtoV2 = new GolfTournamentDtoV2TestObject().build();

    // When the controller receives it
    ResponseEntity<Void> responseEntity = GolfTournamentControllerV2.putGolfTournament(dtoV2, "My data source");

    // Then the object is saved
    verify(golfTournamentRepository).save(any(GolfTournament.class));

    // And the response code is 200
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Response code should match");
  }
}
