package com.hrm.HRM.salaryManagement.salaryManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hrm.HRM.salaryManagement.SalaryManagementVO.SalaryAdvanceApprovalVO;

@Repository("SalaryAdvanceApprovalsDAO")
public interface SalaryAdvanceApprovalsDAO extends  CrudRepository<SalaryAdvanceApprovalVO, Long> {
	
}
