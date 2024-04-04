package com.codingdojo.bankaccount;
import java.util.Random;

public class BankAccount {
	private int numCuenta;
	private double saldoCuentaCorr;
	private double saldoCuentaSavings;
	
	protected static int numeroDeCuentas = 0;
	public static double totalMoney = 0;
	
	public BankAccount(){
		this.saldoCuentaCorr = 0;
		this.saldoCuentaSavings = 0;
		this.numCuenta = numAleatorio();
		numeroDeCuentas++;
	}

	public double getSaldoCuentaCorr() {
		System.out.println(this.saldoCuentaCorr);
		return saldoCuentaCorr;
	}

	public void setSaldoCuentaCorr(double saldoCuentaCorr) {
		this.saldoCuentaCorr = saldoCuentaCorr;
	}

	public double getSaldoCuentaSavings() {
		System.out.println(this.saldoCuentaSavings);
		return saldoCuentaSavings;
	}

	public void setSaldoCuentaSavings(double saldoCuentaSavings) {
		this.saldoCuentaSavings = saldoCuentaSavings;
	}
	
	public void deposit(double amount, String account) {
		if(account.equals("savings")) {
			this.saldoCuentaSavings += amount;
			BankAccount.totalMoney += amount;
		}
			
		else if(account.equals("checking")){
			this.saldoCuentaCorr += amount;
			BankAccount.totalMoney += amount;
		}
		else {
			System.out.println("Esa cuenta no existe ");
		}
	}
	
	public void withdraw(double amount, String account) {
		boolean available = false;
		
		if(account.equals("savings")) {
			if(this.saldoCuentaSavings - amount >= 0) {
				available = true;
				this.saldoCuentaSavings -= amount;
			}
		}
		
		else if(account.equals("checking")) {
			if(this.saldoCuentaCorr - amount >= 0) {
				available = true;
				this.saldoCuentaCorr -= amount;
		}
	}
		if(available) {
			BankAccount.totalMoney -= amount;
		}
		else {
			System.out.println("Esa cuenta no existe o no hay suficiente dinero");
		}
}
	public void displayBalance() {
		System.out.println("Account " + this.numCuenta);
		System.out.println("Saving account: " + this.saldoCuentaSavings);
		System.out.println("Checking account: " + this.saldoCuentaCorr);
		System.out.println("Total amount: " + (this.saldoCuentaSavings + this.saldoCuentaCorr));
	}
	
	private int numAleatorio() {
		Random numRandom = new Random(System.currentTimeMillis());
		
		return ((1 + numRandom.nextInt(2))* 100000000 + numRandom.nextInt(100000000));
		
	}
	
}
