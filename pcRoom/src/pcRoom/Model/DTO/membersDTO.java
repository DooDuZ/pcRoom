package pcRoom.Model.DTO;

public class membersDTO {
	
	private int memNo;
	private String memID;
	private String memName;
	private String memPW;
	private String memPhone; 
	private int memTime;  // 분단위 저장 및 호출. 출력시 시간단위 변환
	
	public membersDTO() {}

	public membersDTO(String memID) {
		super();
		this.memID = memID;
	}

	public membersDTO(int memNo, String memID, int memTime) {
		super();
		this.memNo = memNo;
		this.memID = memID;
		this.memTime = memTime;
	}




	public membersDTO(int memNo, String memID, String memName, String memPW) {
		super();
		this.memNo = memNo;
		this.memID = memID;
		this.memName = memName;
		this.memPW = memPW;
	}

	public membersDTO(int memNo, String memID, String memPW, String memName,String memPhone, int memTime) {
		this.memNo = memNo;
		this.memID = memID;
		this.memName = memName;
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
	
	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public int getMemTime() {
		return memTime;
	}

	public void setMemTime(int memTime) {
		this.memTime = memTime;
	}

}
