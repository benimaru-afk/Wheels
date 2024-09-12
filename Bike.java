package pack1;

public class Bike {
	private int number;
	private String type;
	private String size;
	private String make;
	private String model;
	private double chargeRate;
	private double deposit;
	private String bikeStatus;
	private String extraDetails;

	public String getExtraDetails() {
		return extraDetails;
	}

	public void setExtraDetails(String extra_details) {
		this.extraDetails = extra_details;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getChargeRate() {
		return chargeRate;
	}

	public void setChargeRate(double charge_rate) {
		this.chargeRate = charge_rate;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public String getBikeStatus() {
		return bikeStatus;
	}

	public void setBikeStatus(String bikeStatus) {
		this.bikeStatus = bikeStatus;
	}

	public void print(){
		System.out.println("Bike #" + number + "\t Type: " + type + "\t Make: "+ make +"\tModel: "+ model);
		System.out.println("Charge Rate: $" + chargeRate + "\t Deposit: $" + deposit + "\t Status: "+ bikeStatus);
		System.out.println("Extra Details: "+ extraDetails);
	}
}
