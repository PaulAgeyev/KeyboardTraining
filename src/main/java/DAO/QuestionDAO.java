package DAO;

import Domain.Question;

import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
interface QuestionDAO {

    ArrayList<Question> findByID();

    boolean insertQuestion(Question question);
    boolean updateQuestion(Question question);
    boolean deleteQuestion(Question question);
}
