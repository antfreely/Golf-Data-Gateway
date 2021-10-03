package com.imgarena.golf.data.gateway.unit.api.v1;

import com.imgarena.golf.data.gateway.api.v1.EpochMapperV1;
import com.imgarena.golf.data.gateway.api.v1.GolfTournamentDtoV1;
import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.testobject.GolfTournamentDtoV1TestObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test class for {@link GolfTournamentDtoV1}.
 */
public class GolfTournamentDtoV1Test {
  @Test
  @DisplayName("Should map an instance of GolfTournamentDtoV1 to the model GolfTournament")
  void shouldMapToGolfTournament() {
    // Given a valid instance of GolfTournamentDtoV1
    GolfTournamentDtoV1 dtoV1 = new GolfTournamentDtoV1TestObject().build();

    // When it is mapped to the model
    String dataSource = "My data source";
    GolfTournament golfTournament = dtoV1.toDomain(dataSource);

    // Then the model is built as expected
    GolfTournament expected = GolfTournament.builder()
        .externalGolfTournamentId(String.valueOf(dtoV1.getTournamentId()))
        .tournamentName(dtoV1.getTournamentName())
        .forecast(dtoV1.getForecast())
        .courseName(dtoV1.getCourseName())
        .countryCode(dtoV1.getCountryCode())
        .epochSecondsStart(EpochMapperV1.from(dtoV1.getStartDate()))
        .epochSecondsFinish(EpochMapperV1.from(dtoV1.getEndDate()))
        .numberOfRounds(dtoV1.getRoundCount())
        .dataSource(dataSource)
        .build();

    assertThat(golfTournament)
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }
}
