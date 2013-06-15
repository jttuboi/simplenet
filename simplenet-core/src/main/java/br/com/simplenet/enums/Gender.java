package br.com.simplenet.enums;

public enum Gender {
	MALE("M"),
	FEMALE("F");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private Gender(String value) {
		this.value = value;
	}
}
