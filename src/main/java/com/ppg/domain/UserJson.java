package com.ppg.domain;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserJson extends ResourceSupport {


    @JsonProperty("email")
    private String mail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("activated")
    private String activated;

    public UserJson() {
    }



    @Override
    public String toString() {
        return "";
    }




	public String getEmail() {
		return mail;
	}



	public void setEmail(String mail) {
		this.mail = mail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getActivated() {
		return activated;
	}



	public void setActivated(String activated) {
		this.activated = activated;
	}
}