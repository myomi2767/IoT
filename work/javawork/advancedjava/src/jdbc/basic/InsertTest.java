package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into tb_board values(board_seq.nextval,'jang','연습','연습',sysdate,0)";
		try {
			//1. 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공");
			//2. DBMS에 연결하기 - 연결정보를 정의
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공"+con);
			//3. SQL을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 Connection객체를 이용해서 생성
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체정보:"+stmt);
			
			//4. SQL실행하기
			int result = stmt.executeUpdate(sql);
			//5. 결과 처리하기
			System.out.println(result+"개 행 삽입성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
		} catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}
	}

}
