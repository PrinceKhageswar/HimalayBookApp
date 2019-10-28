package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.ScientistBO;
import com.nt.dao.ScientistDAO;
import com.nt.dto.ScientistDTO;

@Service("scService")
public class ScientistMgmtServiceImpl implements ScientistMgmtService {
	@Autowired
	private ScientistDAO dao;

	@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager",readOnly=true)
	public List<ScientistDTO> fetchAllScientist(){
		List<ScientistBO> listBO=null;
		List<ScientistDTO> listDTO=new ArrayList();
		//use dao;
		listBO=dao.getAllScientist();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			ScientistDTO dto=new ScientistDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrno(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager",readOnly=true)
	public ScientistDTO fetchScientistById(int id) {
		ScientistBO bo=null;
		ScientistDTO dto=null;
		//use dao
		bo=dao.getScientistById(id);
		//convert bo to dto
		dto=new ScientistDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager",readOnly=true)
	public String modifyScientistById(ScientistDTO dto) {
		ScientistBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new ScientistBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.updateScientistById(bo);
		if(count==0)
			return"Scientist are Updated";
		else
		    return "Scientist are not Updated";
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager",readOnly=true)
	public String removeScientistById(int id) {
		String msg=null;
		msg=dao.deleteScientistById(id)==1?"Scientist is removed":"Scientist is not removred";
		return msg;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager",readOnly=true)
	public String registerScientist(ScientistDTO dto) {
		ScientistBO bo=null;
		int count=0;
		//convert  dto to bo
		bo=new ScientistBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.AddScientist(bo);
		if(count==0)
		return "Registration Of Scientist Failed";
		else
		return"Registration Of Scientist Failed";
	}

}
