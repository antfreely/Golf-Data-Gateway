package com.imgarena.golf.data.gateway.unit.api.v2;

import com.imgarena.golf.data.gateway.api.v2.GolfTournamentDtoV2;
import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.testobject.GolfTournamentDtoV2TestObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test class for {@link GolfTournamentDtoV2}.
 */
public class GolfTournamentDtoV2Test {
  @Test
  @DisplayName("Should map an instance of GolfTournamentDtoV2 to the model GolfTournament")
  void shouldMapToGolfTournament() {
    // Given a valid instance of GolfTournamentDtoV2
    GolfTournamentDtoV2 dtoV2 = new GolfTournamentDtoV2TestObject().build();

    // When it is mapped to the model
    String dataSource = "My Data Source";
    GolfTournament golfTournament = dtoV2.toDomain(dataSource);

    // Then the model is built as expected
    GolfTournament expected = GolfTournament.builder()
        .externalGolfTournamentId(String.valueOf(dtoV2.getTournamentUuid()))
        .courseName(dtoV2.getGolfCourse())
        .tournamentName(dtoV2.getCompetitionName())
        .hostCountry(dtoV2.getHostCountry())
        .epochSecondsStart(dtoV2.getEpochStart())
        .epochSecondsFinish(dtoV2.getEpochEnd())
        .numberOfRounds(dtoV2.getRounds())
        .numberOfPlayers(dtoV2.getPlayerCount())
        .dataSource(dataSource)
        .build();

    assertThat(golfTournament)
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }
}
