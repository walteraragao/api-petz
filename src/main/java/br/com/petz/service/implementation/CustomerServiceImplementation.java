package br.com.petz.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.entity.CustomerEntity;
import br.com.petz.repository.CustomerRepository;
import br.com.petz.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public CustomerEntity save(CustomerEntity entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<CustomerEntity> getListAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Optional<CustomerEntity> getById(Integer id) {
		return this.repository.findById(id);
	}

	@Override
	public void delete(CustomerEntity entity) {
		this.repository.delete(entity);
	}

	@Override
	public Optional<CustomerEntity> getByCpf(String cpf) {
		// TODO Auto-generated method stub
		return this.repository.findByCpf(cpf);
	}

}
