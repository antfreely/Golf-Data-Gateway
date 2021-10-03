package com.imgarena.golf.data.gateway.api;

/**
 * Interface for DTOs to implement
 *
 * @param <T> model type for the DTO to be mapped to
 */
public interface DtoInterface<T> {
  T toDomain(String dataSource);
}
