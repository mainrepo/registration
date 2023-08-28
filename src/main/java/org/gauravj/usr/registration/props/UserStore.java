package org.gauravj.usr.registration.props;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "user-store")
public class UserStore {
    private final Map<String, String> users;

    public String password(String userName){
        return users.get(userName);
    }
}
