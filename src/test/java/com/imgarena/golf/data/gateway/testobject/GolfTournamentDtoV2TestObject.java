package com.imgarena.golf.data.gateway.testobject;

import com.imgarena.golf.data.gateway.api.v2.GolfTournamentDtoV2;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * Test object class for {@link GolfTournamentDtoV2}.
 */
@With
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Only used by the @With annotation
@NoArgsConstructor
public class GolfTournamentDtoV2TestObject extends TestObject<GolfTournamentDtoV2> {
  private String tournamentUuid;
  private String golfCourse;
  private String competitionName;
  private String hostCountry;
  private long epochStart;
  private long epochEnd;
  private int rounds;
  private int playerCount;

  @Override
  public GolfTournamentDtoV2 build() {
    return GolfTournamentDtoV2.builder()
        .tournamentUuid(tournamentUuid)
        .golfCourse(golfCourse)
        .competitionName(competitionName)
        .hostCountry(hostCountry)
        .epochStart(epochStart)
        .epochEnd(epochEnd)
        .rounds(rounds)
        .playerCount(playerCount)
        .build();
  }

  @Override
  protected void setInitialFieldValues() {
    this.tournamentUuid = "southWestInvitational";
    this.golfCourse = "Happy Days Golf Club";
    this.competitionName = "South West Invitational";
    this.hostCountry = "United States Of America";
    this.epochStart = 1638349200;
    this.epochEnd = 1638468000;
    this.rounds = 2;
    this.playerCount = 35;
  }
}
