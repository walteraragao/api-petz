package br.com.petz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.petz.dto.PetDTO;
import br.com.petz.enums.PetTypeEnum;

@Entity
@Table(name="TB_PET")
public class PetEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TYPE")
	@Enumerated(EnumType.STRING)
	private PetTypeEnum type;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER")
	private CustomerEntity customer;
	
	public PetEntity() {
		// TODO Auto-generated constructor stub
	}

	public void from(PetDTO dto) {
		this.name = dto.getName();
		this.type = PetTypeEnum.getEnum(dto.getType());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetTypeEnum getType() {
		return type;
	}

	public void setType(PetTypeEnum type) {
		this.type = type;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetEntity other = (PetEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
