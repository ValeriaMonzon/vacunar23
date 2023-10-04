
package usos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public abstract class Usos {
        
    public static LocalDate convertirDate(Date dateToConvert) {
    return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
  }

  public static Date convertirLocalDate(LocalDate dateToConvert) {
    return java.util.Date.from(dateToConvert.atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());
  }
}
