package mv.service;

import mv.dao.MovieDAO;
import mv.vo.MovieVO;

public class MovieService {
	MovieDAO dao = new MovieDAO();
	
	public void memberInsert(MovieVO vo) {
		dao.insertMember(vo);
	}	 
	
	public void memberModify(String id) {
		dao.updateMember(id);
	}
	
	public MovieVO memberSelect(String id) {
		return dao.selectMember(id);
	}
}
