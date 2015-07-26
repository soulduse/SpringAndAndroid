package first.sample.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import first.sample.service.SampleService;

@Controller
public class SampleController {
	
	@Autowired
	   private ServletContext servletContext;
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleService")
	private SampleService sampleService;

	@RequestMapping(value = "/sample/openSampleBoardList.do")
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardList");

		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);

		return mv;
	}
	
	@RequestMapping(value = "/sample/insertBoard.do")
	public @ResponseBody Map<String, Object> insertBoard(CommandMap commandMap) throws Exception {
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap.getMap());
		Map<String, Object> jsonObject = new HashMap<String, Object>();

		if (list.size() == 0) {
			sampleService.insertBoard(commandMap.getMap());
			list = sampleService.selectBoardList(commandMap.getMap());
		}

		jsonObject.put("memberList", list);

		return jsonObject;
	}

	@RequestMapping(value = "/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");

		if (commandMap.isEmpty() == false) {
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while (iterator.hasNext()) {
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return mv;
	}

	@RequestMapping(value = "/jsonDBTest.do")
	public @ResponseBody Map<String, Object> jsonTest2(Map<String, Object> commandMap) throws Exception {
		List<Map<String, Object>> list = sampleService.selectMemberList(commandMap);
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		jsonObject.put("memberList", list);

		return jsonObject;
	}

	@RequestMapping(value = "/member.do")
	public @ResponseBody Map<String, Object> jsonTest(CommandMap commandMap) throws Exception {
		sampleService.updateMember(commandMap.getMap());
		List<Map<String, Object>> list = sampleService.selectMemberCheck(commandMap.getMap());
		Map<String, Object> jsonObject = new HashMap<String, Object>();

		if (list.size() == 0) {
			sampleService.insertMember(commandMap.getMap());
			list = sampleService.selectMemberCheck(commandMap.getMap());
		}

		jsonObject.put("memberList", list);

		return jsonObject;
	}

	@RequestMapping(value = "/replyTest.do")
	public @ResponseBody Map<String, Object> replyTest(CommandMap commandMap) throws Exception {
		List<Map<String, Object>> list = sampleService.selectReply(commandMap.getMap());
		Map<String, Object> jsonObject = new HashMap<String, Object>();

		// isEmplty() - 값이 비어있으면 true, 값이 있으면 false
		if (commandMap.isEmpty() == false) {
			sampleService.insertReply(commandMap.getMap());
			list = sampleService.selectReply(commandMap.getMap());
		}

		jsonObject.put("replyList", list);

		return jsonObject;
	}
	
	@RequestMapping(value="/repley.do")
	public @ResponseBody Map<String, Object> reply(CommandMap commandMap) throws Exception{
		List<Map<String,Object>> replyList = sampleService.selectReply(commandMap.getMap());
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		// isEmplty() - 값이 비어있으면 true, 값이 있으면 false
		if (commandMap.isEmpty() == false) {
			sampleService.insertReply(commandMap.getMap());
			replyList = sampleService.selectReply(commandMap.getMap());
		}

		jsonObject.put("replyList", replyList);

		return jsonObject;
	}
	
	
	@RequestMapping(value="/infoList.do")
	public @ResponseBody Map<String, Object> infoList(CommandMap command) throws Exception{
		List<Map<String, Object>> infoList = sampleService.selectInfo(command.getMap());
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		jsonObject.put("infoList", infoList);
		
		return jsonObject;
	}
	
	/*/ 파일 데이터 INSERT
	@RequestMapping(value="/dataInput/fileData.do")
	public void fileInputData() throws Exception{

		Map<String, Object> fileDataMap = new HashMap<String, Object>(); 
		
		String confRoot = servletContext.getRealPath("/");
		String filePath = confRoot+"/files";
		//*
		String[] listing = new File(filePath).list();
		for(int i=0; i<listing.length; i++){
			File file = new File(filePath, listing[i]);
			try {
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String s = in.readLine();
				while(s != null)
				{
					log.debug("read : " + s);
					String [] fileData = s.split("#");
					fileDataMap.put("typeCode", fileData[0]);
					fileDataMap.put("contentId", fileData[1]);
					sampleService.insertInfo(fileDataMap);
					s = in.readLine();
				}
				in.close();
				
			} catch(FileNotFoundException e1){
				log.debug("File not found: " + file);
			} catch(IOException e2){
				e2.printStackTrace();
			}
		}
		
	}
	//*/
}
