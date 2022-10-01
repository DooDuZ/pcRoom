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
					System.out.println("아이디 : ");
					String memID = null;
					for(int i = 1 ; i<=1 ; i++) {
						String ID = scanner.next();
						if(!sv.checkID(ID)) {
							System.out.println("영어 혹은 영어/숫자로 구성된 8~16글자 사이로 입력해주세요.");
							i--;
						}else {
							memID = ID;
						}
					}					
					System.out.println("비밀번호 : ");	
					String memPW = null;
					for(int i = 1 ; i<=1 ; i++) {
						String PW = scanner.next();
						if(!sv.checkPW(PW)) {
							System.out.println("[8-20자 이상]영어 대/소문자/특수문자/숫자를 포함하여 입력해주세요.");
							i--;
						}else {
							memPW = PW;
						}
					}
					
					System.out.println("이름 : ");
					String memName = scanner.next();
					
					System.out.println("전화번호 : ");	
					String memPhone = null;
					for(int i = 1 ; i<=1 ; i++) {
						String Phone = scanner.next();
						if(!sv.checkPhone(Phone)) {
							System.out.println("올바른 휴대폰 번호를 입력해 주세요.");
							i--;
						}else {
							memPhone = Phone;
						}
					}
					
					if(sv.singUp(memID, memPW, memName,memPhone) == true) {
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
	boolean singUp(String memID,String memPW, String memName,String memPhone) {
		return sCon.singUp(memID, memPW, memName,memPhone);
	}
	
	//ID,PW,PhoneNumber 유효성검사
	public boolean checkID(String ID) {
		return sCon.checkID(ID);
	}
	public boolean checkPW(String PW) {
		System.out.println(PW);
		return sCon.checkPW(PW);
	}
	public boolean checkPhone(String Phone) {
		return sCon.checkPhone(Phone);
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