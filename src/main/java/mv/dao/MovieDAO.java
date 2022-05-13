package mv.dao;

import java.sql.SQLException;

import mv.vo.MovieVO;

public class MovieDAO extends DAO{

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

	public void updateMember(String id) {
		// TODO Auto-generated method stub
		
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
			
			System.out.println("로그인완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
		
	}

}
