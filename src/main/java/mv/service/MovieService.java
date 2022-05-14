package mv.service;

import java.util.List;

import mv.dao.MovieDAO;
import mv.vo.MovieVO;

public class MovieService {
	MovieDAO dao = new MovieDAO();
	
	public void memberInsert(MovieVO vo) {
		dao.insertMember(vo);
	}	 
	
	public void memberModify(MovieVO vo) {
		dao.updateMember(vo);
	}
	
	public MovieVO memberSelect(String id) {
		return dao.selectMember(id);
	}

	public List<MovieVO> movieHistory(String id) {
		return dao.movieHistory(id);
	}
}
