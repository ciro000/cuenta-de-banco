package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount cuenta1 = new BankAccount();
		BankAccount cuenta2 = new BankAccount();

		cuenta1.deposit(100, "savings");
		cuenta1.displayBalance();
		
		cuenta2.deposit(150, "checking");
		
		System.out.println(BankAccount.totalMoney);
		
		cuenta1.withdraw(110, "checking");
	}

}
