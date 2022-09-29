package pcRoom.Model.DTO;

public class membersDTO {
	
	private int memNo;
	private String memID;
	private String memPW;
	private String memPhone; 
	private int memTime;  // 분단위 저장 및 호출. 출력시 시간단위 변환
	
	public membersDTO() {}

	public membersDTO(int memNo, String memID, String memPW, String memPhone, int memTime) {
		this.memNo = memNo;
		this.memID = memID;
		this.memPW = memPW;
		this.memPhone = memPhone;
		this.memTime = memTime;
	}

	public membersDTO(String memID, String memPW) {
		this.memID = memID;
		this.memPW = memPW;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getMemPW() {
		return memPW;
	}

	public void setMemPW(String memPW) {
		this.memPW = memPW;
	}
	
}
