package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.finalp.domain.ClassCommand;

public interface ClassMapper {

	public List<ClassCommand> listClass(Map<String,Object> map);
	
	public int getRowCount(Map<String,Object> map);
	
	@Insert("INSERT INTO class VALUES (c_seq.nextval,#{t_num},#{a_num},#{c_category},#{c_name},#{c_content},#{c_count},#{c_max_count},'17/01/01','18/01/01',#{c_tuition},sysdate)")
	public void insertClass(ClassCommand Class);
	
	public ClassCommand selectClass(Integer a_num);
	
	public void updateLike(Integer a_num);
	
	
	public void updateClass(ClassCommand Class);
	
	@Select("select distinct t_num,a_num from class where a_num = (select a_num from academy join member using(m_num) where m_id=#{m_id})")
	public ClassCommand selectCM(String m_id);
	
}
