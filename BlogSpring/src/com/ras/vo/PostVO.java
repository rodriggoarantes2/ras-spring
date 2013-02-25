package com.ras.vo;

import java.util.List;

public class PostVO {
	
	private int id;
	private String title;
	private String body;
	private List<ComentarioVO>  listComentarios;
	 
	 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<ComentarioVO> getListComentarios() {
		return listComentarios;
	}
	public void setListComentarios(List<ComentarioVO> listComentarios) {
		this.listComentarios = listComentarios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj != null
				&& obj instanceof PostVO ) {
			PostVO p = (PostVO) obj;
			if (this.getId() == p.getId()) {
				return true;
			}
		}
		
		return false;
	}
 
 
}