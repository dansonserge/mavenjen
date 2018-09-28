package com.hrm.HRM.userManagement.userManagementVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contractType")
public class ContractTypeVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contractTypeId")
	private long contractTypeId;
	
	@Column(name="description")
	private String description;


	public long getContractTypeId() {
		return contractTypeId;
	}


	public void setContractTypeId(long contractTypeId) {
		this.contractTypeId = contractTypeId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ContractTypeVO() {
		super();
	}
	
	
}
