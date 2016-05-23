package com.pwufg2015.business;

import com.pwufg2015.business.contracts.IAssignmentBo;
import com.pwufg2015.dao.contracts.AssignmentDaoContract;
import com.pwufg2015.entities.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AssignmentService")
public class AssignmentBo implements IAssignmentBo {

	@Autowired
	AssignmentDaoContract assignment;

	@Override
	public List<Assignment> listAll() {
		return null;
	}
}
