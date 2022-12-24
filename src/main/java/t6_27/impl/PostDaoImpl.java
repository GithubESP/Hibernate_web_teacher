package t6_27.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_27.bean.Post;
import t6_27.dao.PostDao;
import tw.hibernatedemo.util.HibernateUtil;

public class PostDaoImpl implements PostDao {
	private SessionFactory factory;

	public PostDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Post> searchAll() {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Query<Post> query = session.createQuery("from Post", Post.class);
			List<Post> result = query.getResultList();
			session.getTransaction().commit();

			return result;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public int delete(Integer postId) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Post post = session.get(Post.class, postId);
			session.delete(post);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return 0;
	}

	@Override
	public int update(Post post) {
		String hql = "update Post p set p.postTitle=:title, p.postDate=:date, p.postContent=:content, p.postLike=:like, p.postDislike=:dislike, p.postComment=:comment where p.postId=:id";
		Session session = factory.getCurrentSession();
		
			  try {
			   session.beginTransaction();
			   session.createQuery(hql)
			   .setParameter("title", post.getpostTitle())
			     .setParameter("date", post.getpostDate())
			     .setParameter("content", post.getpostContent())
			     .setParameter("like", post.getpostLike())
			     .setParameter("dislike", post.getpostDislike())
			     .setParameter("comment", post.getpostComment())
			     .setParameter("id", post.getpostId())
			     .executeUpdate();
			   session.getTransaction().commit();
			   
			  } catch (Exception e) {
			   session.getTransaction().rollback();
			   e.printStackTrace();
			  }
			  return 0;
			 }


	@Override
	public Post searchById(Integer postId) {
		String hql = "from Post p where p.postId=:id";
		  Session session = factory.getCurrentSession();

		  try {
		   session.beginTransaction();

		   Query<Post> query = session.createQuery(hql, Post.class)
		     .setParameter("id", postId);

		   Post result = query.getSingleResult();
		   session.getTransaction().commit();
		   return result;

		  } catch (Exception e) {
		   session.getTransaction().rollback();
		    return null;
		  }
		 
		 }

	@Override
	public int add(Post post) {
		  Session session = factory.getCurrentSession();


		  try {

		  session.beginTransaction();
		  
		  session.save(post);

		  
		  session.getTransaction().commit();
		  
		 } catch (Exception e) {
		  session.getTransaction().rollback();
		  e.printStackTrace();
		 }
		 return 0;
		}

		}
