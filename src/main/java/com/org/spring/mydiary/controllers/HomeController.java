package com.org.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.spring.mydiary.Business.EntryBusinessInterface;
import com.org.spring.mydiary.Business.UserBusinessInterface;
import com.org.spring.mydiary.entities.Entry;
import com.org.spring.mydiary.entities.User;

@Controller
public class HomeController {
	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserBusinessInterface  userBusinessInterface;

	public UserBusinessInterface getUserBusinessInterface() {
		return userBusinessInterface;
	}

	public void setUserBusinessInterface(UserBusinessInterface userBusinessInterface) {
		this.userBusinessInterface = userBusinessInterface;
	}
	
	@Autowired
	private EntryBusinessInterface entryBusinessInterface;
	
	
	public EntryBusinessInterface getEntryBusinessInterface() {
		return entryBusinessInterface;
	}

	public void setEntryBusinessInterface(EntryBusinessInterface entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}


	@RequestMapping("/home")
	public ModelAndView homepage()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("login");
		return model;
		
	}

	
	@RequestMapping("/register")
	public ModelAndView registrationpage()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("register");
		return model;
		
	}
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user")  User user)
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("registersuccess");
	    userBusinessInterface.save(user);	
		return model;
		
	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("user")  User user )
	{
		ModelAndView model=new ModelAndView("login");
		
		User user1=userBusinessInterface.findByUsername(user.getUsername());
		if(user1!=null){
			if(user.getPassword().equals(user1.getPassword())){
			model.setViewName("userhomepage");
			model.addObject("user", user1);
			session.setAttribute("user", user1);
			List<Entry> entries=null;
			
			try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			model.addObject("entrieslist", entries);
      	}
		}
		return model;
	}
	
	
	@RequestMapping("addentry")
	public ModelAndView addentry()	{
		ModelAndView model=new ModelAndView("addentryform");
		return model;	
	}

	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry") Entry entry){
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.save(entry);
		User user1=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
		entries=entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;
	}
	
	
	@RequestMapping("viewentry")
	public ModelAndView viewentry(@RequestParam("id") int id){
		ModelAndView model=new ModelAndView("displayentry");
		Entry entry=entryBusinessInterface.findbyId(id);
		model.addObject("entry", entry);
		return model;
	}
	@RequestMapping("userhome")
	public ModelAndView userhomepage(){
		ModelAndView model=new ModelAndView("userhomepage");
		User user1=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
		entries=entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id") int id)	{
		ModelAndView model=new ModelAndView("displayupdateentry");
		Entry entry=entryBusinessInterface.findbyId(id);
		model.addObject("entry", entry);
		User user1=(User)session.getAttribute("user");
		if(user1==null){
			model.setViewName("login");
		}
		return model;
	}
	
	@RequestMapping("processentryupdate")
	public ModelAndView processentryupdate(@ModelAttribute("entry") Entry entry){
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.update(entry);
		User user1=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
		entries=entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;	
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id") int id){
		ModelAndView model=new ModelAndView("userhomepage");
        User user1=(User)session.getAttribute("user");
		Entry entry=entryBusinessInterface.findbyId(id);
		if(user1==null){
			model.setViewName("login");
		}
		else {
			entryBusinessInterface.delete(entry);

		}
		List<Entry> entries=null;
		try {
		entries=entryBusinessInterface.findByUserid(user1.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;
			
	}

	@RequestMapping("/signout")
	public ModelAndView signoutpage(){
		ModelAndView model=new ModelAndView();
		model.setViewName("login");
		session.invalidate();
		return model;
	}
	
}

