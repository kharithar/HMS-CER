/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author haritha
 */
public class Allergy {
    private int allergyId;
    private String allergyName;
    private Set<String> symptoms;
    public static enum Severity{LOW, MEDIUM, HIGH};
    private Date reportedDate;
    public static enum ReportedBy{PATIENT, DOCTOR, RELATIVE};
    private Severity severity;
    private ReportedBy reportedBy;
    private List<Medication> medicationList;

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public Set<String> getSymptoms() {
        if(symptoms==null){
            symptoms = new HashSet<String>(); 
        }
        return this.symptoms;
    }

    public void setSymptoms(Set<String> symptoms) {
        this.symptoms = symptoms;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public ReportedBy getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(ReportedBy reportedBy) {
        this.reportedBy = reportedBy;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }
    

}
