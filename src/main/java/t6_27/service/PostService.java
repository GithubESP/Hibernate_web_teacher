package t6_27.service;

import java.util.List;

import t6_27.bean.Post;

public interface PostService {
	public List<Post> searchAll();
	
	public Post searchById(int postId);
	public int add(Post post);
	public int delete(int postId);
	public int update(Post post);

}
