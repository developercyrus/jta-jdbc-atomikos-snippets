package javaee.jta.jdbc.atomikos.example1.impl;

import javaee.jta.jdbc.atomikos.example1.Account;

public class AccountRepository {
	private Account savingAccount = null;
	private Account currentAccount = null;

	public Account getSavingAccount() {
		return savingAccount;
	}
	
	public void setSavingAccount(Account savingAccount) {
		this.savingAccount = savingAccount;
	}
	
	public Account getCurrentAccount() {
		return currentAccount;
	}
	
	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}
}
