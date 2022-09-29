package pcRoom.Model.DTO;

public class priceDTO {
	
	private int priceNo;
	private int price;
	private int hours;
	
	public priceDTO() {}

	public priceDTO(int priceNo, int price, int hours) {
		this.priceNo = priceNo;
		this.price = price;
		this.hours = hours;
	}

	public int getPriceNo() {
		return priceNo;
	}

	public void setPriceNo(int priceNo) {
		this.priceNo = priceNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
	
	
}
