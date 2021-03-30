package com.watayouxiang.mykotlin._06_advancedfunctions.sam;

import java.util.HashSet;

public class EventManager {
    private final HashSet<OnEventListener> onEventListeners = new HashSet<>();

    public void addOnEventListener(OnEventListener onEventListener) {
        this.onEventListeners.add(onEventListener);
    }

    public void removeOnEventListener(OnEventListener onEventListener) {
        this.onEventListeners.remove(onEventListener);
    }

    public interface OnEventListener {
        void onEvent(int event);
    }
}
