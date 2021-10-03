package com.imgarena.golf.data.gateway.testobject;

import com.imgarena.golf.data.gateway.db.GolfTournament;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * Test object class for {@link GolfTournament}.
 */
@With
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Only used by the @With annotation
@NoArgsConstructor
public class GolfTournamentTestObject extends TestObject<GolfTournament> {
  private String golfTournamentId;
  private String tournamentName;
  private String courseName;
  private String forecast;
  private String countryCode;
  private String hostCountry;
  private long epochSecondsStart;
  private long epochSecondsFinish;
  private int numberOfRounds;
  private int numberOfPlayers;

  @Override
  public GolfTournament build() {
    return GolfTournament.builder()
        .externalGolfTournamentId(golfTournamentId)
        .tournamentName(tournamentName)
        .courseName(courseName)
        .forecast(forecast)
        .countryCode(countryCode)
        .hostCountry(hostCountry)
        .epochSecondsStart(epochSecondsStart)
        .epochSecondsFinish(epochSecondsFinish)
        .numberOfRounds(numberOfRounds)
        .numberOfPlayers(numberOfPlayers)
        .build();
  }

  @Override
  protected void setInitialFieldValues() {
    this.golfTournamentId = "southWestInvitational";
    this.tournamentName = "South West Invitational";
    this.courseName = "Happy Days Golf Club";
    this.forecast = null;
    this.countryCode = null;
    this.hostCountry = "United States Of America";
    this.epochSecondsStart = 1638349200;
    this.epochSecondsFinish = 1638468000;
    this.numberOfRounds = 2;
    this.numberOfPlayers = 35;
  }
}
