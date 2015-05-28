package javaee.jta.jdbc.atomikos.example1;

public interface Account {
	public void withdraw(int amount) throws Exception;
	public void deposit(int amount) throws Exception;
	public int getBalance() throws Exception;
}
