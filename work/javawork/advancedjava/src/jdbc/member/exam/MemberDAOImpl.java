package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.BoardDTO;
import jdbc.board.exam.DBUtil;

public class MemberDAOImpl implements MemberDAO{
	public int insert(MemberDTO user) {
		System.out.println(user);
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;
		String sql = "insert into member values(?,?,?,?,?,sysdate,1000)";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getAddr());
			stmt.setString(5, user.getDeptno());
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		
		return result;
	}
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;
		String sql = "update member set addr=? where id=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int delete(String id) {
		int result = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from member where id=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null; 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(rs, stmt, con);
			}
			return memberlist;
	}
	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member where addr like ?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+addr+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return memberlist;
	}
	@Override
	public MemberDTO login(String id, String pass) {
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=? and pass=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			if(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}		
		return member;
	}
}
