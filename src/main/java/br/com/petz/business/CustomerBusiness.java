package br.com.petz.business;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.petz.dto.CustomerDTO;
import br.com.petz.entity.CustomerEntity;

@Component
public interface CustomerBusiness {

	public CustomerEntity applyRulesAndSave(CustomerDTO dto);
	
	public CustomerEntity applyRulesAndUpdate(CustomerDTO dto);
	
	public List<CustomerEntity> getListAll();
	
	public CustomerEntity getById(Integer id);
	
	public void applyRulesAndDelete(Integer id);
}
