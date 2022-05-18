package member.mv.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mv.dao.MovieDAO;
import member.mv.service.MovieService;
import member.mv.vo.MovieVO;

public class MemberIdCheckControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieService service = new MovieService();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		MovieVO vo = new MovieVO();
		
		// id, passwd를 DAO에서 사용하기 위해 MovieVO 형태로 담음.
		vo.setId(id);
		vo.setPasswd(pw);
		
		// DAO 실행
		boolean check = service.duplicateIdCheck(vo);
		
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        HttpSession session = null;
		
     
		session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);


        String path = "member.result/searchOutput.jsp";
        request.getRequestDispatcher(path).forward(request, response);
        
       
	}

}
