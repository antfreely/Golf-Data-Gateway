package com.imgarena.golf.data.gateway.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class that allows CRUD operations for the {@link GolfTournament} table.
 */
@Repository
public interface GolfTournamentRepository extends CrudRepository<GolfTournament, String> {
}
