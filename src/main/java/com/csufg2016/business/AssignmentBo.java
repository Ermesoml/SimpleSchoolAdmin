package com.csufg2016.business;

import com.csufg2016.business.contracts.IAssignmentBo;
import com.csufg2016.dao.contracts.AssignmentDaoContract;
import com.csufg2016.entities.Assignment;
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
