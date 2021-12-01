package spdvi;

import java.time.LocalDate;
import java.lang.StringBuilder;
import java.time.LocalDateTime;

/**
 *
 * @author DevMike
 */
public class User {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

    public User(String firstName, String lastName, LocalDate birthDate, String gender, boolean isAlive, String imagen) {
        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.isAlive = isAlive;
        this.imagen = imagen;
    }
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private boolean isAlive;
    private String ruta;
    private String imagen;

    
    
    public String toString(){
        StringBuilder strUser = new StringBuilder();
        strUser.append(this.id + ": " + this.lastName + ", " + this.firstName + " - " + this.imagen + " - " );
        int age = LocalDateTime.now().getYear() - this.birthDate.getYear();
        strUser.append(age + " years old - " + this.gender);
        String alive = this.isAlive ? alive = ", Alive" : ", Dead";
        strUser.append(alive);
        strUser.append(System.lineSeparator());
        return strUser.toString();
    }
    
}
