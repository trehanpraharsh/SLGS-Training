package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Blogs;
import com.entity.Comments;
import com.entity.Owner;
import com.repo.BlogsRepo;
import com.repo.OwnerRepo;

//import jakarta.transaction.Transactional;

@Service
public class AppDAOImpl implements AppDAO {
	
	
	@Autowired
	public OwnerRepo ownerRepo;
	
	@Autowired
	public BlogsRepo blogsRepo;
	

	@Override
	@TransactionScoped
	public void addOwner(Owner owner) {
		// TODO Auto-generated method stub
		ownerRepo.save(owner);
		
	}


	@Override
	public void addBlogs(int ownerid) {
		// TODO Auto-generated method stub
		//fetch the owner
		Owner owner = ownerRepo.getById(ownerid);
		//list of blogs
		List<Blogs> blogsList = new ArrayList<Blogs>();
		
		Blogs b1 = new Blogs("Learn Hibernate", "JAVA", "all usefull info");
		b1.setOwner(owner);
		blogsList.add(b1);
		
		Blogs b2 = new Blogs("Learn Spring", "JAVA Advanced", "all usefull info");
		b2.setOwner(owner);
		blogsList.add(b2);
		
		//saving this bloglist to the bloglist that owner maintains with him
		owner.setBlogList(blogsList);
		
		//saving the owner in order to create these blogs and owner gets assigned to these blogs
		ownerRepo.save(owner);
		
		
		
	}


	@Override
	public void addOwnerAndBlogs(Owner ownerData) {
		// TODO Auto-generated method stub
		Owner owner = new Owner(ownerData.getName(), ownerData.getEmail());
		List<Blogs> blogsList = new ArrayList<Blogs>();
		
		for(Blogs blog : ownerData.getBlogList()) {
			Blogs bl1 = new Blogs(blog.getTitle(), blog.getCategory(), blog.getContent());
			bl1.setOwner(owner);
			blogsList.add(bl1);
		}
		
		owner.setBlogList(blogsList);
		ownerRepo.save(owner);
		
	}


	@Override
	public Owner loadOwnerData(int ownerID) {
		// TODO Auto-generated method stub
		return ownerRepo.getById(ownerID);
	}


	@Override
	public Object loadBlogData(int blogID) {
		// TODO Auto-generated method stub
		Optional<Blogs> blogObj = blogsRepo.findById(blogID);
		int blogId = blogObj.get().getBlogID();
		String blogTitle = blogObj.get().getTitle();
		String blogCategory = blogObj.get().getCategory();
		String blogContent = blogObj.get().getContent();
		String ownerName = blogObj.get().getOwner().getName();
		Object newBlogObj[] = {
				 blogId, blogTitle, blogCategory, blogContent, ownerName
		};
		return newBlogObj;
	}


	@Override
	public void deleteOwner(int ownerID) {
		// TODO Auto-generated method stub
		ownerRepo.deleteById(ownerID);
	}


	@Override
	public void addOwnerBlogAndComments(Owner ownerData) {
		// TODO Auto-generated method stub
		Owner owner = new Owner(ownerData.getName(), ownerData.getEmail());
		List<Blogs> blogsList = new ArrayList<Blogs>();
		
		
		for(Blogs blog : ownerData.getBlogList()) {
			Blogs bl1 = new Blogs(blog.getTitle(), blog.getCategory(), blog.getContent());
			List<Comments> commentList = new ArrayList<Comments>();
			
			for (Comments comment : blog.getCommentList()) {
				Comments c1 = new Comments(comment.getCommentBody());
				c1.setBlog(bl1);
				commentList.add(c1);
			}
			bl1.setCommentList(commentList);
			bl1.setOwner(owner);
			blogsList.add(bl1);
		}
		
		owner.setBlogList(blogsList);
		ownerRepo.save(owner);
		
		
	}


	@Override
	public List<Object[]> findComments(int ownerID) {
		// TODO Auto-generated method stub
		List<Object[]> finalList = new ArrayList<Object[]>();
		
		Owner owner = ownerRepo.getById(ownerID);
		List<Blogs> blogListOfOwner = owner.getBlogList();
		for (Blogs blogObj : blogListOfOwner) {
			String blogTitle = blogObj.getTitle();
			List<Comments> commentObj = blogObj.getCommentList();
			for (Comments commentEnt : commentObj) {
				String msg = commentEnt.getCommentBody();
				Object finalObj[] = {blogTitle, msg};
				finalList.add(finalObj);
			}
		}
		return finalList;
	}
	

}
