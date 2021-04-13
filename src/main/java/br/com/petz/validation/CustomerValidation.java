package br.com.petz.validation;

import br.com.petz.dto.CustomerDTO;
import br.com.petz.enums.GenderEnum;
import br.com.petz.exception.runtime.RequiredFieldException;
import br.com.petz.utils.StringUtil;

public class CustomerValidation {

	private CustomerDTO dto;

	private static final String MSG_ERROR_NAME="Attribute NAME is required.";
	private static final String MSG_ERROR_LASTNAME="Attribute LASTNAME is required.";
	private static final String MSG_ERROR_CPF="Attribute CPF is required.";
	private static final String MSG_ERROR_GENDER="Attribute GENDER is required.";
	private static final String MSG_ERROR_ADDRESS="Attribute ADDRESS is required.";

	public CustomerValidation(CustomerDTO dto) {
		this.dto = dto;
		this.checkName();
	}

	public CustomerValidation checkName() {
		if (StringUtil.isNullOrBlank(this.dto.getName()))
			throw new RequiredFieldException(MSG_ERROR_NAME);
		return this.checkLastName();
	}

	public CustomerValidation checkLastName() {
		if (StringUtil.isNullOrBlank(this.dto.getLastName()))
			throw new RequiredFieldException(MSG_ERROR_LASTNAME);
		return this.checkGender();
	}

	public CustomerValidation checkGender() {
		if (StringUtil.isNullOrBlank(this.dto.getGender()))
			throw new RequiredFieldException(MSG_ERROR_GENDER);
		
		if(GenderEnum.getEnum(this.dto.getGender()) == null)
			throw new RequiredFieldException("The attribute GENDER should be MALE, FEMALE or OTHER");
		return this.checkCPF();
	}

	public CustomerValidation checkCPF() {
		if (StringUtil.isNullOrBlank(this.dto.getCpf()))
			throw new RequiredFieldException(MSG_ERROR_CPF);
		return this.checkAddress();
	}

	public CustomerValidation checkAddress() {
		if (StringUtil.isNullOrBlank(this.dto.getAddress()))
			throw new RequiredFieldException(MSG_ERROR_ADDRESS);
		return this;
	}
}
