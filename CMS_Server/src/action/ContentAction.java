package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import entity.Content;
import entity.Media;
import service.ContentService;
import service.MediaService;
import service.TwoLevelService;

@Controller
public class ContentAction {
	@Autowired
	private ContentService contentService;
	@Autowired	
	private MediaService mediaService;
	@Autowired
	private TwoLevelService twoLevelService;
		
	// 根据二级栏目ID获取对应的内容文章,测试完成
	@RequestMapping("/getConByTwo")
	public ModelAndView getConByTwo(int twoLevelID) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Content> contents = contentService.getConByTwo(twoLevelID);
		model.put("contents", contents);
		return new ModelAndView("userindex", model);
	}

	// 根据文章ID获取文章,测试完成
	@RequestMapping("/getConByID")
	public ModelAndView getConByID(int conID) {
		Map<String, Object> model = new HashMap<String, Object>();
		Content content = contentService.getConByID(conID);
		model.put("content", content);
		return new ModelAndView("", model);
	}

	// 插入文章 !!!待测试，原因：测试场景不符!!!
	@RequestMapping("/insertCon")
	public ModelAndView insertCon(HttpSession session,String title, String tags, String source, String author, String editor,
			String richText, String keywords, String top, String twoLevelName, HttpServletRequest request)
			throws IllegalStateException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter = multipartRequest.getFileNames();
		MultipartFile file = multipartRequest.getFile(iter.next().toString());
		String str = file.getOriginalFilename();
		if (!str.equals("")) {
			String temp = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			int num = temp.indexOf(".metadata");
			String path = temp.substring(1, num).replace('/', '\\') + request.getContextPath().replaceAll("/", "")
					+ "\\WebContent\\img\\";
			// 上传文件
			List<String> list = FileUtil.upLoad(request, path);
			request.setAttribute("path", list.get(0));
			Media media = new Media();
			media.setPath(list.get(1));
			media.setRealPath(list.get(0));
			mediaService.insertMedia(media);
			String annex = list.get(1);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Content content = new Content();
			content.setTime(df.format(new Date()));
			content.setTitle(title);
			content.setTags(tags);
			content.setSource(source);
			content.setAuthor(author);
			content.setEditor((String)session.getAttribute("username"));
			content.setRichText(richText);
			content.setKeywords(keywords);
			content.setAnnex(annex);
			content.setTop(top);
			content.setTwoLevelID(twoLevelService.getOnlyTwo(twoLevelName).getTwoLevelID());
			if (contentService.insertCon(content)) {
				return new ModelAndView("neirong");
			}
		}
		return new ModelAndView("neirong");
	}

	// 根据文章ID删除文章,测试完成
	@RequestMapping("/deleteCon")
	public ModelAndView deleteCon(int conID) {
		if (contentService.deleteCon(conID)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}

	// 根据二级栏目ID删除文章（当删除二级栏目时删除该二级栏目下的所有文章），测试成功
	@RequestMapping("/deleteConByTwo")
	public ModelAndView deleteConByTwo(int twoLevelID) {
		if (contentService.deleteConByTwo(twoLevelID)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}

	// 修改文章,待测试
	@RequestMapping("/updateCon")
	public ModelAndView updateCon(String title, String tags, String source, String author, String editor,
			String richText, String keywords, String annex, String top, int twoLevelID) {
		Content content = new Content();
		content.setTitle(title);
		content.setTags(tags);
		content.setSource(source);
		content.setAuthor(author);
		content.setEditor(editor);
		content.setRichText(richText);
		content.setKeywords(keywords);
		content.setAnnex(annex);
		content.setTop(top);
		content.setTwoLevelID(twoLevelID);
		if (contentService.updateCon(content)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}

	// 增加点击数方法，测试成功
	@RequestMapping("/updateConWithClick")
	public ModelAndView updateConWithClick(int conID) {

		Content content = contentService.getConByID(conID);
		int clicks = content.getClicks() + 1;
		content.setClicks(clicks);
		if (contentService.updateConWithClick(content)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}

}
