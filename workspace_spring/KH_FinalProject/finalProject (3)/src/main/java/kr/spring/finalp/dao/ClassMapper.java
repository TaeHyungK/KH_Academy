package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.ClassCommand;

public interface ClassMapper {

	public List<ClassCommand> listClass(Map<String,Object> map);
	
	public int getRowCount(Map<String,Object> map);
	 
	//강의 등록
	@Insert("INSERT INTO class VALUES (c_seq.nextval,#{t_num},#{a_num},#{c_category},#{c_name},#{c_content},0,#{c_max_count},#{c_start},#{c_end},#{c_tuition},sysdate)")
	public void insertClass(ClassCommand Class);
	
	//강의 목록 불러오기(강사랑 조인해서 강사까지)
	@Select("select * from class join teacher using(t_num) order by c_num desc")
	public List<ClassCommand> selectClass(Map<String,Object> map);
	
	//강사 인원수
	public int getListRowCount(Map<String,Object> map);
	
	public void updateLike(Integer a_num);
		
	//강의 수정
	@Update("UPDATE class SET t_num=#{t_num}, c_category=#{c_category}, c_name=#{c_name}, c_content=#{c_content},c_max_count=#{c_max_count},c_start=#{c_start},c_end=#{c_end},c_tuition=#{c_tuition} WHERE a_num=#{a_num} AND c_num=#{c_num}")
	public void updateClass(ClassCommand Class);
	
	//강의 삭제
	@Delete("DELETE FROM class WHERE a_num=#{a_num} AND c_num=#{c_num}")
	public void deleteClass(Map<Object,Object> map);

	//강의 등록할 때 접속한 아이디에 해당하는 학원 번호 불러오기
	@Select("select a_num from academy join member using(m_num) where m_id=#{m_id}")
	public ClassCommand selectCM(String m_id);
	
	//강의 등록할 때 해당 학원 강사 목록 불러오기
	@Select("select * from teacher where a_num = (select a_num from academy join member using(m_num) where m_id=#{m_id}) order by t_num desc")
	public List<ClassCommand> listTnum(String m_id);
	
	//==========================내가 찜한 강의===============================================
	
	//내가찜한강의목록에 해당 회원이 해당 강의를 넣었는지 비교
	@Select("SELECT count(*) from my_class where m_num=#{m_num} and c_num=#{c_num}")
	public int compareClass(Map<Object,Object> map);
	
	//내가찜한강의에 담기
	@Insert("INSERT INTO my_class VALUES (my_seq.nextval,#{c_num},#{m_num})")
	public void getClass(ClassCommand Class);

	//내가찜한 강의 목록--my_class command 새로만들지?
	@Select("select * from my_class join class using(c_num) where m_num = (select m_num from member where m_id = #{m_id})")
	public List<ClassCommand> selectGet(String m_id);
	
	//내가 찜한 강의 목록에서 삭제
	@Delete("DELETE FROM my_class where my_num = #{my_num}")
	public void deleteMyClass(Integer my_num);
	
	//수정용 정보가져오기
	@Select("SELECT * from class where a_num=#{a_num} and c_num=#{c_num}")
	public ClassCommand updateCompare(Map<Object,Object> map);
	
	//수강신청
	@Insert("INSERT INTO complete VALUES (#{my_num},#{total_price},#{m_num},#{c_num})")
	public void classComplete(Map<Object,Object> map);
	
	//==============================수강신청 완료==========================
	
	//수강신청 완료 목록
	@Select("SELECT * FROM complete join class using(c_num) WHERE m_num = #{m_num}")
	public List<ClassCommand> selectComplete(Integer m_num);
	
	//수강신청 - 강의 인원 증가
	@Update("UPDATE class SET c_count= c_count+1 WHERE c_num = #{c_num}") 
	public void updateC_count(Integer c_num);
	
	//내가찜한강의목록에 해당 회원이 해당 강의를 넣었는지 비교 
	@Select("SELECT count(*) from COMPLETE where c_num=#{c_num}")
	public int compareComplete(Integer c_num);
}
