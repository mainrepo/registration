package org.gauravj.usr.registration;

import org.springframework.boot.SpringApplication;
import org.gauravj.usr.registration.props.RoleStore;
import org.gauravj.usr.registration.props.UserStore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({UserStore.class, RoleStore.class})
public class RegistrationApplication{
	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}
}
