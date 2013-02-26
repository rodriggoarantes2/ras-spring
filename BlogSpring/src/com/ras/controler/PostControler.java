package com.ras.controler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ras.dao.ComentarioDAO;
import com.ras.dao.PostDAO;
import com.ras.vo.ComentarioVO;
import com.ras.vo.PostVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class PostControler {
	
	private static final Logger log = Logger.getLogger(PostControler.class);

	@Autowired
	private PostDAO postDao;

	@Autowired
	private ComentarioDAO comentarioDao; 
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("posts", postDao.findAll());
		return "/site/list.jsp";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String show(@PathVariable int id, ModelMap modelMap) {
		
		log.debug("show");
		
		PostVO vo = postDao.find(id);
		
		modelMap.addAttribute("post", vo);
		modelMap.addAttribute("comments", comentarioDao.findByPost(vo));
		
		modelMap.addAttribute("comment", new ComentarioVO());
		return "/site/show.jsp";
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {
		PostVO post = new PostVO();
		post.setId(id);
		postDao.remove(post);
		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/form", method = RequestMethod.GET)
	public String form(ModelMap modelMap) {
		modelMap.addAttribute("post", new PostVO());
		return "/site/create.jsp";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String create(PostVO post, BindingResult result) {
		if (result.hasErrors())
			return "/site/create.jsp";           

		postDao.insert(post);
		
		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("post", postDao.find(id));
		return "/site/update.jsp";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(PostVO post, BindingResult result) {
		if (result.hasErrors())
			return "/site/update.jsp";     

		postDao.update(post);
		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.POST)
	public String comentar(ComentarioVO comment, BindingResult result, @PathVariable("id") int id) {

		PostVO post = postDao.find(id);
		if (result.hasErrors())
			return "posts/"+id;

		comment.setPost(post);
		comentarioDao.insert(comment);
		
		return "redirect:/posts/"+id;
	}


}

