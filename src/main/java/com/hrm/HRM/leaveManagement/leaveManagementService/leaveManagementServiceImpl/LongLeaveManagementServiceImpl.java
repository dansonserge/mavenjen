package com.hrm.HRM.leaveManagement.leaveManagementService.leaveManagementServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.HRM.leaveManagement.leaveManagementDAO.LeaveCategoryDAO;
import com.hrm.HRM.leaveManagement.leaveManagementDAO.LeaveRequestDAO;
import com.hrm.HRM.leaveManagement.leaveManagementService.LeaveManagementService;
import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveCategoryVO;
import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveRequestVO;

@Service("LeaveManagementService")
public class LongLeaveManagementServiceImpl implements LeaveManagementService{

	@Autowired
	LeaveRequestDAO leaveRequestDAO;
	@Autowired
	LeaveCategoryDAO leaveCategoryDAO;

	@Override
	public void createLeave(LeaveRequestVO leaveRequestVO) throws Exception {
		leaveRequestDAO.save(leaveRequestVO);
		
	}

	@Override
	public LeaveRequestVO addLeave(LeaveRequestVO leaveRequestVO) throws Exception {
		LeaveRequestVO addLeave=leaveRequestDAO.save(leaveRequestVO);
		return addLeave;
	}

	@Override
	public void deleteLeave(LeaveRequestVO leaveRequestVO) throws Exception {
		leaveRequestDAO.delete(leaveRequestVO);
		
	}

	@Override
	public void updateLeave(LeaveRequestVO leaveRequestVO) throws Exception {
		leaveRequestDAO.save(leaveRequestVO);
		
	}

	@Override
	public List<LeaveRequestVO> getAllLeaveList() throws Exception {
		List<LeaveRequestVO> listLeaveVO = new ArrayList<LeaveRequestVO>();
		listLeaveVO = (List<LeaveRequestVO>) leaveRequestDAO.findAll();
		return listLeaveVO;
	}
	
	@Override
	public List<LeaveCategoryVO> listCategoryList() throws Exception {
		List<LeaveCategoryVO> leaveCategoryList =(List<LeaveCategoryVO>) leaveCategoryDAO.findAll();
		return leaveCategoryList;
	}



}
