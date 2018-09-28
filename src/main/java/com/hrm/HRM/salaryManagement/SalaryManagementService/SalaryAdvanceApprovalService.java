package com.hrm.HRM.salaryManagement.SalaryManagementService;

import java.util.List;

import com.hrm.HRM.salaryManagement.SalaryManagementVO.SalaryAdvanceApprovalVO;
import com.hrm.HRM.salaryManagement.SalaryManagementVO.SalaryAdvanceVO;

public interface SalaryAdvanceApprovalService {
	public SalaryAdvanceApprovalVO createSalaryAdvanceApproval(SalaryAdvanceApprovalVO salaryAdvanceApprovalVO) throws Exception;
	
	//Get approvals by salary advance 
	public List<SalaryAdvanceApprovalVO> getSalaryAdvanceApprovalBySalaryAdvance(SalaryAdvanceVO salaryAdvance) throws Exception;
	public String deleteSalaryAdvanceApproval(SalaryAdvanceApprovalVO salaryAdavnceApprovalVO) throws Exception;
	public SalaryAdvanceApprovalVO updateSalaryAdvanceApproval(SalaryAdvanceApprovalVO salaryAdvanceVO) throws Exception;
	public SalaryAdvanceApprovalVO getSalaryAdvanceApprovalById(Long id) throws Exception;

}
