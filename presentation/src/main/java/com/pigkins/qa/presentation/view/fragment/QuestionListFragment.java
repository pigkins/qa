package com.pigkins.qa.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pigkins.qa.R;
import com.pigkins.qa.presentation.internal.di.components.QuestionComponent;
import com.pigkins.qa.presentation.model.QuestionModel;
import com.pigkins.qa.presentation.presenter.QuestionListPresenter;
import com.pigkins.qa.presentation.view.QuestionListView;
import com.pigkins.qa.presentation.view.adapter.QuestionListAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class QuestionListFragment extends BaseFragment implements QuestionListView {


    public interface QuestionListListener {
        void onQuestionClicked(final QuestionModel questionModel);
    }

    @Inject QuestionListPresenter questionListPresenter;
    @Inject QuestionListAdapter questionListAdapter;


    @BindView(R.id.rv_question_list) RecyclerView rv_question_list;

    private QuestionListListener questionListListener;
    private Unbinder unbinder;

    public QuestionListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof QuestionListListener) {
            this.questionListListener = (QuestionListListener) context;
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(QuestionComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_question_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.questionListPresenter.setView(this);
        if (savedInstanceState == null) {
                this.questionListPresenter.initialize(this.getActivity().getApplicationContext());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.questionListPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.questionListPresenter.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_question_list.setAdapter(null);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.questionListPresenter.onDestroy();
    }

    @Override public void onDetach() {
        super.onDetach();
        this.questionListListener = null;
    }

    public Context context() {
        return this.getActivity().getApplicationContext();
    }


    @Override
    public void renderQuestionList(Collection<QuestionModel> questionModelCollection) {
        if (questionModelCollection != null) {
            this.questionListAdapter.setQuestionCollection(questionModelCollection);
        }
    }


    @Override
    public void viewQuestion(QuestionModel questionModel) {
        showToastMessage(questionModel.toString());
    }


    private void setupRecyclerView() {
        this.questionListAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_question_list.setLayoutManager(new LinearLayoutManager(context()));
        this.rv_question_list.setAdapter(questionListAdapter);
    }


    private QuestionListAdapter.OnItemClickListener onItemClickListener =
            new QuestionListAdapter.OnItemClickListener() {
                @Override
                public void onQuestionItemClicked(QuestionModel questionModel) {
                    if (QuestionListFragment.this.questionListPresenter != null && questionModel != null) {
                        QuestionListFragment.this.questionListPresenter.onQuestionClicked(questionModel);
                    }
                }
            };
}
