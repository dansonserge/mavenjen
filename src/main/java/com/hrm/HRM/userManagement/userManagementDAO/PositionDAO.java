package com.hrm.HRM.userManagement.userManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.userManagement.userManagementVO.PositionVO;

@Repository("PositionDAO")
public interface PositionDAO extends CrudRepository<PositionVO, Long> {

}
