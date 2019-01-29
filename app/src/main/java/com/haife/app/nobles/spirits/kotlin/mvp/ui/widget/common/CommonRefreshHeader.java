package com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.common;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haife.app.nobles.spirits.kotlin.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import androidx.annotation.NonNull;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/18$
 * TODO:
 */
public class CommonRefreshHeader extends RelativeLayout implements RefreshHeader {
    private ImageView mLoadingHeaderIv;
    private TextView mLoadingHeaderTv;
    private AnimationDrawable mAnimationDrawable;
    private View headerViewContainer;
    private Context mContext;

    public CommonRefreshHeader(Context context) {
        super(context);
        initView(context);
        mContext = context;
    }

    public CommonRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        mContext = context;
    }

    public CommonRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        mContext = context;
    }

    private void initView(Context context) {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(CENTER_IN_PARENT);
        headerViewContainer = View.inflate(context, R.layout.header_layout_common_style, null);
        mLoadingHeaderIv = headerViewContainer.findViewById(R.id.iv_common_header_loading);
        mLoadingHeaderTv = headerViewContainer.findViewById(R.id.tv_common_header_loading);
        addView(headerViewContainer, params);
        setMinimumHeight(DensityUtil.dp2px(60));
    }


    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    /**
     * @param percent       下拉的百分比 值 = offset/headerHeight (0 - percent - (headerHeight+maxDragHeight) / headerHeight )
     * @param offset        下拉的像素偏移量  0 - offset - (headerHeight+maxDragHeight)
     * @param maxDragHeight 最大拖动高度
     */
    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

        mLoadingHeaderIv.setScaleX(percent * 1.0f);
        mLoadingHeaderIv.setScaleY(percent * 1.0f);
    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (success)
            mLoadingHeaderTv.setText(getContext().getString(R.string.head_refreshing_status_success_desc));
        else
            mLoadingHeaderTv.setText(getContext().getString(R.string.head_refreshing_status_failed_desc));

        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }

        return 500;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None: // 无状态
            case PullDownToRefresh:// 可以下拉状态
                headerViewContainer.setVisibility(VISIBLE);
                mLoadingHeaderTv.setText(getContext().getString(R.string.pull_down_refresh_desc));
                break;
            case ReleaseToRefresh:
                mLoadingHeaderTv.setText(mContext.getString(R.string.release_to_refresh_desc));
                break;
            case RefreshReleased:
            case Refreshing: // 刷新中状态
                mLoadingHeaderTv.setText(getContext().getString(R.string.head_pull_down_status_desc));
                break;

        }
        startAnimator();
    }

    private void startAnimator() {
        mLoadingHeaderIv.setImageResource(R.drawable.animtion_common_refresh_header);
        mAnimationDrawable = (AnimationDrawable) mLoadingHeaderIv.getDrawable();
        mAnimationDrawable.start();
    }


}
