package member.mv.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.mv.service.MovieService;
import member.mv.vo.MovieVO;

public class MemberIdCheckControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieService service = new MovieService();
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		MovieVO vo = new MovieVO();
		
		// id, passwd 값이 모두 있어야 함.
	
			// id, passwd를 DAO에서 사용하기 위해 MovieVO 형태로 담음.
			vo.setId(id);
			vo.setPasswd(pw);
			MovieVO vovo = service.duplicateIdCheck(vo); // DAO 결과값 담는 인스턴스
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	 
	        HttpSession session = null;
	        String chkId = vovo.getId();

	        System.out.println("id 값: "+chkId);
	     if(chkId == null) {
				id = null;
				pw = null;
				session = null;
				System.out.println("응 id 없어~");
				session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				request.getRequestDispatcher("myapp.homepage.tiles").forward(request, response);
	     } else {
			session = request.getSession();
			session.setAttribute("id", vovo.getId());
			session.setAttribute("pw", vovo.getPasswd());
			
			
	        String path = "myapp.homepage.tiles";
	        request.getRequestDispatcher(path).forward(request, response);
	     }
		
		
        
       
	}

}
