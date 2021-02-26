package designpatterns.creational.builder;

import java.time.LocalDate;

public class UserRESTDTOBuilder implements UserDTOBuilder{
    @Override
    public UserDTOBuilder withFirstName(String fname) {
        return null;
    }

    @Override
    public UserDTOBuilder withLastName(String lname) {
        return null;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate date) {
        return null;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        return null;
    }

    @Override
    public UserDTO build() {
        return null;
    }

    @Override
    public UserDTO getUserDTO() {
        return null;
    }
}
