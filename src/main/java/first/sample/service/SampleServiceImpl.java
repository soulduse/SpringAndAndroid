package first.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectBoardList(map);
		
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectMemberList(map);
	}

	@Override
	public List<Map<String, Object>> selectMemberCheck(Map<String, Object> map) throws Exception {
		return sampleDAO.selectMemberCheck(map);
	}
	
	public void updateMember(Map<String, Object> map) throws Exception{
		sampleDAO.updateMember(map);
	}

	@Override
	public void insertMember(Map<String, Object> map) throws Exception {
		sampleDAO.insertMember(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		sampleDAO.insertBoard(map);
	}

	// 댓글 SELECT
	public List<Map<String, Object>> selectReply(Map<String, Object> map) throws Exception{
		return sampleDAO.selectReply(map);
	}

	// 댓글 INSERT
	@Override
	public void insertReply(Map<String, Object> map) throws Exception {
		sampleDAO.insertReply(map);
	}

	// INFO 테이블 데이터 삽입
	@Override
	public void insertInfo(Map<String, Object> map) throws Exception {
		sampleDAO.insertInfoData(map);
	}

	@Override
	public List<Map<String, Object>> selectInfo(Map<String, Object> map) throws Exception {
		return sampleDAO.selectInfo(map);
	}

}
