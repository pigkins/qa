package com.pigkins.qa.presentation.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.pigkins.qa.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_ToQuestionList) Button btn_ToQuestionList;
    @BindView(R.id.btn_ToWeightList) Button btn_ToWeightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_ToWeightList)
    void navigateToWeightList() {
        this.navigator.navigateToWeightList(this);
    }

    @OnClick(R.id.btn_ToQuestionList)
    void navigateToQuestionList() {
        this.navigator.navigateToQAList(this);
    }
}
