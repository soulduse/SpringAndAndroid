package first.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectBoardList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectMemberList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectMemberCheck(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("sample.selectMemberCheck", map);
	}
	
	public void updateMember(Map<String, Object> map){
		update("sample.updateMember", map);
	}

	public void insertMember(Map<String, Object> map) {
		insert("sample.insertMember", map);
	}

	public void insertBoard(Map<String, Object> map) {
		insert("sample.insertBoard", map);
	}

	// 댓글 내용 가져오기 SELECT
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectReply(Map<String, Object> map) {
		return (List<Map<String, Object>>) selectList("sample.selectReply", map);
	}
	
	// 댓글 내용 INSERT
	public void insertReply(Map<String, Object> map){
		insert("sample.insertReply", map);
	}

	// INFO 테이블 데이터 삽입
	public void insertInfoData(Map<String, Object> map) {
		insert("sample.insertInfo", map);
	}
	
	// INFO 테이블 데이터 SELECT
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectInfo(Map<String, Object> map) throws Exception {
		return (List<Map<String,Object>>)selectList("sample.selectInfo", map);
	}

}
