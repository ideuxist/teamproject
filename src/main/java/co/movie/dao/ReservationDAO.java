package co.movie.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.movie.DAO;
import co.movie.vo.ReserDate;
import co.movie.vo.ReserMovie;
import co.movie.vo.ReserRound;

public class ReservationDAO extends DAO {

	// 예약가능날짜 가져오기
	public List<ReserDate> getDate() {
		conn = getConn();
		String sql = "select to_char(screen_date,'yy-mm-dd') as seedate from screen_date where screen_date>=to_date(sysdate,'yy-mm-dd')";
		List<ReserDate> list = new ArrayList<ReserDate>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReserDate sDate = new ReserDate();
				sDate.setDate(rs.getString("seedate"));
				list.add(sDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 예약 가능날짜에 상영영화 가져오기
	public List<ReserMovie> getTitle(String date) {
		List<ReserMovie> list = new ArrayList<ReserMovie>();
		String sql = "select distinct movie_title from screening where  to_char(screening_date,'yy-mm-dd')=?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReserMovie mov = new ReserMovie();
				mov.setTitle(rs.getString("movie_title"));
				list.add(mov);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public List<ReserRound> getRound(String movie, String date) {
		List<ReserRound> list = new ArrayList<ReserRound>();
		String sql = "select * from screening where movie_title=? and  to_char(screening_date+(20/(24*60)),'yy-mm-dd')=?";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, movie);
			psmt.setString(2, date);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReserRound round = new ReserRound();
				round.setRound(rs.getInt("screening_round"));
				round.setTitle(rs.getString("movie_title"));
				list.add(round);
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
