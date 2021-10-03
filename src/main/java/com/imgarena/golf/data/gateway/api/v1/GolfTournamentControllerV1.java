package com.imgarena.golf.data.gateway.api.v1;

import com.imgarena.golf.data.gateway.db.GolfTournament;
import com.imgarena.golf.data.gateway.db.GolfTournamentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller for version v1 of the API.
 */
@RestController
@RequestMapping("/v1")
public class GolfTournamentControllerV1 {
  private static final Logger log = LoggerFactory.getLogger(GolfTournamentControllerV1.class);
  private final GolfTournamentRepository golfTournamentRepository;

  @Autowired
  public GolfTournamentControllerV1(GolfTournamentRepository golfTournamentRepository) {
    this.golfTournamentRepository = golfTournamentRepository;
  }

  /**
   * Endpoint to POST a new golf tournament to in the v1 API.
   *
   * @param golfTournamentDtoV1 DTO following the v1 schema
   * @param dataSource request header value containing information on the source of the request
   * @return a {@link ResponseEntity}
   */
  @PostMapping(value = "/golf-tournaments")
  public ResponseEntity<Void> putGolfTournament(
      @RequestBody GolfTournamentDtoV1 golfTournamentDtoV1,
      @RequestHeader("DataSource") String dataSource
  ) {
    log.info("Received message from {}", dataSource);
    GolfTournament golfTournament = golfTournamentDtoV1.toDomain(dataSource);
    golfTournamentRepository.save(golfTournament);
    return ResponseEntity.ok().build();
  }
}
