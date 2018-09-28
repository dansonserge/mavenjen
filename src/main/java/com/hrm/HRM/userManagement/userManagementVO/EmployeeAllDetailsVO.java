package com.hrm.HRM.userManagement.userManagementVO;

import org.springframework.web.multipart.MultipartFile;

//this object is used to collect and submit all 
//employee details from the form
public class EmployeeAllDetailsVO {
	
	//Employee personal information
	private String fname;
	private String mname;
	private String lname;
	private String dob;
	private String mstatus;
	private MultipartFile signature;
	
	//contact details
	
	private String emaddress;
	private String phone;
	private String location;
	private String nationality;
	private String nid;
	
	//Job details
	private String sartDate;
	private String endDate;
	private long department;
	private long ContractType;
	private String msalary;
	private long position;
	
	private MultipartFile cfile;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMstatus() {
		return mstatus;
	}

	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}

	public MultipartFile getSignature() {
		return signature;
	}

	public void setSignature(MultipartFile signature) {
		this.signature = signature;
	}

	public String getEmaddress() {
		return emaddress;
	}

	public void setEmaddress(String emaddress) {
		this.emaddress = emaddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getSartDate() {
		return sartDate;
	}

	public void setSartDate(String sartDate) {
		this.sartDate = sartDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getDepartment() {
		return department;
	}

	public void setDepartment(long department) {
		this.department = department;
	}

	public long getContractType() {
		return ContractType;
	}

	public void setContractType(long contractType) {
		ContractType = contractType;
	}

	public String getMsalary() {
		return msalary;
	}

	public void setMsalary(String msalary) {
		this.msalary = msalary;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public MultipartFile getCfile() {
		return cfile;
	}

	public void setCfile(MultipartFile cfile) {
		this.cfile = cfile;
	}

	public EmployeeAllDetailsVO(String fname, String mname, String lname, String dob, String mstatus,
			MultipartFile signature, String emaddress, String phone, String location, String nationality, String nid,
			String sartDate, String endDate, long department, long contractType, String msalary, long position,
			MultipartFile cfile) {
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.dob = dob;
		this.mstatus = mstatus;
		this.signature = signature;
		this.emaddress = emaddress;
		this.phone = phone;
		this.location = location;
		this.nationality = nationality;
		this.nid = nid;
		this.sartDate = sartDate;
		this.endDate = endDate;
		this.department = department;
		ContractType = contractType;
		this.msalary = msalary;
		this.position = position;
		this.cfile = cfile;
	}

	public EmployeeAllDetailsVO() {
	}

	
}
