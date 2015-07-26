package first.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectMemberCheck(Map<String, Object> map) throws Exception;
	
	// 댓글 관련
	List<Map<String, Object>> selectReply(Map<String, Object> map) throws Exception;
	void insertReply(Map<String, Object> map) throws Exception;
	
	// 사용자 관련
	void updateMember(Map<String, Object> map) throws Exception;
	void insertMember(Map<String, Object> map) throws Exception;
	void insertBoard(Map<String, Object> map) throws Exception;
	
	// INFO 테이블 관련
	void insertInfo(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectInfo(Map<String, Object> map) throws Exception;
}
