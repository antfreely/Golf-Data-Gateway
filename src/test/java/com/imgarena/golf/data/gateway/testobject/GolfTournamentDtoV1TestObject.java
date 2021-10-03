package com.imgarena.golf.data.gateway.testobject;

import com.imgarena.golf.data.gateway.api.v1.GolfTournamentDtoV1;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;

/**
 * Test object class for {@link GolfTournamentDtoV1}.
 */
@With
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Only used by the @With annotation
@NoArgsConstructor
public class GolfTournamentDtoV1TestObject extends TestObject<GolfTournamentDtoV1> {
  private int tournamentId;
  private String tournamentName;
  private String forecast;
  private String courseName;
  private String countryCode;
  private String startDate;
  private String endDate;
  private int roundCount;

  @Override
  public GolfTournamentDtoV1 build() {
    return GolfTournamentDtoV1.builder()
        .tournamentId(tournamentId)
        .tournamentName(tournamentName)
        .forecast(forecast)
        .courseName(courseName)
        .countryCode(countryCode)
        .startDate(startDate)
        .endDate(endDate)
        .roundCount(roundCount)
        .build();
  }

  @Override
  protected void setInitialFieldValues() {
    this.tournamentId = 174638;
    this.tournamentName = "Women's Open Championship";
    this.forecast = "fair";
    this.courseName = "Sunnydale Golf Course";
    this.countryCode = "GB";
    this.startDate = "09/07/21";
    this.endDate = "13/07/21";
    this.roundCount = 4;
  }
}
