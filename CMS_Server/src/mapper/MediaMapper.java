package mapper;

import java.util.List;

import entity.Media;

public interface MediaMapper {
	public Media getMediaByID(int mediaID);

	public Media getMediaByPath(String path);

	public List<Media> getAllMedia();

	public boolean insertMedia(Media media);

	public boolean deleteMedia(int mediaID);

	public boolean updateMedia(Media media);
}
