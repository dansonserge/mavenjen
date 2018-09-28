package com.hrm.HRM.leaveManagement.leaveManagementService.leaveManagementServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.HRM.leaveManagement.leaveManagementDAO.PeriodDAO;
import com.hrm.HRM.leaveManagement.leaveManagementService.PeriodService;
import com.hrm.HRM.leaveManagement.leaveManagementVO.PeriodVO;

@Service("PeriodServiceImpl")
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	PeriodDAO periodDAO;
	
	@Override
	public PeriodVO getPeriodByStatus(String status) throws Exception {
		PeriodVO periodStatus = periodDAO.getPeriodByStatus(status);
		return periodStatus;
	}

	@Override
	public List<PeriodVO> listPeriodList() throws Exception {
		List<PeriodVO> listPeriod = new ArrayList<PeriodVO>();
		listPeriod = (List<PeriodVO>) periodDAO.findAll();
		return listPeriod;
	}

}
