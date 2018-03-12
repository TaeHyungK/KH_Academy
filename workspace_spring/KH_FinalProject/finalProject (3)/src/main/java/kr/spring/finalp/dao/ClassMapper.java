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
	 
	//���� ���
	@Insert("INSERT INTO class VALUES (c_seq.nextval,#{t_num},#{a_num},#{c_category},#{c_name},#{c_content},0,#{c_max_count},#{c_start},#{c_end},#{c_tuition},sysdate)")
	public void insertClass(ClassCommand Class);
	
	//���� ��� �ҷ�����(����� �����ؼ� �������)
	@Select("select * from class join teacher using(t_num) order by c_num desc")
	public List<ClassCommand> selectClass(Map<String,Object> map);
	
	//���� �ο���
	public int getListRowCount(Map<String,Object> map);
	
	public void updateLike(Integer a_num);
		
	//���� ����
	@Update("UPDATE class SET t_num=#{t_num}, c_category=#{c_category}, c_name=#{c_name}, c_content=#{c_content},c_max_count=#{c_max_count},c_start=#{c_start},c_end=#{c_end},c_tuition=#{c_tuition} WHERE a_num=#{a_num} AND c_num=#{c_num}")
	public void updateClass(ClassCommand Class);
	
	//���� ����
	@Delete("DELETE FROM class WHERE a_num=#{a_num} AND c_num=#{c_num}")
	public void deleteClass(Map<Object,Object> map);

	//���� ����� �� ������ ���̵� �ش��ϴ� �п� ��ȣ �ҷ�����
	@Select("select a_num from academy join member using(m_num) where m_id=#{m_id}")
	public ClassCommand selectCM(String m_id);
	
	//���� ����� �� �ش� �п� ���� ��� �ҷ�����
	@Select("select * from teacher where a_num = (select a_num from academy join member using(m_num) where m_id=#{m_id}) order by t_num desc")
	public List<ClassCommand> listTnum(String m_id);
	
	//==========================���� ���� ����===============================================
	
	//�������Ѱ��Ǹ�Ͽ� �ش� ȸ���� �ش� ���Ǹ� �־����� ��
	@Select("SELECT count(*) from my_class where m_num=#{m_num} and c_num=#{c_num}")
	public int compareClass(Map<Object,Object> map);
	
	//�������Ѱ��ǿ� ���
	@Insert("INSERT INTO my_class VALUES (my_seq.nextval,#{c_num},#{m_num})")
	public void getClass(ClassCommand Class);

	//�������� ���� ���--my_class command ���θ�����?
	@Select("select * from my_class join class using(c_num) where m_num = (select m_num from member where m_id = #{m_id})")
	public List<ClassCommand> selectGet(String m_id);
	
	//���� ���� ���� ��Ͽ��� ����
	@Delete("DELETE FROM my_class where my_num = #{my_num}")
	public void deleteMyClass(Integer my_num);
	
	//������ ������������
	@Select("SELECT * from class where a_num=#{a_num} and c_num=#{c_num}")
	public ClassCommand updateCompare(Map<Object,Object> map);
	
	//������û
	@Insert("INSERT INTO complete VALUES (#{my_num},#{total_price},#{m_num},#{c_num})")
	public void classComplete(Map<Object,Object> map);
	
	//==============================������û �Ϸ�==========================
	
	//������û �Ϸ� ���
	@Select("SELECT * FROM complete join class using(c_num) WHERE m_num = #{m_num}")
	public List<ClassCommand> selectComplete(Integer m_num);
	
	//������û - ���� �ο� ����
	@Update("UPDATE class SET c_count= c_count+1 WHERE c_num = #{c_num}") 
	public void updateC_count(Integer c_num);
	
	//�������Ѱ��Ǹ�Ͽ� �ش� ȸ���� �ش� ���Ǹ� �־����� �� 
	@Select("SELECT count(*) from COMPLETE where c_num=#{c_num}")
	public int compareComplete(Integer c_num);
}
