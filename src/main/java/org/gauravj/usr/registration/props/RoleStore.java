package org.gauravj.usr.registration.props;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "role-store")
public class RoleStore {
    private final Map<String, String> roles;

    public String role(String userName){
        return roles.get(userName);
    }
}