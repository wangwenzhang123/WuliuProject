package com.tongdada.base.util;

import android.support.v7.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class PauseOnRecyclerScrollListener extends RecyclerView.OnScrollListener {

    private ImageLoader imageLoader;
    private final boolean pauseOnScroll;
    private final boolean pauseOnFling;
    private final RecyclerView.OnScrollListener externalListener;

    public PauseOnRecyclerScrollListener(ImageLoader imageLoader, boolean pauseOnScroll, boolean pauseOnFling) {
        this(imageLoader, pauseOnScroll, pauseOnFling, null);
    }

    public PauseOnRecyclerScrollListener(ImageLoader imageLoader, boolean pauseOnScroll, boolean pauseOnFling, RecyclerView.OnScrollListener customListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = pauseOnScroll;
        this.pauseOnFling = pauseOnFling;
        this.externalListener = customListener;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            this.imageLoader.resume();

        } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
            if (this.pauseOnScroll) {
                this.imageLoader.pause();
            }

        } else if (newState == RecyclerView.SCROLL_STATE_SETTLING) {
            if (this.pauseOnFling) {
                this.imageLoader.pause();
            }
        }

        if (this.externalListener != null) {
            this.externalListener.onScrollStateChanged(recyclerView, newState);
        }
    }

    /**
     * Callback method to be invoked when the RecyclerView has been scrolled. This will be
     * called after the scroll has completed.
     * <p>
     * This callback will also be called if visible item range changes after a layout
     * calculation. In that case, dx and dy will be 0.
     *
     * @param recyclerView The RecyclerView which scrolled.
     * @param dx           The amount of horizontal scroll.
     * @param dy           The amount of vertical scroll.
     */
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (this.externalListener != null) {
            this.externalListener.onScrolled(recyclerView, dx, dy);
        }
    }

}
