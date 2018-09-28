package com.hrm.HRM.leaveManagement.leaveManagementVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="period")
public class PeriodVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="periodId")
	private long periodId;
	
	@Column(name="year1")
	private String year1;
	
	@Column(name="year2")
	private String year2;
	
	@Column(name="status")
	private String status;

	public long getPeriodId() {
		return periodId;
	}

	public void setPeriodId(long periodId) {
		this.periodId = periodId;
	}

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PeriodVO(long periodId, String year1, String year2, String status) {
		super();
		this.periodId = periodId;
		this.year1 = year1;
		this.year2 = year2;
		this.status = status;
	}

	public PeriodVO() {
		super();
	}
	
	
}
