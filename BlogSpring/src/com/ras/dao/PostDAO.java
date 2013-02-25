package com.ras.dao;

import java.util.ArrayList;
import java.util.List;

import com.ras.vo.PostVO;

public class PostDAO {
	
	private List<PostVO> listaDAO;

	public PostDAO() {
		
		listaDAO = new ArrayList<PostVO>(0);
		PostVO vo = null;
		for (int x = 0; x < 10; x++) {
			vo = new PostVO();
			vo.setId(x);
			vo.setTitle("objeto:  " + x);
			vo.setBody("-> Post Objeto " + x);
			
			listaDAO.add(vo);
		}
		
	}

	public PostVO find(int id) {
		PostVO o = new PostVO();
		o.setId(id);
		o = listaDAO.get(listaDAO.indexOf(o));
		
		return o;
	}
	
	
	public List<PostVO> findAll() {
		return listaDAO;
	}
	
	public void insert(PostVO post) {
		
		listaDAO.add(post);
		post.setId(listaDAO.indexOf(post));
		
	}
	
	public void update(PostVO post) {
		listaDAO.remove(post);
		listaDAO.add(post);
	}
	
	public void remove(PostVO post) {
		listaDAO.remove(post);
	}

	public List<PostVO> getListaDAO() {
		return listaDAO;
	}

	public void setListaDAO(List<PostVO> listaDAO) {
		this.listaDAO = listaDAO;
	}

}