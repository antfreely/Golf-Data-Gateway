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
public class GolfTournamentControllerV1IntegrationTest extends IntegrationTestBase {
  @Test
  @DisplayName("Should accept request at V1 endpoint and respond with 200 OK")
  void shouldRespond200() throws Exception {
    // Given a valid json request body
    final String requestBody =
        "{\n" +
        "  \"tournamentId\": \"174638\",\n" +
        "  \"tournamentName\": \"Women's Open Championship\",\n" +
        "  \"forecast\": \"fair\",\n" +
        "  \"courseName\": \"Sunnydale Golf Course\",\n" +
        "  \"countryCode\": \"GB\",\n" +
        "  \"startDate\": \"09/07/21\",\n" +
        "  \"endDate\": \"13/07/21\",\n" +
        "  \"roundCount\": \"4\"\n" +
        "}";

    // When the request is made to the V1 endpoint
    mockMvc.perform(
        post("/v1/golf-tournaments")
            .content(requestBody)
            .contentType(MediaType.APPLICATION_JSON)
            .header("DataSource", "Test data source"))
        // Then the response should be 200
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
