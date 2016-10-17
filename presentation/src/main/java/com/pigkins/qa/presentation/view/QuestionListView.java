package com.pigkins.qa.presentation.view;

import com.pigkins.qa.presentation.model.QuestionModel;

import java.util.Collection;

/**
 * Created by qding on 10/16/16.
 */
public interface QuestionListView {

    void renderQuestionList(Collection<QuestionModel> questionModelCollection);

    void viewQuestion(QuestionModel questionModel);
}
