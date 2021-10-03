package com.imgarena.golf.data.gateway.integration.api;

import com.imgarena.golf.data.gateway.integration.util.IntegrationTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Integration test for the V1 Rest Controller.
 */
public class GolfTournamentControllerV2IntegrationTest extends IntegrationTestBase {
  @Test
  @DisplayName("Should accept request at V2 endpoint and respond with 200 OK")
  void shouldRespond200() throws Exception {
    // Given a valid json request body
    final String requestBody = "{\n" +
        "  \"tournamentUUID\": \"southWestInvitational\",\n" +
        "  \"golfCourse\": \"Happy Days Golf Club\",\n" +
        "  \"competitionName\": \"South West Invitational\",\n" +
        "  \"hostCountry\": \"United States Of America\",\n" +
        "  \"epochStart\": \"1638349200\",\n" +
        "  \"epochFinish\": \"1638468000\",\n" +
        "  \"rounds\": \"2\",\n" +
        "  \"playerCount\": \"35\"\n" +
        "}";

    // When the request is made to the V2 endpoint
    mockMvc.perform(
        post("/v2/golf-tournaments")
            .content(requestBody)
            .contentType(MediaType.APPLICATION_JSON)
            .header("DataSource", "Test data source"))
        // Then the response should be 200
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
