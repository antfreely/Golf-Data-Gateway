package com.imgarena.golf.data.gateway.api.v2;

import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.db.GolfTournamentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller for version v2 of the API.
 */
@RestController
@RequestMapping("/v2")
public class GolfTournamentControllerV2 {
  private static final Logger log = LoggerFactory.getLogger(GolfTournamentControllerV2.class);

  private final GolfTournamentRepository golfTournamentRepository;

  @Autowired
  public GolfTournamentControllerV2(GolfTournamentRepository golfTournamentRepository) {
    this.golfTournamentRepository = golfTournamentRepository;
  }

  /**
   * Endpoint to POST a new golf tournament to in the v2 API.
   *
   * @param golfTournamentDtoV2 DTO following the v2 schema
   * @param dataSource request header value containing information on the source of the request
   * @return a {@link ResponseEntity}
   */
  @PostMapping(value = "/golf-tournaments")
  public ResponseEntity<Void> putGolfTournament(
      @RequestBody GolfTournamentDtoV2 golfTournamentDtoV2,
      @RequestHeader("DataSource") String dataSource
  ) {
    log.info("Received message from {}", dataSource);
    GolfTournament golfTournament = golfTournamentDtoV2.toDomain(dataSource);
    golfTournamentRepository.save(golfTournament);
    return ResponseEntity.ok().build();
  }
}
