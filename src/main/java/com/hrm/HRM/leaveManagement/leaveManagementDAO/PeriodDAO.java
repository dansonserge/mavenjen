package com.hrm.HRM.leaveManagement.leaveManagementDAO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.leaveManagement.leaveManagementVO.PeriodVO;

@Repository("PeriodDAO")
public interface PeriodDAO  extends CrudRepository<PeriodVO, Long> {
	
	public PeriodVO getPeriodByStatus(String status);

}











