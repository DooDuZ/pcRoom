package pcRoom.Model.DTO;

public class currentPcDTO {
	int pcNo;
	boolean cPlay;

	
	public currentPcDTO() {}

	public currentPcDTO(int pcNo, boolean cPlay) {
		super();
		this.pcNo = pcNo;
		this.cPlay = cPlay;

	}

	public int getPcNo() {
		return pcNo;
	}

	public void setPoNo(int pcNo) {
		this.pcNo = pcNo;
	}

	public boolean iscPlay() {
		return cPlay;
	}

	public void setcPlay(boolean cPlay) {
		this.cPlay = cPlay;
	}

		
}

