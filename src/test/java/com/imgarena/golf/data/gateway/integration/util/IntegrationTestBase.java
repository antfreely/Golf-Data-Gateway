package com.imgarena.golf.data.gateway.integration.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imgarena.golf.data.gateway.GolfDataGatewayApplication;
import com.imgarena.golf.data.gateway.db.GolfTournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Base Integration Test class for all integration tests to extend so that the Spring Context is reused and not dirtied.
 */
@SpringBootTest(classes = {GolfDataGatewayApplication.class, IntegrationTestConfiguration.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class IntegrationTestBase {
  @Autowired
  protected MockMvc mockMvc;

  @Autowired
  protected GolfTournamentRepository golfTournamentRepository;

  @BeforeEach
  void beforeEach() {
    golfTournamentRepository.deleteAll();
  }
}
