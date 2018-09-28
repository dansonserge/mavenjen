package com.hrm.HRM.userManagement.userManagementVO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="education")
public class EducationVO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="educationId")
	private long educationId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private EmployeeVO employeeVO;
 
}
