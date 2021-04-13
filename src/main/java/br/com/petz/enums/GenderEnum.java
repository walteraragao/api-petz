package br.com.petz.enums;

public enum GenderEnum {

	MALE, FEMALE, OTHER;

	public static GenderEnum getEnum(String gender) {
		for (GenderEnum e : GenderEnum.values()) {
			if (e.name().equalsIgnoreCase(gender)) {
				return e;
			}
		}
		return null;
	}

}
