package com.imgarena.golf.data.gateway.unit.api.v1;

import com.imgarena.golf.data.gateway.api.v1.GolfTournamentControllerV1;
import com.imgarena.golf.data.gateway.api.v1.GolfTournamentDtoV1;
import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.db.GolfTournamentRepository;
import com.imgarena.golf.data.gateway.testobject.GolfTournamentDtoV1TestObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit test class for {@link GolfTournamentControllerV1}.
 */
public class GolfTournamentControllerV1Test {
  @Test
  @DisplayName("Should save GolfTournament when a valid DTO is received")
  void shouldSaveGolfTournament() {
    // Setup
    GolfTournamentRepository golfTournamentRepository = mock(GolfTournamentRepository.class);
    GolfTournamentControllerV1 golfTournamentControllerV1 = new GolfTournamentControllerV1(golfTournamentRepository);

    // Given a valid DTO
    GolfTournamentDtoV1 dtoV1 = new GolfTournamentDtoV1TestObject().build();

    // When the controller receives it
    ResponseEntity<Void> responseEntity = golfTournamentControllerV1.putGolfTournament(dtoV1, "My Data Source");

    // Then the object is saved
    verify(golfTournamentRepository).save(any(GolfTournament.class));

    // And the response code is 200
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Response code should match");
  }
}
