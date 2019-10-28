package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.ScientistBO;


@Repository("scDAO")
public class ScientistDAOImpl implements ScientistDAO {
	private static final String ALL_SCIENTIST="SELECT ID,NAME,DOMAIN,EXPERIENCE,PATENTSCOUNT FROM INDIA_SCIENTIST";
	private static final String SCIENTIST_BY_ID="SELECT ID,NAME,DOMAIN,EXPERIENCE,PATENTSCOUNT FROM INDIA_SCIENTIST WHERE ID=?";
	private static final String UPDATE_SCIENTIST="UPDATE INDIA_SCIENTIST SET NAME=?,DOMAIN=?,EXPERIENCE=?,PATENTSCOUNT=? WHERE ID=?";
	private static final String DELETE_SCIENTIST_BY_ID="DELETE FROM INDIA_SCIENTIST WHERE ID=?";
	private static final String ADD_SCIENTIST="INSERT INTO INDIA_SCIENTIST VALUES(?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<ScientistBO> getAllScientist() {
		List<ScientistBO> listBO=null;
		BeanPropertyRowMapper<ScientistBO> rowMapper=null;
		rowMapper=new BeanPropertyRowMapper<ScientistBO>(ScientistBO.class);
		listBO=jt.query(ALL_SCIENTIST, new RowMapperResultSetExtractor<ScientistBO>(rowMapper));
		return listBO;
	}

	@Override
	public ScientistBO getScientistById(int id) {
		ScientistBO bo=null;
		bo=jt.queryForObject(SCIENTIST_BY_ID, new BeanPropertyRowMapper<ScientistBO>(ScientistBO.class),id);
		return bo;
	}

	@Override
	public int updateScientistById(ScientistBO bo) {
		int count=0;
		count=jt.update(UPDATE_SCIENTIST,  bo.getName(),bo.getDomain(),bo.getExperience(),bo.getPatentsCount(),bo.getId());
		
		return count;
	}

	@Override
	public int deleteScientistById(int id) {
		int count=0;
		count=jt.update(DELETE_SCIENTIST_BY_ID, id);
		return count;
	}

	@Override
	public int AddScientist(ScientistBO bo) {
		int count=0;
		count=jt.update(ADD_SCIENTIST, bo.getId(),bo.getName(),bo.getDomain(),bo.getExperience(),bo.getPatentsCount());
		return count;
	}

}
