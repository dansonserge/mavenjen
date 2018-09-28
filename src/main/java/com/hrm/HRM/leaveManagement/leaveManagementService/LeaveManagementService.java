package com.hrm.HRM.leaveManagement.leaveManagementService;

import java.util.List;

import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveCategoryVO;
import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveRequestVO;

public interface LeaveManagementService {

	//LEAVE MANAGEMENT INTERFACES
			public void createLeave(LeaveRequestVO leaveRequestVO) throws Exception;
			public LeaveRequestVO addLeave(LeaveRequestVO leaveRequestVO) throws Exception;
			public void deleteLeave(LeaveRequestVO leaveRequestVO) throws Exception;
			public void updateLeave(LeaveRequestVO leaveRequestVO) throws Exception;
			public List<LeaveRequestVO> getAllLeaveList() throws Exception;
			//LEAVE CATEGORY INTERFACES
			public List<LeaveCategoryVO> listCategoryList() throws Exception;
}
