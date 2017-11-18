/**
 * 
 */
package com.intellect.test.user_cud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.intellect.test.user_cud.exception.InvalidBirthDateException;

/**
 * @author admin
 *
 */
public class DateConverter {
	private static String REQUEST_DATE_FORMAT= "dd-MMM-yyyy";
	
	public static Long ConvertRequestDateToTimeStamp(String date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(REQUEST_DATE_FORMAT);
		cal.setTime(sdf.parse(date));
		if(cal.getTime().after(Calendar.getInstance().getTime())){
			throw new InvalidBirthDateException("Birthdate is Greater then current Date");
		}
		return cal.getTimeInMillis();
	}
	
}
