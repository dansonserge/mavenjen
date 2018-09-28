package com.hrm.HRM.userManagement.userManagementVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contract")
public class ContractVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contractId")
	private long contractId;

	@Column(name="startDate")
	private String startDate;
	
	@Column(name="endDate")
	private String endDate;
	
	@Column(name="monthlySalary")
	private String monthlySalary;
	
	@Column(name="status")
	private String status;
	
	@Column(name="contractAttachFileName")
	private String contractAttachFileName;
	
	@Column(name="contractAttachFileSize")
	private String contractAttachFileSize;
	
	@Column(name="contractAttachFilePath")
	private String contractAttachFilePath;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private EmployeeVO employeeVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractTypeId")
    private ContractTypeVO contractTypeVO;

	public long getContractId() {
		return contractId;
	}


	public void setContractId(long contractId) {
		this.contractId = contractId;
	}


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getMonthlySalary() {
		return monthlySalary;
	}


	public void setMonthlySalary(String monthlySalary) {
		this.monthlySalary = monthlySalary;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getContractAttachFileName() {
		return contractAttachFileName;
	}


	public void setContractAttachFileName(String contractAttachFileName) {
		this.contractAttachFileName = contractAttachFileName;
	}


	public String getContractAttachFileSize() {
		return contractAttachFileSize;
	}

	public void setContractAttachFileSize(String contractAttachFileSize) {
		this.contractAttachFileSize = contractAttachFileSize;
	}

	public String getContractAttachFilePath() {
		return contractAttachFilePath;
	}

	public void setContractAttachFilePath(String contractAttachFilePath) {
		this.contractAttachFilePath = contractAttachFilePath;
	}

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}


	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}


	public ContractTypeVO getContractTypeVO() {
		return contractTypeVO;
	}


	public void setContractTypeVO(ContractTypeVO contractTypeVO) {
		this.contractTypeVO = contractTypeVO;
	}

	public ContractVO(long contractId, String startDate, String endDate, String monthlySalary, String status,
			String contractAttachFileName, String contractAttachFileSize, String contractAttachFilePath,
			EmployeeVO employeeVO, ContractTypeVO contractTypeVO) {
		this.contractId = contractId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.monthlySalary = monthlySalary;
		this.status = status;
		this.contractAttachFileName = contractAttachFileName;
		this.contractAttachFileSize = contractAttachFileSize;
		this.contractAttachFilePath = contractAttachFilePath;
		this.employeeVO = employeeVO;
		this.contractTypeVO = contractTypeVO;
	}


	public ContractVO() {
		super();
	}
	
	
}
