package com.asb.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SimpleServiceApplication {

	@Value(value = "${my.prop}")
	private String myProp;
	
	@Value(value = "${my.encrypted-prop}")
	private String decryptedProp;
	
	@GetMapping("/")
	public String getMyProp() {
		return "Prop value: " + myProp + " Decrypted Prop: " + decryptedProp;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleServiceApplication.class, args);
	}
}