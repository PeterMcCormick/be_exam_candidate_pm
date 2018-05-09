package domain;

import Exceptions.InvalidIdException;
import Exceptions.InvalidPhoneNumberException;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserStory {


    private int id;
    private Name name;
    private String phone;

    public UserStory(int id, Name name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonSetter
    public void setId(int id) throws InvalidIdException {
        if (Integer.toString(id).matches("\\d{8}")) {
            this.id = id;
        } else {
            throw new InvalidIdException();
        }
    }

    @JsonGetter("name")
    public Name getName() {
        return name;
    }

    @JsonSetter
    public void setName(Name name) {
        this.name = name;
    }

    @JsonGetter("phone")
    public String getPhone() {
        return phone;
    }

    @JsonSetter
    public void setPhone(String phone) throws InvalidPhoneNumberException{
        if(phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            this.phone = phone;
        } else {
            System.out.println("The phone number is not valid");
            throw new InvalidPhoneNumberException();
        }
    }

}
