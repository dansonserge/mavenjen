package com.hrm.HRM.userManagement.userManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.userManagement.userManagementVO.ContractVO;


@Repository("ContractManagementDAO")
public interface ContractManagementDAO extends CrudRepository<ContractVO, Long> {
   
}
