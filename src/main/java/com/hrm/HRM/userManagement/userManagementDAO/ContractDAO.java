package com.hrm.HRM.userManagement.userManagementDAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.userManagement.userManagementVO.ContractVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;

@Repository("ContractDAO")
public interface ContractDAO extends CrudRepository<ContractVO, Long> {
	List<ContractVO> findContractByEmployeeVO(EmployeeVO employeeVO);
	
}
