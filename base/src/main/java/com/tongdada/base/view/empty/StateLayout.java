package com.tongdada.base.view.empty;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tongdada.base.R;


/**
 * description：状态视图
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/3 9:28
 * <p>
 */

public class StateLayout extends RelativeLayout implements IStateLayout<StateLayout> {
    private int mCurrentState;
    private View mEmptyView;
    private View mLoadingView;
    private View mErrorView;
    private EmptyViewHolder mEmptyViewHolder;
    private LoadingViewHolder mLoadingViewHolder;
    private ErrorViewHolder mErrorViewHolder;
    private int mEmptyViewId, mLoadingViewId, mErrorViewId;
    private boolean isEnableState = true;

    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleTypedArray(context, attrs);
        initViews();
    }

    private void handleTypedArray(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StateLayout);
        mEmptyViewId = a.getResourceId(R.styleable.StateLayout_slEmptyLayout, R.layout.view_empty_state_layout);
        mLoadingViewId = a.getResourceId(R.styleable.StateLayout_slLoadingLayout, R.layout.view_loading_state_layout);
        mErrorViewId = a.getResourceId(R.styleable.StateLayout_slErrorLayout, R.layout.view_error_state_layout);
        a.recycle();
    }

    private void initViews() {
        LayoutInflater mInflate = LayoutInflater.from(getContext());
        mEmptyView = mInflate.inflate(mEmptyViewId, this, false);
        mLoadingView = mInflate.inflate(mLoadingViewId, this, false);
        mErrorView = mInflate.inflate(mErrorViewId, this, false);
        LayoutParams rlp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(mEmptyView, rlp);
        addView(mLoadingView, rlp);
        addView(mErrorView, rlp);

        mErrorViewHolder = new ErrorViewHolder(mErrorView);
        mEmptyViewHolder = new EmptyViewHolder(mEmptyView);
        mLoadingViewHolder = new LoadingViewHolder(mLoadingView);
    }

    public int getCurrentState() {
        return mCurrentState;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mEmptyView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        mCurrentState = LayoutStates.STATE_HIDE;
    }

    @Override
    public void setEnableStateLayout(boolean enabled) {
        isEnableState = enabled;
    }

    @Override
    public StateLayout showEmptyView() {
        if (!isEnableState) {
            return this;
        }
        mEmptyView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mCurrentState = LayoutStates.STATE_EMPTY;
        return this;
    }

    @Override
    public StateLayout showEmptyView(View view) {
        if (!isEnableState) {
            return this;
        }
        View tempView = mEmptyView;
        mEmptyView = view;
        removeView(tempView);
        addView(mEmptyView);
        return this;
    }

    @Override
    public StateLayout showEmptyView(int msgId) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyMessage.setText(msgId);
        }
        return this;
    }

    @Override
    public StateLayout showEmptyView(int msgId, int imgId) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyMessage.setText(msgId);
            mEmptyViewHolder.ivEmptyImage.setImageResource(imgId);
        }
        return this;
    }

    @Override
    public StateLayout showEmptyView(String msg) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyMessage.setText(msg);
        }
        return this;
    }

    @Override
    public StateLayout showEmptyView(String msg, int imgId) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyMessage.setText(msg);
            mEmptyViewHolder.ivEmptyImage.setImageResource(imgId);
        }
        return this;
    }

    @Override
    public StateLayout showEmptyViewButton(OnClickListener listener) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyButton.setVisibility(View.VISIBLE);
            mEmptyViewHolder.tvEmptyButton.setOnClickListener(listener);
        }
        return null;
    }

    @Override
    public StateLayout showEmptyViewButton(int resId, OnClickListener listener) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyButton.setVisibility(View.VISIBLE);
            mEmptyViewHolder.tvEmptyButton.setText(resId);
            mEmptyViewHolder.tvEmptyButton.setOnClickListener(listener);
        }
        return null;
    }

    @Override
    public StateLayout showEmptyViewButton(String btnText, OnClickListener listener) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultEmptyView()) {
            mEmptyViewHolder.tvEmptyButton.setVisibility(View.VISIBLE);
            mEmptyViewHolder.tvEmptyButton.setText(btnText);
            mEmptyViewHolder.tvEmptyButton.setOnClickListener(listener);
        }
        return null;
    }

    @Override
    public EmptyViewHolder getEmptyViewHolder() {
        return mEmptyViewHolder;
    }

    private boolean isDefaultEmptyView() {
        return mEmptyViewId == R.layout.view_empty_state_layout;
    }

    @Override
    public StateLayout showErrorView() {
        if (!isEnableState) {
            return this;
        }
        mEmptyView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        mCurrentState = LayoutStates.STATE_ERROR;
        return this;
    }

    @Override
    public StateLayout showErrorView(View view) {
        if (!isEnableState) {
            return this;
        }
        View tempView = mErrorView;
        mErrorView = view;
        removeView(tempView);
        addView(mErrorView);
        return this;
    }

    @Override
    public StateLayout showErrorView(int msgId) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorMessage.setText(msgId);
        }
        return this;
    }

    @Override
    public StateLayout showErrorView(int msgId, int imgId) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorMessage.setText(msgId);
            mErrorViewHolder.ivErrorImage.setImageResource(imgId);
        }
        return this;
    }

    @Override
    public StateLayout showErrorView(String msg) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorMessage.setText(msg);
        }
        return this;
    }

    @Override
    public StateLayout showErrorView(String msg, int imgId) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorMessage.setText(msg);
            mErrorViewHolder.ivErrorImage.setImageResource(imgId);
        }
        return this;
    }

    @Override
    public StateLayout showErrorViewButton(OnClickListener listener) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorButton.setOnClickListener(listener);
        }
        return this;
    }

    @Override
    public StateLayout showErrorViewButton(String btnText, OnClickListener listener) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorButton.setText(btnText);
            mErrorViewHolder.tvErrorButton.setOnClickListener(listener);
        }
        return this;
    }

    @Override
    public StateLayout showErrorViewButton(int resId, OnClickListener listener) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultErrorView()) {
            mErrorViewHolder.tvErrorButton.setText(resId);
            mErrorViewHolder.tvErrorButton.setOnClickListener(listener);
        }
        return this;
    }

    @Override
    public ErrorViewHolder getErrorViewHolder() {
        return mErrorViewHolder;
    }

    private boolean isDefaultErrorView() {
        return mErrorViewId == R.layout.view_error_state_layout;
    }

    @Override
    public StateLayout showLoadingView() {
        if (!isEnableState) {
            return this;
        }
        mEmptyView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        mCurrentState = LayoutStates.STATE_LOADING;
        return this;
    }

    @Override
    public StateLayout showLoadingView(View view) {
        if (!isEnableState) {
            return this;
        }
        View tempView = mLoadingView;
        mLoadingView = view;
        removeView(tempView);
        addView(mLoadingView);
        return this;
    }

    @Override
    public StateLayout showLoadingView(String msg) {
        if (!isEnableState) {
            return this;
        }
        if (isDefaultLoadingView()) {
            mLoadingViewHolder.tvLoadingMessage.setText(msg);
        }
        return this;
    }

    @Override
    public LoadingViewHolder getLoadingViewHolder() {
        return mLoadingViewHolder;
    }

    private boolean isDefaultLoadingView() {
        return mLoadingViewId == R.layout.view_loading_state_layout;
    }

    @Override
    public StateLayout hideStateView() {
        if (!isEnableState) {
            return this;
        }
        mEmptyView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mCurrentState = LayoutStates.STATE_HIDE;
        return this;
    }


    public static class EmptyViewHolder {
        ImageView ivEmptyImage;
        TextView tvEmptyMessage;
        TextView tvEmptyButton;

        public EmptyViewHolder(View view) {
            ivEmptyImage = (ImageView) view.findViewById(R.id.iv_empty_image);
            tvEmptyMessage = (TextView) view.findViewById(R.id.tv_empty_message);
            tvEmptyButton = (TextView) view.findViewById(R.id.tv_retry);
        }
    }

    public static class ErrorViewHolder {
        ImageView ivErrorImage;
        TextView tvErrorMessage;
        TextView tvErrorButton;

        public ErrorViewHolder(View view) {
            ivErrorImage = (ImageView) view.findViewById(R.id.iv_error_image);
            tvErrorMessage = (TextView) view.findViewById(R.id.tv_error_message);
            tvErrorButton = (TextView) view.findViewById(R.id.tv_retry);
        }
    }

    public static class LoadingViewHolder {
        ProgressBar pbLoading;
        TextView tvLoadingMessage;

        public LoadingViewHolder(View view) {
            pbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
            tvLoadingMessage = (TextView) view.findViewById(R.id.tv_empty_message);
        }
    }
}
