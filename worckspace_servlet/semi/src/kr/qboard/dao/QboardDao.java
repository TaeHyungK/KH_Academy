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
import kr.qboard.domain.QboardReply;
import kr.util.StringUtil;


public class QboardDao {
	//�̱��� ����
			private static QboardDao instance = new QboardDao();
			
			public static QboardDao getInstance() {
				
				return instance;
			}
			private QboardDao() {};
			
			//context.xml���� ���������� �о�鿩
				//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
				private Connection getConnection() throws Exception{
					Context initCtx = new InitialContext();
					DataSource ds =  (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
					return ds.getConnection();
				}

				//�ڿ�����
				private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
					if(rs!=null)try {rs.close();}catch(SQLException e) {}
					if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
					if(conn!=null)try {conn.close();}catch(SQLException e) {}
				}
				
				
				//���� ���
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
				//��ü �� ����,�˻� �� ����
				public int getQboardCount(String keyfield,String keyword)throws Exception{
				int count = 0;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs =null;
				String sql = null;
				
				try {
					conn = getConnection();
					if(keyword==null || "".equals(keyword)) {
						//��ü �� ����
					    sql = "SELECT COUNT(*) FROM qna";
					    pstmt = conn.prepareStatement(sql);
					}else{//�˻� �� ����
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
				//���
				public List<QboardDto> getListQboard(int start,int end,String keyfield,String keyword)throws Exception{
					List<QboardDto> list = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs =null;
					String sql = null;
					
					try {
						conn = getConnection();
						if(keyword==null || "".equals(keyword)) {//��ü �� ����
						    sql ="SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM qna)a) WHERE rnum>= ? AND rnum<=?";
						    pstmt = conn.prepareStatement(sql);
						    pstmt.setInt(1, start);
						    pstmt.setInt(2, end);
						}else {//�˻� �� ����
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
				//�� ��
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
				//�� ����
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
				//�� ����
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
				
				
				
				//��� ���
				public void replyInsertBoard(QboardReply qreply)throws Exception{
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql = null;
					int cnt = 0;
					
					try {
						conn = getConnection();
						sql = "INSERT INTO qna_reply(re_qnum,re_content,re_date,id) values(?,?,sysdate,?) ";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(++cnt, qreply.getRe_qnum());
						pstmt.setString(++cnt, qreply.getRe_content());
						pstmt.setString(++cnt, qreply.getQ_id());
						
						pstmt.executeUpdate();
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(null,pstmt,conn);
					}
				}
				
				//��� ����
				public int getReplyBoardCount(int q_num)throws Exception{
					int count = 0;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql = null;
					
					try {
						conn = getConnection();
						//���� num���� �˻��� ���ڵ�� ���ϱ�
						sql = "SELECT COUNT(*) FROM qna_reply WHERE q_num=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, q_num);
						rs = pstmt.executeQuery();
						
						if(rs.next()) {
							count =rs.getInt(1);
						}
						
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(rs,pstmt,conn);
					}
					
					
					
					return count;
				}
				
				//��� ���
				public List<QboardReply> getListreplyBoard(int start,int end,int num)throws Exception{
					List<QboardReply> list = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql = null;
					
					try {
						conn = getConnection();
						//���� num���� �˻��� ���ڵ� ��ȯ
						sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM qna_reply WHERE num=? ORDER BY re_num DESC)a) WHERE rnum >=? AND rnum <=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, num);
						pstmt.setInt(2, start);
						pstmt.setInt(3, end);
						rs = pstmt.executeQuery();
						
						list = new ArrayList<QboardReply>();
						while(rs.next()) {
							QboardReply qboard = new QboardReply();
							qboard.setRe_qnum(rs.getInt("re_qnum"));
							qboard.setRe_content(StringUtil.useNoHtml(rs.getString("re_content")));
							qboard.setRe_date(rs.getDate("re_date"));
							qboard.setQ_id(rs.getString("id"));
							
							list.add(qboard);
						}
						
					}catch(Exception e) {
						throw new Exception(e);
					}finally {
						executeClose(rs,pstmt,conn);
					}
					
					return list;
				}
				//��� ����
				public void deleteReplyBoard(int re_qnum)throws Exception{
					
				}
				

}
