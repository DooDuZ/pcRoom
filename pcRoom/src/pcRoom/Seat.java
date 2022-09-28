package pcRoom;

import java.util.Scanner;

public class Seat implements Runnable{
Scanner sc = new Scanner(System.in);

@Override
	public void run() {
		boolean seat=false;
		while(true){
			System.out.println("1. 회원가입 2. 좌석선택 3. 로그인/로그아웃 4. 매출확인 5. 시간충전");
			for(int i =1;i<=50;i++) {
			System.out.print("["+i+"]\t");
				if(i%5==0) {
					System.out.println();
				}
			}try {
			System.out.println();Thread.sleep(3000);
			
			} catch (Exception e) {}
		}//while E
	}//run E
	
	public static void main(String[] args) {
		Seat seat = new Seat();
		seat.run();
	}
}//class E
