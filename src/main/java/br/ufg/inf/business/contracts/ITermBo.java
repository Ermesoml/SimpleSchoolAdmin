package br.ufg.inf.business.contracts;

import br.ufg.inf.Utils.Pair;
import br.ufg.inf.entities.Term;
import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.Teacher;

import java.util.List;

public interface ITermBo extends BusinessContract<Term> {

    void newTerm(Term term, List<Pair<Course, Teacher>> courses);
    Term retrieveTermById(long id);
    void updateTerm(Term term);
    void deleteTerm(Term term);

}
