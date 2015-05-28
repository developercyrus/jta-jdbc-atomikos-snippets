package javaee.jta.jdbc.atomikos.example1;

import javaee.jta.jdbc.atomikos.example1.impl.AccountRepository;

public interface Bank {
	public AccountRepository getAccounts(Client client);
}
