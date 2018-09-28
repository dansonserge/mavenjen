package com.hrm.HRM.userManagement.userManagementDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrm.HRM.userManagement.userManagementVO.ContractTypeVO;

@Repository("ContractTypeDAO")
public interface ContractTypeDAO  extends CrudRepository<ContractTypeVO, Long> {

}
