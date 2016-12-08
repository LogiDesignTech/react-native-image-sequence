package dk.madslee.imageSequence;

import android.graphics.drawable.AnimationDrawable;

/**
 * Created by djohnson1 on 12/8/16.
 * Idea from http://blogs.candoerz.com/question/150720/android-animationdrawable-and-knowing-when-animation-ends.aspx
 */

public class AnimationDrawableListenable extends AnimationDrawable
{
    public interface IAnimationFinishListener
    {
        void onAnimationFinished();
    }

    private IAnimationFinishListener animationFinishListener;

    public IAnimationFinishListener getAnimationFinishListener()
    {
        return animationFinishListener;
    }

    public void setAnimationFinishListener(IAnimationFinishListener animationFinishListener)
    {
        this.animationFinishListener = animationFinishListener;
    }

    @Override
    public boolean selectDrawable(int idx)
    {
        boolean ret = super.selectDrawable(idx);

        if ((idx != 0) && (idx == getNumberOfFrames() - 1))
        {
            if (animationFinishListener != null) animationFinishListener.onAnimationFinished();
        }

        return ret;
    }
}
