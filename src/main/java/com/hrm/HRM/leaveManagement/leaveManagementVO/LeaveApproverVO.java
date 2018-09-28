package com.hrm.HRM.leaveManagement.leaveManagementVO;

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
@Table(name="leaveApprover")
public class LeaveApproverVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leaveApproverId")
	private long leaveApproverId;
	
	@Column(name="isApproved", nullable=false ,columnDefinition= "TINYINT(1)",length =1 )
	@ColumnDefault("0")
	private Boolean isApproved;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private EmployeeVO employeeVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leaveId")
    private LeaveRequestVO leaveRequestVO;

	

	public long getLeaveApproverId() {
		return leaveApproverId;
	}



	public void setLeaveApproverId(long leaveApproverId) {
		this.leaveApproverId = leaveApproverId;
	}



	public Boolean getIsApproved() {
		return isApproved;
	}



	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}



	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}



	public LeaveRequestVO getLeaveRequestVO() {
		return leaveRequestVO;
	}



	public void setLeaveRequestVO(LeaveRequestVO leaveRequestVO) {
		this.leaveRequestVO = leaveRequestVO;
	}


	public LeaveApproverVO(long leaveApproverId, Boolean isApproved, String comment, EmployeeVO employeeVO,
			LeaveRequestVO leaveRequestVO) {
		super();
		this.leaveApproverId = leaveApproverId;
		this.isApproved = isApproved;
		this.comment = comment;
		this.employeeVO = employeeVO;
		this.leaveRequestVO = leaveRequestVO;
	}



	public LeaveApproverVO() {
		super();
	}
	
}
