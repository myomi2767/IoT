package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//오라클에 접속하기
public class ConnectionTest {
	//127.0.0.1 = localhost = 현재 작업 중인 내 pc
	public static void main(String[] args) {
		//연결문자열 - 어떤 DBMS를 쓰느냐에 따라 형식이 달라진다.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//String url = "jdbc:oracle:thin:@70.12.115.63:1521:xe";
		//원격에 있는 실제 DB서버 ip
		//String url = "jdbc:oracle:thin:@70.12.115.64:1521:xe";
		//접속계정
		String user = "scott";
		//접속할 계정의 패스워드
		String password = "tiger";
		try {
			//1. 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");
			//2. DBMS에 연결하기 - 연결정보를 정의
			// ==> DBMS에 연결하고 연결정보를 Connection타입으로 반환한다.
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공"+con);
		} catch(ClassNotFoundException e){
			System.out.println("드라이버로딩 실패");
		} catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}
	}

}
