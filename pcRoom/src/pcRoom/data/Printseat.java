package pcRoom.data;


import java.util.ArrayList;
import pcRoom.Controller.KioskUserController;
import pcRoom.Model.DTO.currentPcDTO;

public class Printseat implements Runnable{
	
	KioskUserController con = new KioskUserController();
	
	
	private boolean state = true;	// 일시정지를 위한 변수 선언
	
	@Override
	public void run() {
		while(true) {
			if(state) {
				System.out.println("1. 요금 충전\n");
				ArrayList<currentPcDTO> list = new ArrayList<>();
				list = con.printSeat();	// controller의 printSeat메소드 호출해서 list에 저장
				int count=0;	// 줄바꿈을 위한 변수 선언
				for( currentPcDTO tmp : list) {	// 향상된 for문을 이용한 데이터 출력
					count++; // list의 데이터를 하나씩 꺼낼때마다 count증가
					if(tmp.iscPlay()) {System.out.print("[X]");}
					// tmp의 getter메소드에서 return된 값이 true(PC가 사용중)이면 [X] 출력
					else {System.out.print("[ ]");}
					// false 이면 [ ] 출력
					if(count%5==0) {System.out.println("");}
					// 출력 횟수가 5의 배수이면 줄바꿈
				}
				for(int i = 0 ; i<10 ; i++) {
					System.out.println("");
					// 줄 맞춤 공백 출력
				}
			}
			try {Thread.sleep(1000);} // 스레드를 1초씩 일시정지
			catch (Exception e) {System.out.println("thread오류"+e);}
		}
	}
	//메소드
	public boolean isState() {	//getter
		return state;
	}
	public void setState(boolean state) { //setter
		this.state = state;
	}
}

