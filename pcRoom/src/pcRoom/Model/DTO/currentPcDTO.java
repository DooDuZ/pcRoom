package pcRoom.Model.DTO;

public class currentPcDTO {
	int poNo;
	boolean cPlay;

	
	public currentPcDTO() {}

	public currentPcDTO(int poNo, boolean cPlay) {
		super();
		this.poNo = poNo;
		this.cPlay = cPlay;

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

		
}

