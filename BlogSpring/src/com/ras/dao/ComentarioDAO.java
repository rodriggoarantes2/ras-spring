package com.ras.dao;

import java.util.ArrayList;
import java.util.List;

import com.ras.vo.ComentarioVO;
import com.ras.vo.PostVO;

public class ComentarioDAO {
	
	private List<ComentarioVO> listaDAO;

	public ComentarioDAO() {
		listaDAO = new ArrayList<ComentarioVO>(0);
	}

	public ComentarioVO find(int id) {
		ComentarioVO c = new ComentarioVO();
		c = listaDAO.get(listaDAO.indexOf(c));
		
		return c;
	}
	
	public List<ComentarioVO> findAll() {
		return listaDAO;
	}
	
	public void insert(ComentarioVO coment) {
		listaDAO.add(coment);
	}
	
	public ComentarioVO findByPost(PostVO post) {
		
		for (ComentarioVO vo : listaDAO) {
			if (vo.getPost().getId() == post.getId()) {
				return vo;
			}
		}
		
		return null;
	}

}