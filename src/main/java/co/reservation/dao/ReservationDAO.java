package co.reservation.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.reservation.DAO;
import co.reservation.vo.Movie;
import co.reservation.vo.Screening;

public class ReservationDAO extends DAO {

	public List<Screening> dateChoice() {
		conn = getConn();
		List<Screening> list = new ArrayList<Screening>();
		String sql = "select distinct to_char(screening_start,'yy-mm-dd') as seeDate\r\n"
				+ "from screening \r\n"
				+ "where to_char(screening_start,'yy-mm-dd') >= to_char(sysdate,'yy-mm-dd') \r\n"
				+ "GROUP BY screening_start\r\n"
				+ "order by seeDate"; 
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Screening scr = new Screening(rs.getString("seeDate"));
				System.out.println(scr);
				list.add(scr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}

	public List<Movie> movieChoice(String date) {
		conn = getConn();
		List<Movie> list = new ArrayList<Movie>();
		String sql = "select distinct movie_title\r\n"
				+ "from movie m\r\n"
				+ "inner join screening s\r\n"
				+ "on m.movie_id = s.movie_id\r\n"
				+ "where to_char(s.screening_start,'yy-mm-dd')=?";
		try {
			psmt=conn.prepareStatement(sql);
			System.out.println(date);
			psmt.setString(1, date);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Movie mov = new Movie(rs.getString("movie_title"));
				System.out.println(mov);
				list.add(mov);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return list; 
	}

	public List<Screening> roundChoice(String date,String title) {
		conn = getConn();
		List<Screening> list = new ArrayList<Screening>();
		String sql = "select to_char(screening_start,'hh24:mi') as start_time  from movie m\r\n"
				+ "inner join screening s on m.movie_id=s.movie_id\r\n"
				+ "where to_char(s.screening_start,'yy-mm-dd')=? and movie_title=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, date);
			psmt.setString(2, title);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Screening sc = new Screening(rs.getString("start_time"));
				System.out.println(sc);
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}	

}
