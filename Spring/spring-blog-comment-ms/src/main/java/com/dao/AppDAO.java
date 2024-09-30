package com.dao;

import java.util.List;
import java.util.Optional;

import com.entity.Blogs;
import com.entity.Owner;

public interface AppDAO {
	
	public void addOwner(Owner owner);
	
	//statically adding new blogs and attaching it to the owner
	public void addBlogs(int ownerid);
	
	public void addOwnerAndBlogs(Owner ownerData);
	
	public Owner loadOwnerData(int ownerID);
	
	public Object loadBlogData(int blogID);
	
	public void deleteOwner(int ownerID);
	
	public void addOwnerBlogAndComments(Owner ownerData);
	
	//given the ownerId search for all his comments
	public List<Object[]> findComments(int ownerID);
	

}
