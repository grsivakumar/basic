package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MenuItem;

@RestController
@RequestMapping(value="/Menu")
public class MenuItems {
	
	
	List<MenuItem> l_mi;
	
	public MenuItems() {
		
		l_mi=new ArrayList<MenuItem>();
	}

	@GetMapping("/Menuitems")
	public List<MenuItem> menuItems()
	{
		List<MenuItem> mi=getMenus();
		return mi;
	}
	
	@PostMapping("/Menuitems")
	public MenuItem savemenuItems(@RequestBody MenuItem mi)
	{
		boolean isexist=l_mi.stream().anyMatch(m->m.getMenuName().equals(mi.getMenuName()));
		
		System.out.println(isexist);
		if(isexist)
		{
			
			return null;
		}
		else
		{
			l_mi.add(mi);
			return mi;
		}
		
	}

	private List<MenuItem> getMenus() {
			
		return l_mi;
	}
}
