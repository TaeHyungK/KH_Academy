package kr.qboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.qboard.domain.QboardDto;


public class QboardDao {
	//싱글턴 패턴
			private static QboardDao instance = new QboardDao();
			
			public static QboardDao getInstance() {
				
				return instance;
			}
			private QboardDao() {};
			
			//context.xml에서 설정정보를 읽어들여
				//커넥션풀로부터 커넥션을 할당 받음
				private Connection getConnection() throws Exception{
					Context initCtx = new InitialContext();
					DataSource ds =  (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
					return ds.getConnection();
				}

				//자원정리
				private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
					if(rs!=null)try {rs.close();}catch(SQLException e) {}
					if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
					if(conn!=null)try {conn.close();}catch(SQLException e) {}
				}
				
				
				//고객글 등록
				public void insertQboard(QboardDto qboard)throws Exception{
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql = null;
					int cnt =0;
					
					try {
						conn = getConnection();
						sql = "INSERT INTO QnA (q_num,q_id,q_title,q_content,regdate,q_solve) VALUES(q_num_seq.nextval,?,?,?,sysdate,?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(++cnt, qboard.getQ_id());
						pstmt.setString(++cnt, qboard.getQ_title());
						pstmt.setString(++cnt, qboard.getQ_content());
						pstmt.setInt(++cnt, qboard.getQ_solve());
						
						pstmt.executeUpdate();
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(null,pstmt,conn);
					}
				}
				//전체 글 갯수,검색 글 갯수
				public int getQboardCount(String keyfield,String keyword)throws Exception{
				int count = 0;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs =null;
				String sql = null;
				
				try {
					conn = getConnection();
					if(keyword==null || "".equals(keyword)) {
						//전체 글 갯수
					    sql = "SELECT COUNT(*) FROM qna";
					    pstmt = conn.prepareStatement(sql);
					}else{//검색 글 갯수
						sql = "SELECT COUNT(*) FROM qna WHERE "+keyfield+" like ?";
				        pstmt = conn.prepareStatement(sql);
				        pstmt.setString(1, "%"+keyword+"%");
				    }
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						count = rs.getInt(1);
					}
				}catch(Exception e) {
					throw new Exception(e);
				}finally {
					executeClose(rs,pstmt,conn);
				}
				return count;
				}
				//목록
				public List<QboardDto> getListQboard(int start,int end,String keyfield,String keyword)throws Exception{
					List<QboardDto> list = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs =null;
					String sql = null;
					
					try {
						conn = getConnection();
						if(keyword==null || "".equals(keyword)) {//전체 글 보기
						    sql ="SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM qna)a) WHERE rnum>= ? AND rnum<=?";
						    pstmt = conn.prepareStatement(sql);
						    pstmt.setInt(1, start);
						    pstmt.setInt(2, end);
						}else {//검색 글 보기
							sql ="SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM qna WHERE "+keyfield+" like ?)a) WHERE rnum>= ? AND rnum<=?";
						    pstmt = conn.prepareStatement(sql);
						    pstmt.setString(1, "%"+keyword+"%");
						    pstmt.setInt(2, start);
						    pstmt.setInt(3, end);
						}
						
						rs = pstmt.executeQuery();
						
						list = new ArrayList<QboardDto>();
						
						while(rs.next()) {
							QboardDto qboard = new QboardDto();
							qboard.setQ_num(rs.getInt("q_num"));
							qboard.setQ_title(rs.getString("q_title"));
							qboard.setQ_id(rs.getString("q_id"));
							qboard.setQ_solve(rs.getInt("q_solve"));
							
							list.add(qboard);
						}
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(rs,pstmt,conn);
					}
					
					return list;
				}	
				//글 상세
				public QboardDto getBoard(int q_num)throws Exception{
					QboardDto qboard = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql = null;
					
					try {
						conn = getConnection();
						sql ="SELECT * FROM qna WHERE q_num=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, q_num);
						
						rs = pstmt.executeQuery();
						
						if(rs.next()) {
							qboard = new QboardDto();
							qboard.setQ_num(rs.getInt("q_num"));
							qboard.setQ_title(rs.getString("q_title"));
							qboard.setQ_content(rs.getString("q_content"));
							qboard.setQ_id(rs.getString("q_id"));
							qboard.setRegdate(rs.getDate("regdate"));
							qboard.setQ_solve(rs.getInt("q_solve"));
							
						}
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(rs,pstmt,conn);
					}
					
					return qboard;
				}
				//글 수정
				public void updateBoard(QboardDto qboard)throws Exception{
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql = null;
					int cnt = 0;
					
					try {
						conn = getConnection();
						sql = "UPDATE qna SET q_title=?,q_content=? WHERE q_num=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(++cnt, qboard.getQ_title());
						pstmt.setString(++cnt, qboard.getQ_content());
						pstmt.setInt(++cnt, qboard.getQ_num());
						
						pstmt.executeUpdate();
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(null,pstmt,conn);
					}
				}
				//글 삭제
				public void deleteBoard(int q_num)throws Exception{
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql = null;
					
					try {
						conn = getConnection();
						sql = "DELETE FROM qna WHERE q_num=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, q_num);
						pstmt.executeUpdate();
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(null,pstmt,conn);
					}
					
				}
				
				
				
				//댓글 등록
				//댓글 수정
				//댓글 삭제
				

}
