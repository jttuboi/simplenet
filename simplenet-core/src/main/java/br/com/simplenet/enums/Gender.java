package br.com.simplenet.enums;

public enum Gender {
	MALE("M"),
	FEMALE("F");
	
	private String value;
	
	private Gender(String value) {
		this.value = value;
	}
}
