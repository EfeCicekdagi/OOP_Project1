
public class CustomerData {
    private String name ;
    private String surname;
    private String country;
    private String city;
    private String occupation;
    
    public CustomerData(){  //Creates empty construct in CustomerData class
        name = "";
        surname ="";
        country ="";
        city ="";
        occupation ="";
    }
    public CustomerData(String name,String surname,String country, String city,String occupation){  //Creates a parameterised construct in the CustomerData class
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.occupation = occupation;
    }
    public CustomerData(CustomerData other){    //Creates a copy construct in the CustomerData class
        name = other.name;
        surname = other.surname;
        country = other.country;
        city = other.city;
        occupation = other.occupation;
    }
    @Override
    public String toString() {  //
        return "CustomerData: " + "Name=" + name + ", Surname=" + surname + ", country=" + country + ", city=" + city + ", occupation=" + occupation ;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
}
