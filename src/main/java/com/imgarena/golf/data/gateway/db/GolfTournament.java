package com.imgarena.golf.data.gateway.db;

import lombok.*;

import javax.persistence.*;

/**
 * Model class to represent data for a golf tournament.
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) // Needed for JPA
@AllArgsConstructor(access = AccessLevel.PRIVATE) // Needed for JPA
@Entity
@Table(name = "golf_tournament")
public class GolfTournament {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final long golfTournamentId;
  private final String externalGolfTournamentId;
  private final String tournamentName;
  private final String courseName;
  private final String forecast;
  private final String countryCode;
  private final String hostCountry;
  private final long epochSecondsStart;
  private final long epochSecondsFinish;
  private final int numberOfRounds;
  private final int numberOfPlayers;
  private final String dataSource;
}

