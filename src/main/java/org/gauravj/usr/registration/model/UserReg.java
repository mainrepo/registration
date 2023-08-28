package org.gauravj.usr.registration.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserReg {
    String firstName;
    String lastname;
    String address;
    String created;
    String gender;
    String mobile;
    String email;
}
