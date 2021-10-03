package com.imgarena.golf.data.gateway.api.v2;

import com.imgarena.golf.data.gateway.api.DtoInterface;
import com.imgarena.golf.data.gateway.db.GolfTournament;
import lombok.Builder;
import lombok.Getter;

/**
 * DTO for the v2 API which will later be mapped to the domain object, {@link GolfTournament}.
 */
@Builder
@Getter
public class GolfTournamentDtoV2 implements DtoInterface<GolfTournament> {
  private final String tournamentUuid;
  private final String golfCourse;
  private final String competitionName;
  private final String hostCountry;
  private final long epochStart;
  private final long epochEnd;
  private final int rounds;
  private final int playerCount;

  @Override
  public GolfTournament toDomain(String dataSource) {
    return GolfTournament.builder()
        .externalGolfTournamentId(String.valueOf(tournamentUuid))
        .courseName(golfCourse)
        .tournamentName(competitionName)
        .hostCountry(hostCountry)
        .epochSecondsStart(epochStart)
        .epochSecondsFinish(epochEnd)
        .numberOfRounds(rounds)
        .numberOfPlayers(playerCount)
        .dataSource(dataSource)
        .build();
  }
}
