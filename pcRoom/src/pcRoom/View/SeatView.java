package pcRoom.View;

import java.util.Scanner;
import pcRoom.Controller.SeatController;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.data.SeatTimer;

public class SeatView {

	int SeatNo = 7;	//좌석 번호
	int mNo = 0; // 비로그인 0 / 로그인 memNo
	Scanner scanner = new Scanner(System.in);

	SeatController sCon = new SeatController();	//seatController 객체
	membersDTO dto;
	
	public static void main(String[] args) {	// 실행
		Scanner scanner = new Scanner(System.in);
		SeatView sv = new SeatView();
		SeatTimer st = new SeatTimer();
		Thread thread = new Thread(st);
		while(true) {
			if(sv.mNo==0) {
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
				}else if(ch==2){
					boolean result = false;
					result = sv.login();
					if(result) {
						System.out.println("로그인 성공");
						sv.printTime(sv.SeatNo, sv.mNo);
						st.setMemNo(sv.dto.getMemNo());
						st.setMemID(sv.dto.getMemID());
						st.setMemTime(sv.dto.getMemTime());						
						thread.start();
					}else {
						System.err.println("로그인 실패!!!");
					}
				}
			}else if(sv.mNo>0){
				System.out.println("게임목록");
				System.out.println("1.구구단 2.가위바위보 0.사용종료");
				int selGame = scanner.nextInt();
				if(selGame == 0) {
					sv.mNo = 0;
					st.setLogOut(false);
					sv.saveLogout(sv.SeatNo);
					thread = new Thread();
					System.out.println("로그아웃 완료");
				}
			}
		}
	}
	// 로그인
	boolean login() {
		System.out.println("ID : ");
		String ID = scanner.next();
		System.out.println("PW : ");

		String PW = scanner.next();
		int result = sCon.login(ID, PW);
		if(result>0) {
			this.mNo = result;
			return true;
		}else {
			return false;
		}
	}
	
	//회원가입
	boolean singUp(String memID,String memPW,String memPhone) {
		return sCon.singUp(memID, memPW, memPhone);
	}
	
	//시간 출력 thread에 정보 전달
	void printTime(int SeatNo, int mNo) {
		dto= sCon.printTime(SeatNo, mNo);
	}
	
	// 사용종료 / 로그아웃 시 db에 종료 시간 저장 
	void saveLogout(int SeatNo) {
		sCon.saveLogout(SeatNo);
	}
}