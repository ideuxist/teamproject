package mv.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mv.service.MovieService;
import mv.vo.MovieVO;

public class MemberSearchControl implements Control {
// 로그인, 예매내역
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String job = request.getParameter("job");
		String path = "";
		
		//아이디, 비밀번호 같은 필수 요소 입력 안 했을 때
		if (job.equals("search")) {
			path = "view/login.jsp";
		} else if (job.equals("history")) {
			path = "view/secondLogin.jsp";
		} else if (job.equals("update")) {
			path = "view/thirdLogin.jsp";
		}

		if (id.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("error", "아이디와 비밀번호 모두 입력하세요.");
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		
		// 로그인 및 예매내역
		
		MovieService service = new MovieService();

		if (job.equals("search")) {

			MovieVO vo = new MovieVO();
			vo.setId(id);
			vo.setPasswd(passwd);

			MovieVO member = service.memberSelect(id);
			
			if (member == null) {
				request.setAttribute("result", "아이디를 다시 확인해주세요.");
				request.getRequestDispatcher(path).forward(request, response);
			} 
			
			else {// 로그인 성공하면 메인으로 보냄 "" 민욱이가 만든 메인 주소로 대체해야 함 -> 로그인 됐다고 표시 필요 -> 어떻게? -> getSession?
				
				if (passwd.equals(member.getPasswd())) {
					
					HttpSession session = null;
					
					session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("pass", passwd);
					
					response.sendRedirect("testIndex.jsp");
					
					//request.getRequestDispatcher("testIndex.jsp").forward(request, response);
				} else {
					request.setAttribute("result", "비밀번호를 다시 확인해주세요.");
					request.getRequestDispatcher(path).forward(request, response);
				}
			} 
			
		// 예매 내역   	
		} else if (job.equals("history")) {

			MovieVO vo = new MovieVO();
			vo.setId(id);
			vo.setPasswd(passwd);

			MovieVO member = service.memberSelect(id);

			if (member == null) {
				request.setAttribute("result", "아이디를 확인해주세요.");
				request.getRequestDispatcher(path).forward(request, response);
			} else {
				if (passwd.equals(member.getPasswd())) {
					List<MovieVO> list = service.movieHistory(id);
					request.setAttribute("all", list);
					request.getRequestDispatcher("result/historyOutput.jsp").forward(request, response);
				} else {
					request.setAttribute("result", "비밀번호를 다시 확인해주세요.");
					request.getRequestDispatcher(path).forward(request, response);
				}
			}

		} else if (job.equals("update")) {
			MovieVO vo = new MovieVO();
			vo.setId(id);
			vo.setPasswd(passwd);

			MovieVO member = service.memberSelect(id);

			if (member == null) {
				request.setAttribute("result", "아이디를 확인해주세요.");
				request.getRequestDispatcher(path).forward(request, response);
			} else {
				if (passwd.equals(member.getPasswd())) {
					request.setAttribute("id", id);
					request.getRequestDispatcher("view/modify.jsp").forward(request, response);
				} else {
					request.setAttribute("result", "비밀번호를 다시 확인해주세요.");
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
		}
	}

}
