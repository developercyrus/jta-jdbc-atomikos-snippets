package javaee.jta.jdbc.atomikos.example1.impl;

import javaee.jta.jdbc.atomikos.example1.Account;
import javaee.jta.jdbc.atomikos.example1.Transaction;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.atomikos.icatch.jta.UserTransactionImp;

public class LocalTransaction implements Transaction {
	private Account withdrawalAccount = null;
	private Account despoitAccount = null;
	
	@Override
	public void setWithdrawal(Account account) {
		this.withdrawalAccount = account;		
	}

	@Override
	public void setDeposit(Account account) {
		this.despoitAccount = account;		
	}
	
	@Override
	public void transfer(int amount) {		
		UserTransaction utx = new UserTransactionImp();
		try {
			utx.begin();			
			withdrawalAccount.withdraw(amount);
			despoitAccount.deposit(amount);
			utx.commit();
			System.out.println("commit success");
		} catch (Exception e) {			
			try {
				utx.rollback();
				System.out.println("rollbak success");
				e.printStackTrace();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}          
		} 
	}
	
	@Override
	public void transferWithError(int amount) {
		UserTransaction utx = new UserTransactionImp();
		try {
			utx.begin();			
			withdrawalAccount.withdraw(amount);
			//deliberately make error
			despoitAccount.deposit(Integer.parseInt("amount"));
			utx.commit();
			//suppose never reach here
			System.out.println("commit success");
		} catch (Exception e) {			
			try {
				utx.rollback();
				System.out.println("rollbak success");
				e.printStackTrace();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}				          
		} 	
	}
}
