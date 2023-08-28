package org.gauravj.usr.registration.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthRequest {
    String usrname;
    String password;
}
