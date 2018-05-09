package domain;

import Exceptions.InvalidNameLengthException;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Name {

    private String first;
    private String middle;
    private String last;


    public String getFirst() {
        return first;
    }


    public void setFirst(String first) throws InvalidNameLengthException {
        if (first.matches("\\w{1,15}")) {
            this.first = first;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle)throws InvalidNameLengthException {
        if (first.matches("\\w{0,15}")) {
        this.middle = middle;
        }
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) throws InvalidNameLengthException {
        if (first.matches("\\w{1,15}")) {
            this.last = last;
        }
    }

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", middle='" + middle + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
