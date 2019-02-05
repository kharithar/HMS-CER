/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.time.Instant;
import java.util.Map;

/**
 *
 * @author haritha
 */
public class Medication {
   private int prescriptionId;
   private String medicineName;
   private int dosage;
   private int quantity;
   private Instant prescriptionFilledInstant;
   private Instant startInstant;
   private Instant endInstant;
   private String directionsForUse;

    public Medication() {
        
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Instant getPrescriptionFilledInstant() {
        return prescriptionFilledInstant;
    }

    public void setPrescriptionFilledInstant(Instant prescriptionFilledInstant) {
        this.prescriptionFilledInstant = prescriptionFilledInstant;
    }

    public Instant getStartInstant() {
        return startInstant;
    }

    public void setStartInstant(Instant startInstant) {
        this.startInstant = startInstant;
    }

    public Instant getEndInstant() {
        return endInstant;
    }

    public void setEndInstant(Instant endInstant) {
        this.endInstant = endInstant;
    }

    public String getDirectionsForUse() {
        return directionsForUse;
    }

    public void setDirectionsForUse(String directionsForUse) {
        this.directionsForUse = directionsForUse;
    }
   
//   public void setAlertForMedicine() {
//       Instant Instant = new java.time.Instant();
//       
//   }
   public String getDrugString(){
		return medicineName+"/"+dosage+"/"+quantity;
	}
   
}
