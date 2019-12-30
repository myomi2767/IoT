package jdbc.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//tb_board테이블을 액세스하는 기능이 정의된 클래스
public class BoardDAOImpl implements BoardDAO{
	public int insert(BoardDTO board) {
		System.out.println("dto사용메소드:"+board); //메소드를 호출하는 메소드에서 기본적인 디버깅 방법
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0; //메소드 실행결과가 저장될 변수
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		try {	
			con = DBUtil.getConnect();//DBMS연결
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	
	public int insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0; //메소드 실행결과가 저장될 변수
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		try {	
			con = DBUtil.getConnect();//DBMS연결
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	
	public int update(String id, int boardNum) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;
		String sql = "update tb_board set id=? where boardnum=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, boardNum);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	
	public int delete(int boardNum) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board "); 
		sql.append("where boardnum=?");
		/*String sql = "delete from tb_board where boardnum = 3";*/
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, boardNum);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
			e.printStackTrace();//오류추적
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
	//조회한 결과를 ArrayList로 변환하여 리턴
	public ArrayList<BoardDTO> select() {
		//전체 게시글을 담을 Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		//조회한 게시글을 담을 객체
		//객체를 생성하지 않고 null로 초기화하는 이유 
		//-> 데이터를 조회하는 작업을 하는 곳이 while문 내부이므로 while문 조회된 레코드로 객체를 생성
		BoardDTO board = null; 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {//=>레코드를 조회하기 위해서는 레코드가 한 개라도 반드시 커서를 이동시켜야 한다.
				/*System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));*/
				
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				board = new BoardDTO(rs.getInt(1), rs.getString(2),	rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6));
				//2. DTO로 변환된 레코드를 ArrayList에 추가
				boardlist.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return boardlist;
	}
	public BoardDTO read(int boardnum) {
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board where boardnum=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getDate(5), rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}		
		return board;
	}

	@Override
	public ArrayList<BoardDTO> findByTitle(String title) {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tb_board where title like ?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+title+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getDate(5), rs.getInt(6));
				boardlist.add(board);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return boardlist;
	}
	
	public int hitUp(int boardnum) {
		int result =0;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update tb_board set hit=hit+1 where boardnum=?";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}
}
