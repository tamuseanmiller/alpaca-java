package io.github.mainstringargs.alpaca;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Class Utilities.
 */
public class Utilities {

  /** The date time formatter. */
  private static DateTimeFormatter inputDateTimeFormatter = DateTimeFormatter.ofPattern(
      "[yyyyMMdd][yyyy-MM-dd][yyyy-DDD]['T'[HHmmss][HHmm][HH:mm:ss][HH:mm][.SSSSSSSSS][.SSSSSSSS][.SSSSSSS][.SSSSSS][.SSSSS][.SSS][.SS][.S]][OOOO][O][z][XXXXX][XXXX]['['VV']']");


  private static DateTimeFormatter outputDateTimeFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC"));

  /** The number formatter. */
  private static NumberFormat numberFormatter = new DecimalFormat("#0.00");

  /**
   * To date time string.
   *
   * @param ldt the ldt
   * @return the string
   */
  public static String toDateTimeString(LocalDateTime ldt) {
    

    ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());

    ZonedDateTime localTimeZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
    
    return outputDateTimeFormatter.format(localTimeZoned);
  }

  /**
   * To decimal format.
   *
   * @param numberToFormat the number to format
   * @return the string
   */
  public static String toDecimalFormat(Number numberToFormat) {
    return numberFormatter.format(numberToFormat);
  }

  /**
   * To date string.
   *
   * @param ld the ld
   * @return the string
   */
  public static String toDateString(LocalDate ld) {

    return ld.format(DateTimeFormatter.ISO_DATE);
  }

  /**
   * From date time string.
   *
   * @param dateTimeString the date time string
   * @return the local date time using the system time zone
   */
  public static LocalDateTime fromDateTimeString(String dateTimeString) {

    LocalDateTime ldt = LocalDateTime.parse(dateTimeString, inputDateTimeFormatter);

    ZonedDateTime ldtZoned = ldt.atZone(ZoneId.of("America/New_York"));

    ZonedDateTime localTimeZoned = ldtZoned.withZoneSameInstant(ZoneId.systemDefault());

    return localTimeZoned.toLocalDateTime();
  }

  /**
   * From date string.
   *
   * @param dateString the date string
   * @return the local date
   */
  public static LocalDate fromDateString(String dateString) {
    return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
  }

}