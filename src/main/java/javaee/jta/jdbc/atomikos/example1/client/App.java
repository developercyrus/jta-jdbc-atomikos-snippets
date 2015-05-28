package javaee.jta.jdbc.atomikos.example1.client;

import javaee.jta.jdbc.atomikos.example1.Bank;
import javaee.jta.jdbc.atomikos.example1.Client;
import javaee.jta.jdbc.atomikos.example1.Transaction;
import javaee.jta.jdbc.atomikos.example1.impl.AccountRepository;
import javaee.jta.jdbc.atomikos.example1.impl.BasicClient;
import javaee.jta.jdbc.atomikos.example1.impl.HSBCBank;
import javaee.jta.jdbc.atomikos.example1.impl.LocalTransaction;

public class App {
	public static void main(String[] args) {
		Bank hsbc = new HSBCBank();
		Client john = new BasicClient(1);
		AccountRepository accountRepository = hsbc.getAccounts(john);
		Transaction localTransaction = new LocalTransaction();
		localTransaction.setWithdrawal(accountRepository.getSavingAccount());
		localTransaction.setDeposit(accountRepository.getCurrentAccount());
		localTransaction.transfer(500);
	}
}
