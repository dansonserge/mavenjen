package com.hrm.HRM.salaryManagement.SalaryManagementVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.hrm.HRM.userManagement.userManagementVO.ContractVO;

@Entity
@Table(name="salary_request")
public class SalaryAdvanceVO {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salaryAdvanceId")
	private long salaryAdvanceId;
	
	@Column(name="dueDate")
	private String dueDate;
	
	@Column(name="endPaymentDate")
	private String endPaymentDate;
	
	@Column(name="requestDate")
	private String requestDate;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="reason")
	private String reason;
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "contractId")
    private ContractVO contractVO;

	
	
	
	public long getSalaryAdvanceId() {
		return salaryAdvanceId;
	}




	public void setSalaryAdvanceId(long salaryAdvanceId) {
		this.salaryAdvanceId = salaryAdvanceId;
	}




	public String getDueDate() {
		return dueDate;
	}




	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}




	public String getEndPaymentDate() {
		return endPaymentDate;
	}




	public void setEndPaymentDate(String endPaymentDate) {
		this.endPaymentDate = endPaymentDate;
	}




	public String getRequestDate() {
		return requestDate;
	}




	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getReason() {
		return reason;
	}




	public void setReason(String reason) {
		this.reason = reason;
	}




	public ContractVO getContractVO() {
		return contractVO;
	}




	public void setContractVO(ContractVO contractVO) {
		this.contractVO = contractVO;
	}




	public SalaryAdvanceVO() {
		super();
	}

	
}
