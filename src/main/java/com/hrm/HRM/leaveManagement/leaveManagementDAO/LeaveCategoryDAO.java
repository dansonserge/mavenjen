package com.hrm.HRM.leaveManagement.leaveManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.leaveManagement.leaveManagementVO.LeaveCategoryVO;

@Repository("LeaveCategoryDAO")
public interface LeaveCategoryDAO extends CrudRepository<LeaveCategoryVO, Long> {

}
