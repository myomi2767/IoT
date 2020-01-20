package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memInsert", urlPatterns = { "/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String deptNo = request.getParameter("deptno");
		String grade = request.getParameter("grade");
		int point = Integer.parseInt(request.getParameter("point"));
		
		MemberDTO memb = new MemberDTO(id, pass, name, addr, deptNo, grade, point);
		MemberDAO dao = new MemberDAO();
		
		int result = dao.insert(memb);
		
		response.sendRedirect("/serverweb/member/list.do");
		
	}

}
