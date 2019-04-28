package ppvis.util.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Name {
    private List<String> name;

    public Name(){
        name = new ArrayList<>();
    }
    public Name(String s){
        this();
        setName(s);
    }

    public String getName(){
        return toString();
    }

    public String getFirstName() {
        return name.size() == 1 ? name.get(0) : "";
    }

    public String getSecondName() {
        return name.size() == 2 ? name.get(1) : "";
    }

    public String getLastName() {
        return name.size() == 3 ? name.get(2) : "";
    }

    public int getCountOfNames(){
        return name.size();
    }

    public boolean isContain(String s){
        return name.contains(s);
    }

    public void setName(String string){
        string = string.trim();
        name.addAll(Arrays.asList(string.split(" ")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String rez = new String();
        for (String s : name)
            rez = rez.concat(s) + " ";
        return rez;
    }
}
