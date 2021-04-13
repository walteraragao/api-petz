package br.com.petz.business.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.petz.business.CustomerBusiness;
import br.com.petz.dto.CustomerDTO;
import br.com.petz.entity.CustomerEntity;
import br.com.petz.exception.runtime.ObjectAlreadyExistsException;
import br.com.petz.exception.runtime.ObjectNotFoundException;
import br.com.petz.exception.runtime.RequiredFieldException;
import br.com.petz.service.CustomerService;
import br.com.petz.validation.CustomerValidation;

@Component
public class CustomerBusinessImplementation implements CustomerBusiness {

	@Autowired
	private CustomerService customerService;

	@Override
	public CustomerEntity applyRulesAndSave(CustomerDTO dto) {
		new CustomerValidation(dto);
		Optional<CustomerEntity> optional = this.customerService.getByCpf(dto.getCpf());
		if (optional.isPresent())
			throw new ObjectAlreadyExistsException("Customer Already Exists by cpf " + dto.getCpf());
		CustomerEntity entity = new CustomerEntity();
		entity.from(dto);
		return this.customerService.save(entity);
	}

	@Override
	public CustomerEntity applyRulesAndUpdate(CustomerDTO dto) {
		new CustomerValidation(dto);
		if(dto.getId() == null)
			throw new RequiredFieldException("The Attribute ID Is Required.");

		CustomerEntity entity = new CustomerEntity();
		entity.from(dto);
		entity.setId(dto.getId());
		return this.customerService.save(entity);

	}

	@Override
	public List<CustomerEntity> getListAll() {
		// TODO Auto-generated method stub
		return this.customerService.getListAll();
	}

	@Override
	public CustomerEntity getById(Integer id) {
		// TODO Auto-generated method stub
		return this.customerService.getById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Customer Not Found by id " + id));
	}

	@Override
	public void applyRulesAndDelete(Integer id) {
		CustomerEntity customerEntity = this.customerService.getById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Customer Not Found by id " + id));
		this.customerService.delete(customerEntity);
	}

}
