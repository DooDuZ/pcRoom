package pcRoom.data;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.View.SeatView;

public class SeatTimer implements Runnable{
	
	private int memNo;				// 회원정보 저장 후 해당 값을 통해 DB접근
	private String memID;			// ID출력용으로 저장해두려 했으나 사용x
	private int memTime;			// 시간 가져와서 java에서 제어
	private SeatView sv;			// SeatRun 혹은 SeatView에서 생성된 객체와 같은 객체를 참조해야 하므로 필드 값 생성 후 setter를 통해 제어
	private int SeatNo;				// SeatView.start 매서드에서 매개변수로 입력받음
	private boolean logOut = true;

	@Override
	public void run() {
		while(logOut) {
			System.out.println("남은 시간 : " + memTime/60+ "시간 "+ memTime%60 + "분");
			memTime--;
			setDB(memNo ,memTime);
			if(memTime == 0) {
				logOut = false;
				sv.saveLogout(SeatNo);
				System.out.println("[사용종료]시간 만료");
				return;
			}
			try {
				Thread.sleep(60000);
			} catch (Exception e) {
				System.out.println("시간출력 오류"+e);
			}
		}
	}	
	//getter and setter
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
	
	
	public boolean isLogOut() {
		return logOut;
	}
	// view의 사용종료 탭에서 호출하여 스레드 정지
	public void setLogOut(boolean logOut) {
		this.logOut = logOut;
	}

	public SeatView getSv() {
		return sv;
	}
	public void setSv(SeatView sv) {
		this.sv = sv;
	}
	
	public int getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(int seatNo) {
		SeatNo = seatNo;
	}
	// 차감된 시간 db로 전송
		// controller 객체에 접근 시 상호 호출관계로 무한정 객체 생성하게 됌
		// controller에 있는 메서드의 static or dao에 직접 접근 중 하나 선택
		// DAO 싱글톤 호출 후 접근
	public void setDB(int memNo, int memTime) {
		SeatDAO.getInstance().setDB(memNo, memTime);
	}
}
