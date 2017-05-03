package com.play.zv.mytransition;

import android.animation.Animator;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

/**
 * Created by Zv on 2017/05/03.
 */

public class CustomChangeBounds extends ChangeBounds {

    @Override
    public Animator createAnimator(final ViewGroup sceneRoot,
                                   TransitionValues startValues,
                                   final TransitionValues endValues) {
        Animator changeBounds = super.createAnimator(sceneRoot, startValues, endValues);
        if (startValues == null || endValues == null || changeBounds == null)
            return null;

        changeBounds.setDuration(300);
        changeBounds.setInterpolator(AnimationUtils.loadInterpolator(sceneRoot.getContext(),
                android.R.interpolator.fast_out_slow_in));
        return changeBounds;
    }

}