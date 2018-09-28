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

import org.hibernate.annotations.ColumnDefault;

import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Entity
@Table(name="salary_approver")
public class SalaryAdvanceApprovalVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salaryAdvanceApprovalId")
	private long salaryAdvanceApprovalId;
	
	@Column(name="title" ,nullable = false)
	private String title;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="isApproved",nullable = false, columnDefinition = "TINYINT(1)", length = 1)
	@ColumnDefault("0")
	private Boolean isApproved;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId")
    private EmployeeVO employeeVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="salaryRequestId")
	private SalaryAdvanceVO salaryAdvanceVO;
	
	
	
	public long getSalaryAdvanceApprovalId() {
		return salaryAdvanceApprovalId;
	}



	public void setSalaryAdvanceApprovalId(long salaryAdvanceApprovalId) {
		this.salaryAdvanceApprovalId = salaryAdvanceApprovalId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public Boolean getIsApproved() {
		return isApproved;
	}



	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}



	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}



	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}



	public SalaryAdvanceVO getSalaryAdvanceVO() {
		return salaryAdvanceVO;
	}



	public void setSalaryAdvanceVO(SalaryAdvanceVO salaryAdvanceVO) {
		this.salaryAdvanceVO = salaryAdvanceVO;
	}

	


	public SalaryAdvanceApprovalVO(long salaryAdvanceApprovalId, String title, String comment, Boolean isApproved,
			EmployeeVO employeeVO, SalaryAdvanceVO salaryAdvanceVO) {
		super();
		this.salaryAdvanceApprovalId = salaryAdvanceApprovalId;
		this.title = title;
		this.comment = comment;
		this.isApproved = isApproved;
		this.employeeVO = employeeVO;
		this.salaryAdvanceVO = salaryAdvanceVO;
	}



	public SalaryAdvanceApprovalVO() {
		super();
	}
}
