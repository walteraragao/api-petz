package br.com.petz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.petz.entity.CustomerEntity;

@Service
public interface CustomerService {

	public CustomerEntity save(CustomerEntity entity);
	
	public List<CustomerEntity> getListAll();
	
	public Optional<CustomerEntity> getById(Integer id);
	
	public Optional<CustomerEntity> getByCpf(String cpf);
	
	public void delete(CustomerEntity entity);
}
