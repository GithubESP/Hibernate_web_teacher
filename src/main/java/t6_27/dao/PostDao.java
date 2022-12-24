package dao;

import java.util.List;
import bean.Post;


public interface PostDao {

public List<Post> searchAll();
	
	public Post searchById(Integer postId);
	
	public int delete(Integer postId);
	public int update(Post post);
	public int add(Post post);

	
}
