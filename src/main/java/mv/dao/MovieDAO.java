package mv.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mv.vo.MovieVO;

public class MovieDAO extends DAO{
	
	 public boolean duplicateIdCheck(String id)
	    {	
		 	boolean x = false;
	        conn = getConnect();
	        String sql="SELECT ID FROM movie_MEMBER WHERE ID=?";
	        try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) x=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return x;
	        
	    } // end duplicateIdCheck()

	
private static MovieDAO instance;
    
    // 싱글톤 패턴
    public MovieDAO(){}
    public static MovieDAO getInstance(){
        if(instance==null)
            instance=new MovieDAO();
        return instance;
    }


	
	public List<MovieVO> movieHistory(String id) {
		conn= getConnect();
		List<MovieVO> list = new ArrayList<MovieVO>();
		String sql="select * from movie_history where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setMovieTitle(rs.getString("movie_title"));
				vo.setMovieRoom(rs.getString("movie_room"));
				vo.setMovieDate(rs.getString("movie_date"));
				
				list.add(vo);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	

	public void insertMember(MovieVO vo) {
		conn = getConnect();
		String sql = "insert into movie_member (name, id, passwd) values (?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getPasswd());
			
			int r = psmt.executeUpdate();
			System.out.println(r +"건 입력됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}

	public void updateMember(MovieVO vo) {
		conn = getConnect();
		String sql = "update movie_member set passwd = ? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		
	}

	public MovieVO selectMember(String id) {
		conn= getConnect();
		String sql = "select * from movie_member where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
		
	}

}
