package ppvis.util.model;

import java.util.Objects;

public class Name implements Comparable<Name>{
    private String firstName = "";
    private String secondName = "";
    private String lastName = "";

    public Name(){

    }

    public Name(String name){
        String[] s = name.split(" ");
        if (s.length  >= 1)
            firstName = s[0];
        if (s.length >= 2)
            secondName = s[1];
        if (s.length >= 3)
            lastName = s[2];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName + " " + secondName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(secondName, name.secondName) &&
                Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName);
    }

    @Override
    public int compareTo(Name name) {
        if (name.getFullName().trim().equals(""))
            return 0;
        if (firstName.equalsIgnoreCase(name.getFirstName())){
            if(secondName.equalsIgnoreCase(name.getSecondName())){
                if(lastName.equalsIgnoreCase(name.getLastName()))
                    return 0;
                return 0;
            }
            return 0;
        }
        return 1;
    }
}
