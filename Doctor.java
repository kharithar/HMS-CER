/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haritha
 */
public class Doctor {
    private int docId;
    private String docFirstName;
    private String docLastName;
    private Address docAddress;
    private Calendar docDob;
    private List<Patient> patients;
    
    public int getDocId() {
        return docId;
    }
    
    public String getDocFirstName() {
        return docFirstName;
    }
    
    public String getDocLastName() {
        return docLastName;
    }
    
    public Address getDocAddress() {
        return docAddress;
    }
    
    public Calendar getDocDob() {
        return docDob;
    }

    public void setDocLastName(String docLastName) {
        this.docLastName = docLastName;
    }

    public void setDocAddress(Address docAddress) {
        this.docAddress = docAddress;
    }

    public void setDocDob(Calendar docDob) {
        this.docDob = docDob;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }
    
    public void setDocId( int docId) {
        this.docId = docId;
    }
    
    public void setDocFirstName(String docFirstName) {
        this.docFirstName = docFirstName;
    }
    
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
