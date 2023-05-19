/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;

/**
 *
 * @author Windows10
 */
public class Utilidades {

    public static Date LocalADate(LocalDate fecha) {

        return Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

}
