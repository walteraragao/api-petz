package br.com.petz.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.business.CustomerBusiness;
import br.com.petz.dto.CustomerDTO;
import br.com.petz.entity.CustomerEntity;

@RestController
@RequestMapping("/customer")
public class CustomerEnpoint implements IEndpoint<CustomerDTO> {

	@Autowired
	private CustomerBusiness business;

	@Override
	public ResponseEntity<Object> save(CustomerDTO dto) {
		CustomerEntity entity = this.business.applyRulesAndSave(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@Override
	public ResponseEntity<Object> delete(Integer id) {
		this.business.applyRulesAndDelete(id);
		return ResponseEntity.status(HttpStatus.OK).body(
				String.format("{\"codigo\" : \"%s\", \"mensagem\": \"Customer has been deleted sucessfully.\"}", id));
	}

	@Override
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.ok(this.business.getListAll());
	}

	@Override
	public ResponseEntity<Object> findById(Integer id) {
		return ResponseEntity.ok(this.business.getById(id));
	}

	@Override
	public ResponseEntity<Object> update(CustomerDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(this.business.applyRulesAndUpdate(dto));
	}

}
