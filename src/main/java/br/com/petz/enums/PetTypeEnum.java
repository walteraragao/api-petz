package br.com.petz.enums;

public enum PetTypeEnum {

	DOG, CAT, BIRD, TURTLE, BUNNY, HAMSTER;
	
	public static PetTypeEnum getEnum(String type) {
		for (PetTypeEnum e : PetTypeEnum.values()) {
			if (e.name().equalsIgnoreCase(type)) {
				return e;
			}
		}
		return null;
	}
}
