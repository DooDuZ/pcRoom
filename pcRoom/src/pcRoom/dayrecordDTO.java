package pcRoom;

public class dayrecordDTO {
	   private int dNo;
	   private String dDate ;	    
	   private int dayIncome;

	   
	public dayrecordDTO() {}

	

	public dayrecordDTO(int dayIncome) {
		super();
		this.dayIncome = dayIncome;
	}



	public dayrecordDTO(String dDate, int dayIncome) {
		super();
		this.dDate = dDate;
		this.dayIncome = dayIncome;
	}



	public dayrecordDTO(int dNo, String dDate, int dayIncome) {
		this.dNo = dNo;
		this.dDate = dDate;
		this.dayIncome = dayIncome;
	}


	public int getdNo() {
		return dNo;
	}


	public void setdNo(int dNo) {
		this.dNo = dNo;
	}


	public String getdDate() {
		return dDate;
	}


	public void setdDate(String dDate) {
		this.dDate = dDate;
	}


	public int getDayIncome() {
		return dayIncome;
	}


	public void setDayIncome(int dayIncome) {
		this.dayIncome = dayIncome;
	}
	
	
	
	
	
	
	
}
