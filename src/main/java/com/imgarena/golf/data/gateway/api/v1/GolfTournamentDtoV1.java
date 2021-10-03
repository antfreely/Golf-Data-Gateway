package com.imgarena.golf.data.gateway.api.v1;

import com.imgarena.golf.data.gateway.api.DtoInterface;
import com.imgarena.golf.data.gateway.db.GolfTournament;
import lombok.Builder;
import lombok.Getter;

/**
 * DTO for the v1 API which will later be mapped to the domain object, {@link GolfTournament}.
 */
@Builder
@Getter
public class GolfTournamentDtoV1 implements DtoInterface<GolfTournament> {
  private final int tournamentId;
  private final String tournamentName;
  private final String forecast;
  private final String courseName;
  private final String countryCode;
  private final String startDate;
  private final String endDate;
  private final int roundCount;

  @Override
  public GolfTournament toDomain(String dataSource) {
    return GolfTournament.builder()
        .externalGolfTournamentId(String.valueOf(tournamentId))
        .tournamentName(tournamentName)
        .forecast(forecast)
        .courseName(courseName)
        .countryCode(countryCode)
        .epochSecondsStart(EpochMapperV1.from(startDate))
        .epochSecondsFinish(EpochMapperV1.from(endDate))
        .numberOfRounds(roundCount)
        .dataSource(dataSource)
        .build();
  }

}
