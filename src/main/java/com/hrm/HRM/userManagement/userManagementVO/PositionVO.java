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
@Table(name="position")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PositionVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="positionId")
	private long positionId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="abbreviation")
	private String abbreviation;
	
	@OneToMany(cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY,
            mappedBy = "positionVO")
	@JsonIgnore
	private Set<EmployeeVO> employeeVO = new HashSet<>();
	

	public Set<EmployeeVO> getEmployeeVO() {
		return employeeVO;
	}

	public void setEmployeeVO(Set<EmployeeVO> employeeVO) {
		this.employeeVO = employeeVO;
	}

	public long getPositionId() {
		return positionId;
	}

	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public PositionVO(long positionId, String description, String abbreviation, Set<EmployeeVO> employeeVO) {
		this.positionId = positionId;
		this.description = description;
		this.abbreviation = abbreviation;
		this.employeeVO = employeeVO;
	}

	public PositionVO() {
	}
	
	
}
