package bean;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="postId")
	private Integer postId;
	
	@Column(name="postTitle")
	private String postTitle;
	
	@Column(name="postDate")
	private String postDate;
	
	@Column(name="postContent")
	private String postContent;	
	
	@Column(name="postLike")
	private String postLike;	
	
	@Column(name="postDislike")
	private String postDislike;	
	
	@Column(name="postComment")
	private String postComment;
	
	public Post() {
	}

	public Integer getpostId() {
		return postId;
	}

	public void setpostId(Integer postId) {
		this.postId = postId;
	}

	public String getpostTitle() {
		return postTitle;
	}

	public void setpostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getpostDate() {
		return postDate;
	}

	public void setpostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getpostContent() {
		return postContent;
	}

	public void setpostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getpostLike() {
		return postLike;
	}

	public void setpostLike(String postLike) {
		this.postLike = postLike;
	}

	public String getpostDislike() {
		return postDislike;
	}

	public void setpostDislike(String postDislike) {
		this.postDislike = postDislike;
	}

	public String getpostComment() {
		return postComment;
	}

	public void setpostComment(String postComment) {
		this.postComment = postComment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post [postId=");
		builder.append(postId);
		builder.append(", postTitle=");
		builder.append(postTitle);
		builder.append(", postDate=");
		builder.append(postDate);
		builder.append(", postContent=");
		builder.append(postContent);
		builder.append(", postLike=");
		builder.append(postLike);
		builder.append(", postDislike=");
		builder.append(postDislike);
		builder.append(", postComment=");
		builder.append(postComment);
		builder.append("]");
		return builder.toString();
	}

	public Post(Integer postId, String postTitle, String postDate, String postContent, String postLike,
			String postDislike, String postComment) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postContent = postContent;
		this.postLike = postLike;
		this.postDislike = postDislike;
		this.postComment = postComment;
	}

	
	


}