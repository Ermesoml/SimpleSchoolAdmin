package br.ufg.inf.business.contracts;

import br.ufg.inf.Utils.Pair;
import br.ufg.inf.entities.Term;
import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.Teacher;

import java.util.List;

/**
 * The Interface ITermBo.
 */
public interface ITermBo extends BusinessContract<Term> {

    /**
     * New term.
     *
     * @param term the term
     * @param courses the courses
     */
    void newTerm(Term term, List<Pair<Course, Teacher>> courses);
    
    /**
     * Retrieve term by id.
     *
     * @param id the id
     * @return the term
     */
    Term retrieveTermById(long id);
    
    /**
     * Update term.
     *
     * @param term the term
     */
    void updateTerm(Term term);
    
    /**
     * Delete term.
     *
     * @param term the term
     */
    void deleteTerm(Term term);

}
