package com.hrm.HRM.userManagement.userManagementVO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@Table(name="employees")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeeId")
	private long employeeId;
	
	@Column(name="firstName")
	private String fistName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="mstatus")
	private String mstatus;
	
	@Column(name="contactEmail")
	private String contactEmail;
	
	@Column(name="contactPhone")
	private String contactPhone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="nid")
	private String nid;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="createdDate")
	private String createdDate;
	
	@Column(name="modifiedDate")
	private String modifiedDate;

	@Column(name="avatarAttachFileName")
	private String avatarAttachFileName;
	
	@Column(name="avatarAttachFilePath")
	private String avatarAttachFilePath;
	
	@Column(name="avatarAttachFileSize")
	private String avatarAttachFileSize;

	@Column(name="signatureAttachFileName")
	private String signatureAttachFileName;
	
	@Column(name="signatureAttachFileSize")
	private String signatureAttachFileSize;
	
	@Column(name="signatureAttachFilePath")
	private String signatureAttachFilePath;
	
	@Column(name = "Encryted_Password", length = 128, nullable = false)
	private String encrytedPassword;

	@Column(name = "Enabled", length = 1)
    private boolean enabled;
	
	@Column(name="employeeCode")
	private String employeeCode;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
	@JsonManagedReference
    private DepartmentVO departmentVO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionId")
	@JsonManagedReference
	private PositionVO positionVO;
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAvatarAttachFileName() {
		return avatarAttachFileName;
	}

	public void setAvatarAttachFileName(String avatarAttachFileName) {
		this.avatarAttachFileName = avatarAttachFileName;
	}

	public String getAvatarAttachFilePath() {
		return avatarAttachFilePath;
	}

	public void setAvatarAttachFilePath(String avatarAttachFilePath) {
		this.avatarAttachFilePath = avatarAttachFilePath;
	}

	public String getAvatarAttachFileSize() {
		return avatarAttachFileSize;
	}

	public void setAvatarAttachFileSize(String avatarAttachFileSize) {
		this.avatarAttachFileSize = avatarAttachFileSize;
	}

	public String getSignatureAttachFileName() {
		return signatureAttachFileName;
	}

	public void setSignatureAttachFileName(String signatureAttachFileName) {
		this.signatureAttachFileName = signatureAttachFileName;
	}

	public String getSignatureAttachFileSize() {
		return signatureAttachFileSize;
	}

	public void setSignatureAttachFileSize(String signatureAttachFileSize) {
		this.signatureAttachFileSize = signatureAttachFileSize;
	}

	public String getSignatureAttachFilePath() {
		return signatureAttachFilePath;
	}

	public void setSignatureAttachFilePath(String signatureAttachFilePath) {
		this.signatureAttachFilePath = signatureAttachFilePath;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public PositionVO getPositionVO() {
		return positionVO;
	}

	public void setPositionVO(PositionVO positionVO) {
		this.positionVO = positionVO;
	}

	public EmployeeVO(long employeeId, String fistName, String middleName, String lastName, String dob, String mstatus,
			String contactEmail, String contactPhone, String address, String nid, String nationality,
			String createdDate, String modifiedDate, String avatarAttachFileName, String avatarAttachFilePath,
			String avatarAttachFileSize, String signatureAttachFileName, String signatureAttachFileSize,
			String signatureAttachFilePath, String encrytedPassword, boolean enabled, String employeeCode,
			DepartmentVO departmentVO, PositionVO positionVO) {
		this.employeeId = employeeId;
		this.fistName = fistName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.mstatus = mstatus;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.address = address;
		this.nid = nid;
		this.nationality = nationality;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.avatarAttachFileName = avatarAttachFileName;
		this.avatarAttachFilePath = avatarAttachFilePath;
		this.avatarAttachFileSize = avatarAttachFileSize;
		this.signatureAttachFileName = signatureAttachFileName;
		this.signatureAttachFileSize = signatureAttachFileSize;
		this.signatureAttachFilePath = signatureAttachFilePath;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.employeeCode = employeeCode;
		this.departmentVO = departmentVO;
		this.positionVO = positionVO;
	}

	public EmployeeVO() {
		super();
	}
	
}
