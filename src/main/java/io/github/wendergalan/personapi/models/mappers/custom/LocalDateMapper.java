package io.github.wendergalan.personapi.models.mappers.custom;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateMapper {

    public String asString(LocalDate localDate) {
        return localDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(localDate) : null;
    }

    public LocalDate asLocalDate(String localDate) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(localDate, dtf);
    }
}
