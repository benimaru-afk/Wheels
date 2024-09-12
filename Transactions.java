package pack1;

import java.util.ArrayList;

public class Transactions {
	private ArrayList<Transaction> Transactions = new ArrayList<>();

	public ArrayList<Transaction> searchTransactionsBike(int bikenum) {
		ArrayList<Transaction> output = new ArrayList<>();
		for (Transaction t : Transactions) {
			if (t.getBikeNumber() == bikenum) {
				output.add(t);
			}
		}
		return output;
	}

	public ArrayList<Transaction> searchTransactionsCustomer(String name) {
		ArrayList<Transaction> output = new ArrayList<>();
		for (Transaction t : Transactions) {
			if (t.getCustomer().equals(name)) {
				output.add(t);
			}
		}
		return output;
	}

	public void addTransaction(Transaction newTransaction) {
		if (!searchTransactionsBike(newTransaction.getBikeNumber()).isEmpty()) {
			return;
		}
		Transactions.add(newTransaction);
	}

	public void removeTransaction(Transaction deleteTransaction) {
		Transactions.remove(deleteTransaction);
	}
	
	public void printTransactions(){
		for (Transaction t : Transactions){
			System.out.println(t);
		}
	}
}