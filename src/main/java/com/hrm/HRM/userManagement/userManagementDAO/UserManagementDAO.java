package com.hrm.HRM.userManagement.userManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Repository("UserManagementDAO")
public interface UserManagementDAO extends CrudRepository<EmployeeVO, Long>  {
	//get user information by email
	public EmployeeVO findEmployeeVOByContactEmail(String email);
}
