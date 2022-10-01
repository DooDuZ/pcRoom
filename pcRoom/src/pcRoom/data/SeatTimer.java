package pcRoom.data;

import pcRoom.Controller.SeatController;

public class SeatTimer implements Runnable{
	
	int memNo;
	String memID;
	int memTime;
	
	@Override
	public void run() {
		while(true) {
			System.out.println("남은 시간 : " + memTime);
			memTime--;
			//setDB(memNo ,memTime);
			try {
				Thread.sleep(60000);
			} catch (Exception e) {
				System.out.println("시간출력 오류"+e);
			}
		}
	}	

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public int getMemTime() {
		return memTime;
	}

	public void setMemTime(int memTime) {
		this.memTime = memTime;
	}
	/*
	public void setDB(int memNo, int memTime) {
		sc.setDB(memNo, memTime);
	}
	*/
}
