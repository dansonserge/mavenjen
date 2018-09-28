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

import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Entity
@Table(name="leaveDays")
public class LeaveDaysVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leaveDayId")
	private long leaveDayId;
	
	@Column(name="remainingPreDays")
	private String remainingPreDays;
	
	@Column(name="totalHours")
	private String totalDays;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private EmployeeVO employeeVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodId")
    private PeriodVO periodVO;

	public long getLeaveDayId() {
		return leaveDayId;
	}

	public void setLeaveDayId(long leaveDayId) {
		this.leaveDayId = leaveDayId;
	}

	public String getRemainingPreDays() {
		return remainingPreDays;
	}

	public void setRemainingPreDays(String remainingPreDays) {
		this.remainingPreDays = remainingPreDays;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}

	public PeriodVO getPeriodVO() {
		return periodVO;
	}

	public void setPeriodVO(PeriodVO periodVO) {
		this.periodVO = periodVO;
	}

	public LeaveDaysVO(long leaveDayId, String remainingPreDays, String totalDays, EmployeeVO employeeVO,
			PeriodVO periodVO) {
		super();
		this.leaveDayId = leaveDayId;
		this.remainingPreDays = remainingPreDays;
		this.totalDays = totalDays;
		this.employeeVO = employeeVO;
		this.periodVO = periodVO;
	}

	public LeaveDaysVO() {
		super();
	}
	
	

}
