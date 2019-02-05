/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author haritha
 */
public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private Calendar patientdob;
    private Vitals vitals;
    private List<Allergy> allergyList;
    private MedicationSchedule medSchedule;
    //private List<Address> addressList;
    //private List<Allergy> allergyList;
    //private List<Disease> diseaseList;

    public MedicationSchedule getMedSchedule() {
        return medSchedule;
    }

    public void setMedSchedule(MedicationSchedule medSchedule) {
        this.medSchedule = medSchedule;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Calendar getPatientdob() {
        return patientdob;
    }

    public void setPatientdob(Calendar patientdob) {
        this.patientdob = patientdob;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }

    public List<Allergy> getAllergyList() {
        if(allergyList==null){
            allergyList = new ArrayList<Allergy>(); 
        }
        return this.allergyList;
  
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }
    
    public void displayPatientDetails() {
        System.out.println(patientFirstName);
        Iterator itr = allergyList.iterator();
        while(itr.hasNext()) {
            Allergy allergy =(Allergy) itr.next();
            System.out.println(allergy.getAllergyName());
            System.out.println(allergy.getReportedBy());
            System.out.println(allergy.getSeverity());
            Iterator sympItr = allergy.getSymptoms().iterator();
            while(sympItr.hasNext()){
                String symptom =  (String)sympItr.next();
                System.out.print(symptom+",");
            }
        }
       
    }
    
    public List<Allergy> allergiesWithSymptom( String symp) {
    	// return allergyList.stream().map(allergy -> allergy.getSymptoms().stream().filter(symptom -> symptom.equals(symp))).collect(Collectors.toList());
    	Allergy[] alegies = (Allergy[]) allergyList.stream().map(allergy -> allergy.getSymptoms().stream().filter(symptom -> symptom.equals(symp))).toArray();
    	return Arrays.asList(alegies);
    	//return allergies;
    }
    
}
