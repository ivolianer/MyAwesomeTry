package com.example.MyAwesomeTry;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;


public class BootstrapEditText extends EditText {

    // =========== 枚举类 ===========

    enum State {
        DEFAULT,
        SUCCESS,
        WARNING,
        DANGER;

        public static State intToState(int value) {

            switch (value) {
                case 0:
                    return DEFAULT;
                case 1:
                    return SUCCESS;
                case 2:
                    return WARNING;
                case 3:
                    return DANGER;
            }

            return DEFAULT;
        }
    }

    // =========== 私有属性 ===========

    // 默认非圆角
    private boolean roundedCorners = false;

    // =========== 构造函数 ===========

    public BootstrapEditText(Context context) {

        super(context);
        this.initialize();
    }

    public BootstrapEditText(Context context, AttributeSet attrs) {

        super(context, attrs);
        initialize(attrs);
    }

    public BootstrapEditText(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        initialize(attrs);
    }

    // =========== 私有函数 ===========

    private void initialize() {

        setState(State.DEFAULT);
    }

    private void initialize(AttributeSet attrs) {

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapEditText);

        roundedCorners = typedArray.getBoolean(R.styleable.BootstrapEditText_roundedCorners, false);

        int state = typedArray.getInt(R.styleable.BootstrapEditText_state, 0);
        setState(State.intToState(state));

        typedArray.recycle();
    }

    //  ============ 共有方法 ============

    public void setState(State state) {

        switch (state) {
            case DEFAULT:
                setBackgroundResource(roundedCorners ? R.drawable.edittext_background_rounded_default
                                : R.drawable.edittext_background_default
                );
                break;
            case SUCCESS:
                setBackgroundResource(roundedCorners ? R.drawable.edittext_background_rounded_success
                                : R.drawable.edittext_background_success
                );
                break;
            case WARNING:
                setBackgroundResource(roundedCorners ? R.drawable.edittext_background_rounded_warning
                                : R.drawable.edittext_background_warning
                );
                break;
            case DANGER:
                setBackgroundResource(roundedCorners ? R.drawable.edittext_background_rounded_danger
                                : R.drawable.edittext_background_danger
                );
                break;
        }
    }

}
