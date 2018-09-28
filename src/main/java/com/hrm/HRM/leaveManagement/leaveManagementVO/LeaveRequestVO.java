package com.hrm.HRM.leaveManagement.leaveManagementVO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Entity
@Table(name="leaveRequest")
public class LeaveRequestVO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leaveId")
	private long leaveId;
	
	@Column(name="leaveType")
	private String leaveType;
	
	@Column(name="leaveDate")
	private String leaveDate;
		
	@Column(name="retunDate")
	private String retunDate;

	@Column(name="days")
	private Long days;

	@Column(name="hours")
	private Long hours;
	
	@Column(name="backupPerson")
	private String backupPerson;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="createdDate")
	private Timestamp createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodId")
    private PeriodVO PeriodVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private EmployeeVO employeeVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leaveCategoryId")
    private LeaveCategoryVO leaveCategoryVO;

	public long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getRetunDate() {
		return retunDate;
	}

	public void setRetunDate(String retunDate) {
		this.retunDate = retunDate;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public Long getHours() {
		return hours;
	}

	public void setHours(Long hours) {
		this.hours = hours;
	}

	public String getBackupPerson() {
		return backupPerson;
	}

	public void setBackupPerson(String backupPerson) {
		this.backupPerson = backupPerson;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public PeriodVO getPeriodVO() {
		return PeriodVO;
	}

	public void setPeriodVO(PeriodVO periodVO) {
		PeriodVO = periodVO;
	}

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public LeaveCategoryVO getLeaveCategoryVO() {
		return leaveCategoryVO;
	}

	public void setLeaveCategoryVO(LeaveCategoryVO leaveCategoryVO) {
		this.leaveCategoryVO = leaveCategoryVO;
	}

	public LeaveRequestVO(long leaveId, String leaveType, String leaveDate, String retunDate, Long days,
			Long hours, String backupPerson, String reason, String comment, Timestamp createdDate,
			com.hrm.HRM.leaveManagement.leaveManagementVO.PeriodVO periodVO, EmployeeVO employeeVO,
			LeaveCategoryVO leaveCategoryVO) {
		this.leaveId = leaveId;
		this.leaveType = leaveType;
		this.leaveDate = leaveDate;
		this.retunDate = retunDate;
		this.days = days;
		this.hours = hours;
		this.backupPerson = backupPerson;
		this.reason = reason;
		this.comment = comment;
		this.createdDate = createdDate;
		PeriodVO = periodVO;
		this.employeeVO = employeeVO;
		this.leaveCategoryVO = leaveCategoryVO;
	}

	public LeaveRequestVO() {
	}

	
	
}
