package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.StudyMapper;
import kr.spring.finalp.domain.StudyCommand;
import kr.spring.finalp.domain.StudyReplyCommand;

@Service("StudyService")
public class StudyServiceImpl implements StudyService{
   //ºÎ¸ð±Û
   @Resource
   private StudyMapper studyMapper;
   
   @Override
   public List<StudyCommand> list(Map<String,Object> map){
      
      return studyMapper.list(map);
   }
   
   @Override
   public int getRowCount(Map<String,Object> map) {
      
      return studyMapper.getRowCount(map);
   }
   
   @Override
   public void insert(StudyCommand study) {
      studyMapper.insert(study);
   }
   
   @Override
   public void updateHit(Integer sb_num) {
      studyMapper.updateHit(sb_num);
   }
   
   @Override
   public void update(StudyCommand study) {
      studyMapper.update(study);
   }
   
   @Override
   public void delete(Integer sb_num) {
      studyMapper.deleteReplyByNum(sb_num);
      studyMapper.delete(sb_num);
   }
   
   @Override
   public StudyCommand selectId(String m_id) {
      return studyMapper.selectId(m_id);
   }
   
   @Override
   public StudyCommand selectNum(Integer sb_num) {
      return studyMapper.selectNum(sb_num);
   }
   
   //´ñ±Û
   @Override
   public List<StudyReplyCommand> listReply(Map<String,Object> map){
      return studyMapper.listReply(map);
   }
   
   @Override
   public int getRowCountReply(Map<String,Object> map) {
      int count=studyMapper.getRowCountReply(map);
      return count;
   }
   
   @Override
   public void insertReply(StudyReplyCommand studyReply) {
      studyMapper.writeReply(studyReply);
   }
   
   @Override
   public void updateReply(StudyReplyCommand studyReply) {
      studyMapper.updateReply(studyReply);
   }
   
   @Override
   public void deleteReply(Integer sc_num) {
      studyMapper.deleteReply(sc_num);
   }
}