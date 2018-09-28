package com.hrm.HRM.userManagement.userManagementDAO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.userManagement.userManagementVO.DepartmentVO;


@Repository("DepartmentDAO")
public interface DepartmentDAO extends CrudRepository<DepartmentVO, Long> {
}
