package com.ppg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ppg.domain.Role;
import com.ppg.domain.User;
import com.ppg.domain.UserJson;
import com.ppg.services.security.EncryptionService;

@Service
@Profile("springdatajpa")
@PropertySource("file:application.properties")
public class UserServiceImpl implements UserService {



    @Value("${user.url}")
    private String userUrl;
    
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
 

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }


	@Override
	public List<User> listAll() {	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserJson[]> response = restTemplate.getForEntity(userUrl + "/user/list", UserJson[].class);
		
		List<User> users = new ArrayList<>();
		
		for(UserJson uj: response.getBody() ){
			User user = new User();
			  user.setUsername(uj.getEmail());
	          user.setEncryptedPassword(encryptionService.encryptString(uj.getPassword()));
	          Role adminRole = new Role();
	          adminRole.setRole("ADMIN");
	          user.addRole(adminRole);
			users.add(user);
		}
		
		return users;

	}

 

	@Override
	public User saveOrUpdate(User domainObject) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(
				userUrl + "/user/add/" + domainObject.getUsername() + "/" + domainObject.getPassword(), String.class);
		return domainObject;
	}

	@Override
	public void delete(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		User response = restTemplate.getForObject(userUrl + "/user/delete/" + id, User.class);
	}

	@Override
    public User findByUsername(String username) {
    	RestTemplate restTemplate = new RestTemplate();
    	UserJson uj = restTemplate.getForObject(userUrl + "/users/"+username, UserJson.class);
    	
    	User user = new User();
		  user.setUsername(uj.getEmail());
        user.setEncryptedPassword(encryptionService.encryptString(uj.getPassword()));

        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        user.addRole(adminRole);
        
		return user;
    }


	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
