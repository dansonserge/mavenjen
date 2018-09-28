package com.hrm.HRM.userManagement.userManagementService.userManagementServiceImpl;

import static org.mockito.Matchers.anyBoolean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.HRM.userManagement.userManagementDAO.ContractDAO;
import com.hrm.HRM.userManagement.userManagementDAO.ContractManagementDAO;
import com.hrm.HRM.userManagement.userManagementDAO.ContractTypeDAO;
import com.hrm.HRM.userManagement.userManagementDAO.DepartmentDAO;
import com.hrm.HRM.userManagement.userManagementDAO.PositionDAO;
import com.hrm.HRM.userManagement.userManagementDAO.UserManagementDAO;
import com.hrm.HRM.userManagement.userManagementService.UserManagementService;
import com.hrm.HRM.userManagement.userManagementVO.ContractTypeVO;
import com.hrm.HRM.userManagement.userManagementVO.ContractVO;
import com.hrm.HRM.userManagement.userManagementVO.DepartmentVO;
import com.hrm.HRM.userManagement.userManagementVO.EmployeeVO;
import com.hrm.HRM.userManagement.userManagementVO.PositionVO;

@Service("userManagementService")
public class UserMamagementServiceImpl implements UserManagementService{
	
	@Autowired
	UserManagementDAO userManagementDAO;
	@Autowired
	ContractManagementDAO contractManagementDAO;
	@Autowired
	ContractTypeDAO contractTypeDAO;
	@Autowired
	DepartmentDAO departmentDAO;
	@Autowired
	PositionDAO positionDAO;
	@Autowired
	ContractDAO contractDAO;
	
	@Override
	public void createEmployee(EmployeeVO employeeVO) {
		//create a new employee record in DB
		userManagementDAO.save(employeeVO);
	}

	@Override
	public EmployeeVO addEmployee(EmployeeVO employeeVO) {
		//create a new employee record in DB with return
		EmployeeVO employee = userManagementDAO.save(employeeVO);
		return employee;
	}

	@Override
	public void deleteEmployee(EmployeeVO employeeVO) {
		userManagementDAO.delete(employeeVO);
		
	}

	@Override
	public void updateEmployee(EmployeeVO employeeVO) {
		userManagementDAO.save(employeeVO);	
	}

	@Override
	public void deleteBulkOfEmployee(long[] employeeId) {
		 
		for(int i=0; i < employeeId.length; i++){
			
			EmployeeVO employee = userManagementDAO.findOne(employeeId[i]);
			employee.setEnabled(false);
			userManagementDAO.save(employee);
		}	
	}

	@Override
	public void createContract(ContractVO contractVO) throws Exception {
		contractManagementDAO.save(contractVO);
	}

	@Override
	public ContractVO addContract(ContractVO contractVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContract(ContractVO contractVO) throws Exception {
		contractManagementDAO.delete(contractVO);
		
	}

	@Override
	public void updateContract(ContractVO contractVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeVO getEmployeeByEmail(String email) throws Exception {
		EmployeeVO employee = userManagementDAO.findEmployeeVOByContactEmail(email);
		return employee;
	}

	@Override
	public List<ContractTypeVO> getAllContractTypeList() throws Exception { 
		List<ContractTypeVO> contratTypeList= (List<ContractTypeVO>) contractTypeDAO.findAll(); 
		return contratTypeList; 
	}

	@Override
	public List<DepartmentVO> getAllDepartmentList() throws Exception { 
		List<DepartmentVO> departmentList =(List<DepartmentVO>) departmentDAO.findAll(); 
		return departmentList ; 
	}

    @Override
    public List<EmployeeVO> getAllEmployeeList() throws Exception {
        List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
        employeeList = (List<EmployeeVO>) userManagementDAO.findAll();
        return employeeList;
    }

	@Override
	public ContractTypeVO getContractTypeById(long id) throws Exception {
		return contractTypeDAO.findOne(id);
	}

	@Override
	public DepartmentVO getDepartmentById(long id) throws Exception {
		return departmentDAO.findOne(id);
	}

	@Override
	public List<PositionVO> getAllPositionList() throws Exception {
		List<PositionVO> positionList = new ArrayList<PositionVO>();
		positionList = (List<PositionVO>) positionDAO.findAll();
        return positionList;
	}

	@Override
	public PositionVO getPositionById(long id) throws Exception {
		return positionDAO.findOne(id);
	}

	@Override
	public EmployeeVO getEmployeeById(long id) throws Exception {
		return userManagementDAO.findOne(id);
	}

	@Override
	public ContractVO findEmployeeActiveContract(EmployeeVO employeeVO) throws Exception {
		List<ContractVO> contracts = contractDAO.findContractByEmployeeVO(employeeVO);
		ContractVO active_contract = new ContractVO();
		for(ContractVO a: contracts) {
			if(a.getStatus().equals("ACTIVE")) {
				active_contract = a;
			}	
		}	
		return active_contract;
	}	
}
