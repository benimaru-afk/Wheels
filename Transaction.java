package pack1;

public class Transaction {
	private int bikeNumber;
	private double cost;
	private String customer;
	private java.time.LocalDate startDate;
	private java.time.LocalDate endDate;
	private boolean returned;

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public java.time.LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(java.time.LocalDate startDate) {
		this.startDate = startDate;
	}

	public java.time.LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(java.time.LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getBikeNumber() {
		return bikeNumber;
	}

	public void setBikeNumber(int number) {
		this.bikeNumber = number;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void print() {
		System.out.println("Bike #: "+ bikeNumber +"\t Customer: " + customer + "\t cost: $"+ cost + "\t");
		System.out.println("Start Date: "+ startDate.getYear()+"/"+ startDate.getMonthValue()+ "/" + startDate.getDayOfMonth() + "\t End Date: "+ endDate.getYear() +"/"+endDate.getMonthValue() +"/"+endDate.getDayOfMonth() + "Is returned: "+ returned);
	}
}