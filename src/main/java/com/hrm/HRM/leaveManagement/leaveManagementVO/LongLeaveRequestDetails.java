package com.hrm.HRM.leaveManagement.leaveManagementVO;


import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

//this object is used to collect and submit all 
//Long leave details from the form
public class LongLeaveRequestDetails {

    private String dateToGo;
    private String returnDate;
    private String bacupP;
    private String comment;
    private LeaveCategoryVO leaveCateg;
    private EmployeeVO empId;
    private PeriodVO period;

	public String getDateToGo() {
		return dateToGo;
	}
	public void setDateToGo(String dateToGo) {
		this.dateToGo = dateToGo;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getBacupP() {
		return bacupP;
	}
	public void setBacupP(String bacupP) {
		this.bacupP = bacupP;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LeaveCategoryVO getLeaveCateg() {
		return leaveCateg;
	}
	public void setLeaveCateg(LeaveCategoryVO leaveCateg) {
		this.leaveCateg = leaveCateg;
	}
	public EmployeeVO getEmpId() {
		return empId;
	}
	public void setEmpId(EmployeeVO empId) {
		this.empId = empId;
	}
	public PeriodVO getPeriod() {
		return period;
	}
	public void setPeriod(PeriodVO period) {
		this.period = period;
	}

	public LongLeaveRequestDetails(String dateToGo, String returnDate, String bacupP, String comment,
			LeaveCategoryVO leaveCateg, EmployeeVO empId, PeriodVO period) {
		this.dateToGo = dateToGo;
		this.returnDate = returnDate;
		this.bacupP = bacupP;
		this.comment = comment;
		this.leaveCateg = leaveCateg;
		this.empId = empId;
		this.period = period;
	}
	public LongLeaveRequestDetails() {
	}
	
	
	
}
