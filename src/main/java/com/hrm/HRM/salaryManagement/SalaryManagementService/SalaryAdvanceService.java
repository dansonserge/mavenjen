package com.hrm.HRM.salaryManagement.SalaryManagementService;

import java.util.List;

import com.hrm.HRM.salaryManagement.SalaryManagementVO.SalaryAdvanceVO;

public interface SalaryAdvanceService {
	
	
	//Salary Advance 
	public SalaryAdvanceVO createSalaryAdvance(SalaryAdvanceVO salaryAdvanceVO) throws Exception;
	public List<SalaryAdvanceVO> getSalaryAdvance() throws Exception;
	public String deleteSalaryAdvance(SalaryAdvanceVO salaryAdavnceVO) throws Exception;
	public SalaryAdvanceVO updateSalaryAdvance(SalaryAdvanceVO salaryAdvanceVO) throws Exception;
	public SalaryAdvanceVO getSalaryAdvanceById(Long id) throws Exception;
}
