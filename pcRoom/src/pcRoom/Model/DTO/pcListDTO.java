package pcRoom.Model.DTO;

public class pcListDTO {
	
	private int pcNo;
	private boolean cPlay;
	private int memNo;
	private String sTime;
	private String eTtime;
	
	public pcListDTO() {
		super();
	}

	public pcListDTO(int pcNo, boolean cPlay, int memNo, String sTime, String eTtime) {
		super();
		this.pcNo = pcNo;
		this.cPlay = cPlay;
		this.memNo = memNo;
		this.sTime = sTime;
		this.eTtime = eTtime;
	}

	public int getPcNo() {
		return pcNo;
	}

	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
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

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTtime() {
		return eTtime;
	}

	public void seteTtime(String eTtime) {
		this.eTtime = eTtime;
	}
	
	
	
}
