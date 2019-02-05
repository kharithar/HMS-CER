/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author haritha
 */
public class MedicationSchedule extends Medication implements Runnable{
    public static enum Frequency{MINUTE,HOURLY,DAILY,LIFETIME};
    private Frequency frequency;
    
    public Frequency getFrequency() {
		return frequency;
	}
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	public MedicationSchedule() {
        super();
    }
//   public Date getStartDate() {
//        return super.getStartDate();
//    }
//    
//    public Date getEndDate() {
//        return super.getEndDate();
//    }
    public void usingInstantToSchedule() {
    	Instant instant = Instant.now();
    	Instant end = instant.plus(2, ChronoUnit.DAYS);
    	while(end.isAfter(instant)) {
    		System.out.println("time >>> "+instant);
    		instant = instant.plus(1,ChronoUnit.HOURS);
    		System.out.println(instant.atZone(ZoneId.of("America/Los_Angeles")));
    	}
    	
    }
//    public void schedule() {
//    	System.out.println("Instant.class........."+Instant.now());
//         //HashTable set = null;
//        Calendar  start = Calendar.getInstance();
//        start.setTime(getStartDate());
//        // get a calendar instance, which defaults to "now"
//        Calendar end = Calendar.9();
//        end.add(Calendar.DAY_OF_YEAR, 10);
//        System.out.println("start date ..."+start.getTime());
//        System.out.println("end date ..."+end.getTime());
//        if(Frequency.DAILY != null) { 
//        while(end.getTime().after(start.getTime())) {
//           System.out.println("every one hr" +start.getTime());
//            start.add(Calendar.DAY_OF_MONTH, 1);
//        	}  
//        }
//        if(Frequency.HOURLY != null) { 
//        	
//        while(end.getTime().after(start.getTime())) {
//           System.out.println("every one hr" +start.getTime());
//            start.add(Calendar.HOUR_OF_DAY, 1);
//        	}  
//        }
//        }
        
    public static void main(String[] args) {
        LocalDateTime localNow = LocalDateTime.now();
        ZoneId currentZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zoned10 = zonedNow.plusDays(10);
        while(zoned10.isAfter(zonedNow)) {
            System.out.println(zonedNow);
            zonedNow = zonedNow.plusDays(1);
        }
        System.out.println(zoned10);
    }
	@Override
	public void run() {
		System.out.println("alert for medication");
		
	}
}
