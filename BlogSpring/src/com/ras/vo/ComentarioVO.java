package com.ras.vo;

 
public class ComentarioVO {
		
	private Long id;
	private String comment;
	private PostVO post;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public PostVO getPost() {
		return post;
	}
	public void setPost(PostVO post) {
		this.post = post;
	}
	
	

	
	@Override
	public boolean equals(Object obj) {
		
		if (obj != null
				&& obj instanceof ComentarioVO ) {
			ComentarioVO p = (ComentarioVO) obj;
			if (this.getId() == p.getId()) {
				return true;
			}
		}
		
		return false;
	}
	 
 
}