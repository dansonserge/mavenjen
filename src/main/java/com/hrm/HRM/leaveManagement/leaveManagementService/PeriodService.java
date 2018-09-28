package com.hrm.HRM.leaveManagement.leaveManagementService;


import java.util.List;
import com.hrm.HRM.leaveManagement.leaveManagementVO.PeriodVO;


public interface PeriodService {
	
	public PeriodVO getPeriodByStatus(String status) throws Exception;
	public List<PeriodVO> listPeriodList() throws Exception;
}
