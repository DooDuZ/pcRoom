package pcRoom.Model.DTO;

public class currentPcDTO {
	int poNo;
	boolean cPlay;
	int memNo;
	String sTIME;
	
	public currentPcDTO() {}

	public currentPcDTO(int poNo, boolean cPlay, int memNo, String sTIME) {
		super();
		this.poNo = poNo;
		this.cPlay = cPlay;
		this.memNo = memNo;
		this.sTIME = sTIME;
	}

	public int getPoNo() {
		return poNo;
	}

	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}

	public boolean iscPlay() {
		return cPlay;
	}

	public void setcPlay(boolean cPlay) {
		this.cPlay = cPlay;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getsTIME() {
		return sTIME;
	}

	public void setsTIME(String sTIME) {
		this.sTIME = sTIME;
	}
		
}

