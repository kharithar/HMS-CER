/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import hms.Fever.MEASUREDBY;
import hms.Fever.UNITS;
import hms.MedicationSchedule.Frequency;
import hms.Temperature.Units;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author haritha
 */
public class HMS {
	

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//    	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//    	Instant instant = Instant.now();
//    	Instant end = instant.plus(2, ChronoUnit.DAYS);
//    	Temperature temp = new Temperature();
////    	while(end.isAfter(instant)) {
//    	executor.scheduleAtFixedRate(temp,1, 1, TimeUnit.MINUTES);
////    	end = end.plus(1,ChronoUnit.MINUTES);
////    	}
    	
    	
        // TODO code application logic here
        /*Temperature temp = new Temperature(0,Units.CELSIUS);
        System.out.println(temp.toString());
        temp.changeUnits(Units.FAHRENHEIT);
        System.out.println(temp.toString());
        temp.setValueInKelvin(0);
        temp.setUnits(Units.KELVIN);
        Temperature tempe = new Temperature(temp);
        
        tempe.changeUnits(Units.FAHRENHEIT);
        System.out.println(tempe.toString());*/
    	
//    	Fever fever = new Fever(313,UNITS.CELSIUS,MEASUREDBY.AARMPIT);
//    	boolean hasFever = fever.convert();
//    	if(hasFever)
//    		System.out.println("Has Fever");
        /*Patient patient = new Patient();
        patient.setPatientId(1);
        patient.setPatientFirstName("Haritha");
        patient.setPatientLastName("K");
        Vitals vitals = new Vitals();
        vitals.setTemperature(97);
        vitals.setUnits(Vitals.Units.FAHRENHEIT);
        
        Allergy allergy = new Allergy();
        allergy.setAllergyName("rashes");
        allergy.setReportedBy(Allergy.ReportedBy.DOCTOR);
        allergy.setSeverity(Allergy.Severity.LOW);
        allergy.getSymptoms().add("red");
        allergy.getSymptoms().add("swelling");
        patient.setVitals(vitals);
        patient.getAllergyList().add(allergy);
        patient.displayPatientDetails();
        System.out.println("Has Fever "+ patient.getVitals().getHasFever());*/
        
//        Medication medication = new Medication();
//        Date date= new Date();
//        medication.setStartDate(date);
        MedicationSchedule md = new MedicationSchedule();
        md.setStartInstant(Instant.now());
        md.setFrequency(Frequency.MINUTE);
        TimeUnit timeUnit = null;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        if(md.getFrequency().equals(Frequency.MINUTE)) {
        	 timeUnit = TimeUnit.MINUTES;
        }
    	executor.scheduleAtFixedRate(md,1, 1, timeUnit);
//        md.usingInstantToSchedule();
        //md.setStartDate(date);
        //md.schedule();
        
//        List<Person> personList = Person.addPersons();
//        for(Person person : personList) {
//            person.printPerson();
//        }
//        Collections.sort(personList,new Comparator<Person>(){
//            @Override
//            public int compare (Person p1,Person p2){
//                if(p1.getAge() == p2.getAge()){
//                    //return 0;
//                    return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
//                }else if(p1.getAge() < p2.getAge()){
//                    return -1;
//                }
//                return 1;
//            }
//        });
//      for(Person person : personList) {
//            person.printPerson();
//        }
        
    }
    
}
