package com.hrm.HRM.userManagement.userManagementService;

import java.util.List;

import com.hrm.HRM.userManagement.userManagementVO.ContractTypeVO;
import com.hrm.HRM.userManagement.userManagementVO.ContractVO;
import com.hrm.HRM.userManagement.userManagementVO.DepartmentVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;
import com.hrm.HRM.userManagement.userManagementVO.PositionVO;

public interface UserManagementService {
	
	//user management interfaces
	public void createEmployee(EmployeeVO employeeVO) throws Exception;
	public EmployeeVO addEmployee(EmployeeVO employeeVO) throws Exception;
	public void deleteEmployee(EmployeeVO employeeVO) throws Exception;
	public void updateEmployee(EmployeeVO employeeVO) throws Exception;
	public void deleteBulkOfEmployee(long[] employeeId) throws Exception;
	public EmployeeVO getEmployeeByEmail(String email) throws Exception;
	public List<EmployeeVO> getAllEmployeeList() throws Exception;
	public EmployeeVO getEmployeeById(long id) throws Exception;
	
	//contract management interfaces
	public void createContract(ContractVO contractVO) throws Exception;
	public ContractVO addContract(ContractVO contractVO) throws Exception;
	public void deleteContract(ContractVO contractVO) throws Exception;
	public void updateContract(ContractVO contractVO) throws Exception;
	public List<ContractTypeVO> getAllContractTypeList() throws Exception;
	public ContractTypeVO getContractTypeById(long id) throws Exception;
	public ContractVO findEmployeeActiveContract(EmployeeVO employeeVO) throws Exception;
	
	//Department management interfaces
	public List<DepartmentVO> getAllDepartmentList() throws Exception;
	public DepartmentVO getDepartmentById(long id) throws Exception;
	
	//Position management interfaces
	public List<PositionVO> getAllPositionList() throws Exception;
	public PositionVO getPositionById(long id) throws Exception;
}
