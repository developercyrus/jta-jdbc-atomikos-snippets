package javaee.jta.jdbc.atomikos.example1.impl;

import java.util.HashMap;
import java.util.Map;

import javaee.jta.jdbc.atomikos.example1.Account;
import javaee.jta.jdbc.atomikos.example1.Bank;
import javaee.jta.jdbc.atomikos.example1.Client;

public class HSBCBank implements Bank {
	Map<Integer, AccountRepository> m = new HashMap<Integer, AccountRepository>();
	
	public HSBCBank() {
		Client john = new BasicClient(1);
		Account savingAccount = new SavingAccount(1);
		Account currentAccount = new CurrentAccount(1);
		AccountRepository ar = new AccountRepository();
		ar.setSavingAccount(savingAccount);
		ar.setCurrentAccount(currentAccount);
		
		m.put(john.getId(), ar);
	}

	@Override
	public AccountRepository getAccounts(Client client) {
		return m.get(client.getId());
	}
}
