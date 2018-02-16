/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author G0042204
 */
public class StringToCalendar {

    public static Calendar parse(String dia) throws Exception {
        DateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date date = (Date) formatter.parse(dia);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
