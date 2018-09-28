package com.hrm.HRM.leaveManagement.leaveManagementVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaveCategory")
public class LeaveCategoryVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leaveCategoryId")
	private long leaveCategoryId;
	
	@Column(name="categoryName")
	private String categoryName;

	public long getLeaveCategoryId() {
		return leaveCategoryId;
	}

	public void setLeaveCategoryId(long leaveCategoryId) {
		this.leaveCategoryId = leaveCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LeaveCategoryVO(long leaveCategoryId, String categoryName) {
		this.leaveCategoryId = leaveCategoryId;
		this.categoryName = categoryName;
	}

	public LeaveCategoryVO() {
		super();
	}

}
