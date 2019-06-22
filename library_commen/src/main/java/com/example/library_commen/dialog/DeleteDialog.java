package com.example.library_commen.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.library_commen.R;
import com.tongdada.base.dialog.base.BaseDialog;

/**
 * Created by gz927 on 19/6/22.
 */

public class DeleteDialog extends BaseDialog {
    TextView cancel;
    TextView commit;
    private int postion;
    private OnClick onClick;
    public DeleteDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void initView() {
        cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        commit=findViewById(R.id.commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onClick(postion);
                dismiss();
            }
        });
    }
    public void show(int postion){
        super.show();
        this.postion=postion;
    }
    @Override
    public void initData() {

    }

    public OnClick getOnClick() {
        return onClick;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public static interface OnClick{
        void onClick(int position);
    }
    @Override
    public int getView() {
        return R.layout.delete_dialog;
    }

}
