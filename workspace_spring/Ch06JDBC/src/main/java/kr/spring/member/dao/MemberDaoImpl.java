package kr.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.spring.member.domain.MemberCommand;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	
	private static final String INSERT_SQL = "INSERT INTO zmember (id, passwd, name,reg_date) VALUES (?,?,?,sysdate)";
	private static final String SELECT_COUNT_SQL = "SELECT count(*) FROM zmember";
	private static final String SELECT_LIST_SQL = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM zmember ORDER BY reg_date DESC)a) WHERE rnum >= ? AND rnum <= ?";

	private RowMapper<MemberCommand> rowMapper = new RowMapper<MemberCommand>() {

		@Override
		public MemberCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberCommand member = new MemberCommand();
			member.setId(rs.getString("id"));
			member.setPasswd(rs.getString("passwd"));			
			member.setName(rs.getString("name"));
			member.setReg_date(rs.getDate("reg_date"));
			
			return member;
		}};
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	//µî·Ï
	@Override
	public void insertrMember(MemberCommand member) {
		jdbcTemplate.update(INSERT_SQL, new Object[] {member.getId(), member.getPasswd(), member.getName()});
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SELECT_COUNT_SQL, Integer.class);
	}

	@Override
	public List<MemberCommand> getMemberList(int startRow, int endRow) {
		List<MemberCommand> list = jdbcTemplate.query(SELECT_LIST_SQL, new Object[] {startRow, endRow}, rowMapper);
		
		return list;
	}

	@Override
	public MemberCommand getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberCommand member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}

}
