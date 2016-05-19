package fatninja.golfscorecard;

/**
 * Created by Juan on 19/05/2016.
 */
public class Hole {
    private String mLabel;
    private int mStrokeCount;

    public Hole (String label, int strokeCount){
        this.mLabel = label;
        this.mStrokeCount = strokeCount;
    }

    public String getmLabel() {
        return mLabel;
    }

    public void setmLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public int getmStrokeCount() {
        return mStrokeCount;
    }

    public void setmStrokeCount(int mStrokeCount) {
        this.mStrokeCount = mStrokeCount;
    }
}
