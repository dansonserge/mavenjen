package com.hrm.HRM.leaveManagement.leaveManagementVO;

import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

public class ShortLeaveRequestDetails {

	    private String dateToGo;
	    private String hourToGo;
	    private Long hoursTaken;
	    private String bacupP;
	    private String reason;
	    private EmployeeVO empId;
	    private PeriodVO period;
		public String getDateToGo() {
			return dateToGo;
		}
		public void setDateToGo(String dateToGo) {
			this.dateToGo = dateToGo;
		}
		public String getHourToGo() {
			return hourToGo;
		}
		public void setHourToGo(String hourToGo) {
			this.hourToGo = hourToGo;
		}

		public Long getHoursTaken() {
			return hoursTaken;
		}
		public void setHoursTaken(Long hoursTaken) {
			this.hoursTaken = hoursTaken;
		}
		public String getBacupP() {
			return bacupP;
		}
		public void setBacupP(String bacupP) {
			this.bacupP = bacupP;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
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
	
		public ShortLeaveRequestDetails(String dateToGo, String hourToGo, Long hoursTaken, String bacupP, String reason,
				EmployeeVO empId, PeriodVO period) {
			this.dateToGo = dateToGo;
			this.hourToGo = hourToGo;
			this.hoursTaken = hoursTaken;
			this.bacupP = bacupP;
			this.reason = reason;
			this.empId = empId;
			this.period = period;
		}
		public ShortLeaveRequestDetails() {
			super();
		}
	    
	    
}
