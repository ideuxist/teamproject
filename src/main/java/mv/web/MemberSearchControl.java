package mv.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mv.service.MovieService;
import mv.vo.MovieVO;

public class MemberSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MovieVO vo = new MovieVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		
		MovieService service = new MovieService();
		MovieVO member = service.memberSelect(id);
		
		if(member != null) {
			
		}
		
	}

}
