package javaee.jta.jdbc.atkmikos.example1.client;

import javaee.jta.jdbc.atomikos.example1.Account;
import javaee.jta.jdbc.atomikos.example1.Bank;
import javaee.jta.jdbc.atomikos.example1.Client;
import javaee.jta.jdbc.atomikos.example1.Transaction;
import javaee.jta.jdbc.atomikos.example1.impl.AccountRepository;
import javaee.jta.jdbc.atomikos.example1.impl.BasicClient;
import javaee.jta.jdbc.atomikos.example1.impl.HSBCBank;
import javaee.jta.jdbc.atomikos.example1.impl.LocalTransaction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppIT {		
	@Test
    public void test1() throws Exception {
		Client john = new BasicClient(1);
		Bank hsbc = new HSBCBank();		
		AccountRepository ar = hsbc.getAccounts(john);
		Transaction t = new LocalTransaction();
		Account savingAccount = ar.getSavingAccount();
		Account currentAccount = ar.getCurrentAccount();
		t.setWithdrawal(savingAccount);
		t.setDeposit(currentAccount);
		
		int savingBalance = savingAccount.getBalance();
		int currentBalance = currentAccount.getBalance();
		
		t.transferWithError(500);
		System.out.println("saving: " + savingAccount.getBalance());
		System.out.println("current: " + currentAccount.getBalance());
		assertEquals(currentBalance-savingBalance, currentAccount.getBalance()-savingAccount.getBalance());
		
		t.transfer(500);
		System.out.println("saving: " + savingAccount.getBalance());
		System.out.println("current: " + currentAccount.getBalance());
		assertEquals((currentBalance+500)-(savingBalance-500), currentAccount.getBalance()-savingAccount.getBalance());		
    }
}