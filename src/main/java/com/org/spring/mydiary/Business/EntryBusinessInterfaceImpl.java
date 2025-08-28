package com.org.spring.mydiary.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.spring.mydiary.dao.EntryDaoInterface;
import com.org.spring.mydiary.entities.Entry;

@Component
public class EntryBusinessInterfaceImpl implements EntryBusinessInterface {
	
	
	
	@Autowired
	private EntryDaoInterface entryDaoInterface;

	public EntryDaoInterface getEntryDaoInterface() {
		return entryDaoInterface;
	}

	public void setEntryDaoInterface(EntryDaoInterface entryDaoInterface) {
		this.entryDaoInterface = entryDaoInterface;
	}

	@Override
	public void save(Entry entry) {

		entryDaoInterface.save(entry);
	}

	@Override
	public void update(Entry entry) {
		entryDaoInterface.update(entry);		
	}

	@Override
	public void delete(Entry entry) {
		entryDaoInterface.delete(entry);		
	}

	@Override
	public Entry findbyId(int id) {
		return entryDaoInterface.findbyId(id);
	}

	@Override
	public List<Entry> findAll() {
		return entryDaoInterface.findAll();
	}

	@Override
	public List<Entry> findByUserid(int id) {
		return entryDaoInterface.findByUserid(id);
	}


	
	

}
