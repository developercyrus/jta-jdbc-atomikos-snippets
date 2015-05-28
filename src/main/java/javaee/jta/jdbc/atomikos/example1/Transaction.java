package javaee.jta.jdbc.atomikos.example1;

public interface Transaction {
	public void setWithdrawal(Account account);
	public void setDeposit(Account account);
	public void transfer(int amount);
	public void transferWithError(int amount);
}
