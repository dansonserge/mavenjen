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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@Table(name="department")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DepartmentVO{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="departmentId")
	private long departmentId;
	
	@Column(name="departmentName")
	private String departmentName;


	@Column(name="departmentAbrev")
	private String departmentAbrev;

	
	
	@OneToMany(cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY,
            mappedBy = "departmentVO")
	@JsonIgnore
	private Set<EmployeeVO> employeeVO = new HashSet<>();

	


	public long getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}




	public String getDepartmentName() {
		return departmentName;
	}




	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}




	public String getDepartmentAbrev() {
		return departmentAbrev;
	}




	public void setDepartmentAbrev(String departmentAbrev) {
		this.departmentAbrev = departmentAbrev;
	}




	public Set<EmployeeVO> getEmployeeVO() {
		return employeeVO;
	}




	public void setEmployeeVO(Set<EmployeeVO> employeeVO) {
		this.employeeVO = employeeVO;
	}

	


	public DepartmentVO(long departmentId, String departmentName, String departmentAbrev, Set<EmployeeVO> employeeVO) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAbrev = departmentAbrev;
		this.employeeVO = employeeVO;
	}




	public DepartmentVO() {
		super();
	}
	
	
}
