
package usos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public abstract class Usos {
        
    public static LocalDate convertirDate(Date dateToConvert) {
    return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
  }
    
    public static java.sql.Date convertirDate(LocalDate fecha) {
        return java.sql.Date.valueOf(fecha);
  }

  public static Date convertirLocalDate(LocalDate dateToConvert) {
    return java.util.Date.from(dateToConvert.atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());
  }
  
  public static LocalTime obtenerLocalTimeDesdeCalendar(Calendar calendar) {
    int hora = calendar.get(Calendar.HOUR_OF_DAY);
    int minuto = calendar.get(Calendar.MINUTE);      
    LocalTime localTime = LocalTime.of(hora, minuto);

    return localTime;
}
}
