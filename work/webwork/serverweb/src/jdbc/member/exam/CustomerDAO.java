package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {
	public int insert(CustomerDTO customer) {
		System.out.println(customer);
		int result = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert into customer values(?,?,?,sysdate,?,?)";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());
			stmt.setString(3, customer.getName());
			stmt.setInt(4, customer.getPoint());
			stmt.setString(5, customer.getAddr());
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	public int update(String id, String addr) {
		int result = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update customer set addr=? where id=?";
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
		int result =0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from customer where id=?";
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
}
