package com.example.android.tutorialgraphics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sutherland extends AppCompatActivity {
    //ABRL
    //int a, b, r, l;
    double xmin1, xmax2, ymin1, ymax2, x1, y1;
    private EditText xmax;
    private EditText xmin;
    private EditText ymax;
    private EditText ymin;
    private EditText x;
    private EditText y;
    private Button show;
    private TextView result;
    String t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sutherland);
        show=(Button)findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = (TextView) findViewById(R.id.result);
                xmin = (EditText) findViewById(R.id.xmin);
                ymin = (EditText) findViewById(R.id.ymin);
                xmax = (EditText) findViewById(R.id.xmax);
                ymax = (EditText) findViewById(R.id.ymax);
                x = (EditText) findViewById(R.id.x);
                y = (EditText) findViewById(R.id.y);
                t1=xmin.getText().toString();
                t2=ymin.getText().toString();
                t3=xmax.getText().toString();
                t4=ymax.getText().toString();
                t5=x.getText().toString();
                t6=y.getText().toString();

                if(t1.equals("")|| t2.equals("")||t3.equals("")||
                       t4.equals("") ||t5.equals("")|| t6.equals("")) {
                    result.setTextColor(Color.RED);
                    result.setText(R.string.error_message);
                }
                else {
                    xmin1 = Double.parseDouble(xmin.getText().toString());

                    ymin1 = Double.parseDouble(ymin.getText().toString());

                    xmax2 = Double.parseDouble(xmax.getText().toString());

                    ymax2 = Double.parseDouble(ymax.getText().toString());

                    x1 = Double.parseDouble(x.getText().toString());

                    y1 = Double.parseDouble(y.getText().toString());
                    result.setTextColor(Color.GRAY);
                    result.setText(res(xmin1,ymin1,xmax2,ymax2,x1,y1));
                }

            }
        });


    }

    private String res(double xmin1, double ymin1, double xmax2, double ymax2,double x1,double y1)
    {
int c1,c2,c3,c4;
        double b1=y1-ymax2;
        double b2=ymin1-y1;
        double b3=x1-xmax2;
        double b4=xmin1-x1;
        if(b1>0)
            c1=1;
        else
            c1=0;

        if(b2>0)
            c2=1;
        else
            c2=0;

        if(b3>0)
            c3=1;
        else
            c3=0;

        if(b4>0)
            c4=1;
        else
            c4=0;
        String s=Integer.toString(c1)+Integer.toString(c2)+Integer.toString(c3)
                +Integer.toString(c4);




        return s;


    }


}
