package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Media;
import mapper.MediaMapper;

@Service
public class MediaService {
	@Autowired
	private MediaMapper mediaMapper;

	public Media getMediaByID(int mediaID) {
		return mediaMapper.getMediaByID(mediaID);
	}

	public Media getMediaByPath(String path) {
		return mediaMapper.getMediaByPath(path);
	}

	public List<Media> getAllMedia() {
		return mediaMapper.getAllMedia();
	}

	public boolean insertMedia(Media media) {
		return mediaMapper.insertMedia(media);
	}

	public boolean deleteMedia(int mediaID) {
		return mediaMapper.deleteMedia(mediaID);
	}

	public boolean updateMedia(Media media) {
		return mediaMapper.updateMedia(media);
	}
}
