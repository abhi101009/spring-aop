package com.aminfo.aop.aspect.model;

public class Account {

	private Integer accountNo;
	private String holdenName;
	private Boolean enabled;
	
	public Account(Integer accno, String name, Boolean enable) {
		this.accountNo = accno;
		this.holdenName = name;
		this.enabled = enable;
	}
	
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getHoldenName() {
		return holdenName;
	}
	public void setHoldenName(String holdenName) {
		this.holdenName = holdenName;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", holdenName=" + holdenName + ", enabled=" + enabled + "]";
	}
	
}
