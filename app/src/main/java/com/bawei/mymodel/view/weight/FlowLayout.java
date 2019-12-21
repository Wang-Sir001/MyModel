package com.bawei.mymodel.view.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.mymodel.R;

import java.util.List;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;
        int right = 0;
        int buttom = 0;

        int childCount = getChildCount();
        if (childCount > 0){
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);

                child.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = (TextView) child;
                        flowCallback.succes(textView.getText().toString());
                    }
                });

                child.measure(0,0);
                int childMeasuredHeight = child.getMeasuredHeight();
                int childMeasuredWidth = child.getMeasuredWidth();

                DisplayMetrics dm = child.getResources().getDisplayMetrics();
                int widthPixels = dm.widthPixels;

                right = left + childMeasuredWidth;
                if (right > widthPixels){
                    left = 0;
                    right = left+childMeasuredWidth;
                    top = buttom + 30;
                }
                buttom = top + childMeasuredHeight;

                child.layout(left,top,right,buttom);

                left+=childMeasuredWidth+30;
            }
        }
    }

    public void add(List<String> tags){
        if (tags.size()>0){
            for (String tag : tags) {
                TextView textView = new TextView(getContext());

                textView.setText(tag);
                textView.setTextSize(12);
                textView.setPadding(20,0,20,0);
                textView.setBackgroundResource(R.drawable.back);

                addView(textView);
            }
        }
    }
    public void adds(String name){

                TextView textView = new TextView(getContext());

                textView.setText(name);
                textView.setTextSize(12);
                textView.setPadding(20,0,20,0);
                textView.setBackgroundResource(R.drawable.back);

                addView(textView);
    }

    public FlowCallback flowCallback;

    public void setFlowCallback(FlowCallback flowCallback) {
        this.flowCallback = flowCallback;
    }

    public interface FlowCallback{
        void succes(String name);
    }
}
