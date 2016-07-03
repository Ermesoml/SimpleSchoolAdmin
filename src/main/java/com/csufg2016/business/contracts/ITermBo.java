package com.csufg2016.business.contracts;

import com.csufg2016.Utils.Pair;
import com.csufg2016.entities.Course;
import com.csufg2016.entities.Teacher;
import com.csufg2016.entities.Term;

import java.util.List;

public interface ITermBo extends BusinessContract<Term> {

    void newTerm(Term term, List<Pair<Course, Teacher>> courses);
    Term retrieveTermById(long id);
    void updateTerm(Term term);
    void deleteTerm(Term term);

}
