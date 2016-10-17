package com.pigkins.qa.presentation.view.adapter;

import android.content.Context;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pigkins.qa.R;
import com.pigkins.qa.presentation.model.QuestionModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qding on 10/16/16.
 */
public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder> {

    public interface OnItemClickListener {
        void onQuestionItemClicked(QuestionModel questionModel);
    }

    private OnItemClickListener onItemClickListener;

    private List<QuestionModel> questionCollection;
    private final LayoutInflater layoutInflater;

    @Inject
    public QuestionListAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.questionCollection = Collections.emptyList();
    }

    @Override
    public QuestionListAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestionListAdapter.QuestionViewHolder holder, int position) {
        final QuestionModel questionModel = this.questionCollection.get(position);
        holder.textViewQuestion.setText(questionModel.getQuestion());
        holder.textViewDate.setText(questionModel.getDate().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (QuestionListAdapter.this.onItemClickListener != null) {
                    QuestionListAdapter.this.onItemClickListener.onQuestionItemClicked(questionModel);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (this.questionCollection != null) ? this.questionCollection.size() : 0;
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.question) TextView textViewQuestion;
        @BindView(R.id.date) TextView textViewDate;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setQuestionCollection(Collection<QuestionModel> questionCollection) {
        // TODO(qding): check null
        this.questionCollection = (List<QuestionModel>) questionCollection;
        this.notifyDataSetChanged();
    }
}
