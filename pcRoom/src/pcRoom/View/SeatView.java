package pcRoom.View;

import java.util.Scanner;
import pcRoom.Controller.SeatController;

public class SeatView {
	
	Scanner input = new Scanner(System.in);
	SeatController sCon = new SeatController();
	
	public static void main(String[] args) {
		
		SeatView sv = new SeatView();		
		
		while(true) {
			System.out.println("=====바다이야기=====");
			boolean result = false;
			result = sv.login();
			
			if(result) {
				System.out.println("로그인 성공");
				System.out.println("===== 게임 목록 ======");
				System.out.println("");
				// 멤버들이 만든 미니게임 ex)구구단게임, 가위바위보 넣기
				
			}else {
				System.err.println("로그인 실패!!!");
			}
		}		
	}
	
	
	boolean login() {
		System.out.println("ID : ");
		String ID = input.next();
		System.out.println("PW : ");
		String PW = input.next();
		boolean result = sCon.login(ID, PW);
		if(result) {
			return true;
		}else {
			return false;
		}		
	}
	
	
	
	
}
