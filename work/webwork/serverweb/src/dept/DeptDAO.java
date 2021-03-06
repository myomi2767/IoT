package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class DeptDAO {
	//전체목록 출력
	public ArrayList<DeptDTO> getDeptList(){
		System.out.println("getDeptList호출=> 서블릿이 넘겨준 파라미터출력");
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from mydept";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
				deptlist.add(dept);
			}
			System.out.println("dao=>"+deptlist.size());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return deptlist;
	}
	//부서등록
	public int insert(DeptDTO dept) {
		System.out.println(dept);
		int result = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into MYDEPT values(?, ?, ?, ?, ?)";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dept.getDeptNo());
			stmt.setString(2, dept.getDeptName());
			stmt.setString(3, dept.getLoc());
			stmt.setString(4, dept.getTel());
			stmt.setString(5, dept.getMgr());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	//삭제
	public int delete(String deptNo) {
		int result = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from mydept where deptno=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, deptNo);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	
	public DeptDTO read(String deptNo) {
		System.out.println("dao의 read호출");
		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from mydept where deptno=?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptNo);
			rs = ptmt.executeQuery();
			//실행결과를 자바객체로 변환 
			//  - 레코드가 여러 개: DTO로 레코드를 변환하고 ArrayList에 추가
			//  - 레코드가 한 개 : DTO로 레코드 변환
			if(rs.next()) {
				dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return dept;
	}
}
