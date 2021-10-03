package com.imgarena.golf.data.gateway.api.v1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Mapper class to get the epoch value of a date in seconds.
 */
public class EpochMapperV1 {

  /**
   * Maps a date in the format of dd/mm/yy to the epoch value in seconds.
   *
   * @param date string format of date in dd/MM/yy
   * @return epoch value of date in seconds
   */
  public static long from(String date) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    final LocalDate localDate = LocalDate.parse(date, formatter);
    return localDate.toEpochSecond(LocalTime.MIN, ZoneOffset.UTC);
  }
}
