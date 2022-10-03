package pcRoom.Model.DTO;

public class PcRecord {
	
	private int pcNo;
	private String sTime;
	private String eTtime;
	private int memNo;
	private String memID;
	
	public PcRecord() {
		super();
	}

	public PcRecord(int pcNo, String sTime, String eTtime, int memNo, String memID) {
		super();
		this.pcNo = pcNo;
		this.sTime = sTime;
		this.eTtime = eTtime;
		this.memNo = memNo;
		this.memID = memID;
	}

	public int getPcNo() {
		return pcNo;
	}

	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
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
	public String getmemID() {
		return memID;
	}

	public void setmemID(String memID) {
		this.memID = memID;
	}	
}
