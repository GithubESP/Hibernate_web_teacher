package t6_27.impl;

import java.util.List;
import t6_27.bean.Post;
import t6_27.dao.PostDao;
import t6_27.service.PostService;

public class PostServiceImpl implements PostService {
	PostDao postDao = new PostDaoImpl();

	@Override
	public List<Post> searchAll() {
		List<Post> postList = null;

		List<Post> temp = postDao.searchAll();
		if (temp != null) {
			postList = temp;
		}
		return postList;
	}

	@Override
	public Post searchById(int postId) {
		Post post = postDao.searchById(postId);
		return post;
	}

	@Override
	public int add(Post post) {
		int result = postDao.add(post);
		return result;
	}

	@Override
	public int delete(int postId) {
		int result = postDao.delete(postId);
		return result;
	}

	@Override
	public int update(Post post) {
		int result = postDao.update(post);
		return result;
	}
}
