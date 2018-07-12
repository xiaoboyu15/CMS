package action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Media;
import service.MediaService;

@Controller
public class MediaAction {
	@Autowired
	private MediaService mediaService;

	// 上传附件测试，测试完成，方法index.jsp测试
	@RequestMapping("/upload")
	public void upload(HttpServletRequest request) throws IllegalStateException, IOException {
		String temp = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		int num = temp.indexOf(".metadata");
		String path = temp.substring(1, num).replace('/', '\\') + request.getContextPath().replaceAll("/", "")
				+ "\\WebContent\\img\\";
		String fileName = path.trim().substring(path.lastIndexOf("/") + 1);
		System.out.println(fileName);
		// 上传文件
		List<String> list = FileUtil.upLoad(request, path);
		request.setAttribute("path", list.get(0));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		Media media = new Media();
		media.setPath(list.get(1));
		media.setRealPath(list.get(0));
		mediaService.insertMedia(media);
		System.out.println("上传成功");

	}
	//获取所有媒体库数据，测试通过
	@RequestMapping("/getAllMedia")
	public ModelAndView getAllMedia() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Media> medias = mediaService.getAllMedia();
		model.put("medias", medias);
		System.out.println(medias.size());
		return new ModelAndView("", model);
	}
	
	//插入媒体，通过
	@RequestMapping("/insertMedia")
	public ModelAndView insertMedia(HttpServletRequest request) throws IllegalStateException, IOException {
		String temp = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		int num = temp.indexOf(".metadata");
		String path = temp.substring(1, num).replace('/', '\\') + request.getContextPath().replaceAll("/", "")
				+ "\\WebContent\\img\\";
		String fileName = path.trim().substring(path.lastIndexOf("/") + 1);
		System.out.println(fileName);

		// 上传文件
		List<String> list = FileUtil.upLoad(request, path);
		request.setAttribute("path", list.get(0));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		Media media = new Media();
		media.setPath(list.get(1));
		media.setRealPath(list.get(0));
		mediaService.insertMedia(media);
		System.out.println("上传成功");
		return new ModelAndView("");
	}
	
	//根据媒体库ID查询,测试通过
	@RequestMapping("/getMediaByID")
	public ModelAndView getMediaByID(int mediaID) {
		Map<String, Object> model = new HashMap<String, Object>();
		Media media = mediaService.getMediaByID(mediaID);
		model.put("media", media);
		return new ModelAndView("", model);
	}
	//根据媒体库ID删除数据库以及上传的文件，测试通过
	@RequestMapping("/deleteMedia")
	public ModelAndView deleteMedia(int mediaID) {
		Media media = mediaService.getMediaByID(mediaID);
		File file = new File(media.getRealPath());
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("文件删除成功");
			} else {
				System.out.println("文件删除失败");
			}
		}
		if (mediaService.deleteMedia(mediaID)) {
			System.out.println("删除成功");
			return new ModelAndView("");
		}
		System.out.println("删除失败");
		return new ModelAndView("");
	}

}
