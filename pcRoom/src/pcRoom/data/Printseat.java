package pcRoom.data;


import java.util.ArrayList;
import pcRoom.Controller.KioskAdminController;
import pcRoom.Controller.KioskUserController;
import pcRoom.Model.DTO.currentPcDTO;

public class Printseat implements Runnable{
	KioskUserController con = new KioskUserController();
	KioskAdminController conAd = new KioskAdminController();
	private boolean state = true;
	
	@Override
	public void run() {		
		while(true) {
			if(state) {
				for(int i = 0 ; i<5 ; i++) {//윗 공백
					System.out.println("");
				} 
				System.out.println("1. 요금 충전\n");
				ArrayList<currentPcDTO> list = new ArrayList<>();//pc좌석 Array리스트 사용하여 담기 
				list = con.printSeat();// DB에서 가져온 정보 담기 
				int count=0;	
				for( currentPcDTO tmp : list) {
					count++;
					if(tmp.iscPlay()) {System.out.print("[X]");}
					else {System.out.print("[ ]");}
					if(count%5==0) {System.out.println("");}
				}
			}//state if E
			try {Thread.sleep(1000);} // 스레드 사용하여 1초에 한번씩 출력 
			catch (Exception e) {System.out.println("thread오류"+e);}
		}//while E
	}//run E

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	public boolean setState() {
		return state;
	}
}

