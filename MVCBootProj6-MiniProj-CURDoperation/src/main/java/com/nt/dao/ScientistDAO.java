package com.nt.dao;

import java.util.List;

import com.nt.bo.ScientistBO;

public interface ScientistDAO {
	
	public List<ScientistBO> getAllScientist();
	public ScientistBO getScientistById(int id);
	public int updateScientistById(ScientistBO bo);
	public int deleteScientistById(int id);
	public int AddScientist(ScientistBO bo);

}
