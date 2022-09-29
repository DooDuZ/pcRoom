package pcRoom.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pcRoom.Model.DTO.dayrecordDTO;

public class PcRoomAdminDAO extends PcRoomDAO{

	public PcRoomAdminDAO(Connection con, PreparedStatement ps, ResultSet rs) {
		super(con, ps, rs);
		// TODO Auto-generated constructor stub
	}	
	
	private static PcRoomAdminDAO praDao = new PcRoomAdminDAO(con, ps, rs);
	
	public static PcRoomAdminDAO getinstance(){
		return praDao;
	}
	
	//매출확인 
		public dayrecordDTO daysales(String date) {
			dayrecordDTO dto = new dayrecordDTO();
			String sql="select*from dayrecord where dDate = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, date);
				rs = ps.executeQuery();
				rs.next();
				dto = new dayrecordDTO(rs.getInt(1),rs.getString(2),rs.getInt(3));
				return dto;
			} catch (Exception e) {System.out.println("DB오류"+e);}
			return dto;
		}
		//월매출확인 
		public dayrecordDTO M_daysales(String date) {
			dayrecordDTO dto = new dayrecordDTO();
			String sql = "select sum(dayincome) from dayrecord where substring(dDate,1,6) = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, date);
				rs = ps.executeQuery();
				rs.next();
				dto = new dayrecordDTO(rs.getInt(1));
				return dto;
			} catch (Exception e) {System.out.println("DB오류"+e);}
			return dto;
		}
	
	
}
