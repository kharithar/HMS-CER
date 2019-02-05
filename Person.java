/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import static java.lang.Math.log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author haritha
 */
public class Person {
    
    private int personId;
    private String firstName;
    private String lastName;
    public enum Gender{
        MALE,FEMALE
    };
    private Gender gender;
    //private String gender;
    private LocalDate birthDate;
    private String email;
    //private LocalDate birthTime;
    private Set<PersonAddress> addresses = null;
    Person(int personId, String firstName, String lastName,Gender gender,LocalDate birthDate,String email) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
                
    }
//include phone numbers fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<PersonAddress> getAddresses() {
        if(addresses == null){
            addresses = new HashSet<PersonAddress>();
        }
        return this.addresses;
    }

    public void setAddresses(Set<PersonAddress> addresses) {
        this.addresses = addresses;
    }
    /*public Date getBirthDateTime() {
        if(birthDate != null && birthTime != null){
            String birthDateString = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
            String birthTimeString = new SimpleDateFormat("HH:mm:ss").format(birthTime);

            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(birthDateString + " " + birthTimeString);
            } catch (ParseException e) {
                
            }
        }
        return null;
    }*/
    
    public static List<Person> addPersons(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1,"Haritha","Kodathala",Gender.FEMALE,LocalDate.of(1990,9,17),"kharithar@gmail.com"));
        personList.add(new Person(1,"Geet","Chillara",Gender.FEMALE,LocalDate.of(1990,10,15),"geetchill@gmail.com"));
        personList.add(new Person(1,"Megha","Kudumala",Gender.MALE,LocalDate.of(1991,7,15),"kmeghar@gmail.com"));
        return personList;
    }
    
    public int getAge() {
        return birthDate.until(LocalDate.now()).getYears();
    }
    
    public static int compareByAge(Person a, Person b) {
       return a.birthDate.compareTo(b.birthDate);
    }
    
    public void printPerson() {
        System.out.println(firstName + " " + this.getAge());
    }
}
