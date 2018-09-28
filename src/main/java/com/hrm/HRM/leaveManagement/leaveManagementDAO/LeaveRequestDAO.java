package com.hrm.HRM.leaveManagement.leaveManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveRequestVO;

@Repository("LeaveRequestDAO")
public interface LeaveRequestDAO  extends CrudRepository<LeaveRequestVO, Long>{

}
