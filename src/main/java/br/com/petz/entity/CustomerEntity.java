package br.com.petz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import br.com.petz.dto.CustomerDTO;
import br.com.petz.enums.GenderEnum;
import br.com.petz.enums.YesOrNoEnum;

@Entity
@Table(name="TB_CUSTOMER")
public class CustomerEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="GENDER")
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="ADDRESS")
	private String address;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATED")
	private Date dateCreated;
	
	@Column(name="FLAG_ACTIVE")
	@Enumerated(EnumType.STRING)
	private YesOrNoEnum flagActive;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PetEntity> pets = new ArrayList<>();
	
	public CustomerEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public void from (CustomerDTO dto) {
		this.name = dto.getName();
		this.lastName = dto.getLastName();
		this.address = dto.getAddress();
		this.gender = GenderEnum.getEnum(dto.getGender());
		this.cpf = dto.getCpf();
		this.flagActive = YesOrNoEnum.Y;
		
		if(dto.getPets() != null) {
			dto.getPets().stream().forEach(petDTO -> {
				PetEntity petEntity = new PetEntity();
				petEntity.from(petDTO);
				petEntity.setCustomer(this);
				this.pets.add(petEntity);
			});
		}
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public YesOrNoEnum getFlagActive() {
		return flagActive;
	}

	public void setFlagActive(YesOrNoEnum flagActive) {
		this.flagActive = flagActive;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}
	
	
	
}
