package dto;

public class CustomerDto {
  
    private String firstName;
  
    private String surname;
  
    private String streetAddress;
  
    private String dob;
  
    public String getFirstName() {
        return firstName;
    }
  
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
  
    public String getSurname() {
        return surname;
    }
  
    public void setSurname(String surname) {
        this.surname = surname;
    }
  
    public String getStreetAddress() {
        return streetAddress;
    }
  
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
  
    public String getDob() {
        return dob;
    }
  
    public void setDob(String dob) {
        this.dob = dob;
    }
  
    @Override
    public String toString() {
        return "CustomerDto{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
