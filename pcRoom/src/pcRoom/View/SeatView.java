package pcRoom.View;

import java.util.Scanner;
import pcRoom.Controller.SeatController;

public class SeatView {
	
	Scanner scanner = new Scanner(System.in);
	SeatController sCon = new SeatController();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SeatView sv = new SeatView();
		
		while(true) {
			System.out.println("=====바다이야기=====");
			System.out.println("1.회원가입 2.로그인");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 회원가입_고은시
				System.out.println("아이디 : ");		String memID = scanner.next();
				System.out.println("비밀번호 : ");		String memPW = scanner.next();
				System.out.println("전화번호 : ");		String memPhone = scanner.next();
				if(sv.singUp(memID, memPW, memPhone) == true) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("이미 있는 회원입니다.");
				}				
			}else {			
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
	}	
	
	boolean login() {
		System.out.println("ID : ");
		String ID = scanner.next();
		System.out.println("PW : ");
		String PW = scanner.next();
		boolean result = sCon.login(ID, PW);
		if(result) {
			return true;
		}else {
			return false;
		}		
	}
	
	//회원가입
	boolean singUp(String memID,String memPW,String memPhone) {
		return sCon.singUp(memID, memPW, memPhone);
	}	
}