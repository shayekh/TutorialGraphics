package com.example.android.tutorialgraphics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lion extends AppCompatActivity {
    double xmin1, xmax2, ymin1, ymax2, x11, y11,x22,y22;
    private EditText xmax;
    private EditText xmin;
    private EditText ymax;
    private EditText ymin;
    private EditText x1;
    private EditText y1;
    private EditText x2;
    private EditText y2;
    private Button show;
    private TextView result;
    String t1,t2,t3,t4,t5,t6,t7,t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lion);
        show=(Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = (TextView) findViewById(R.id.result);

                xmin = (EditText) findViewById(R.id.xmin);
                ymin = (EditText) findViewById(R.id.ymin);
                xmax = (EditText) findViewById(R.id.xmax);
                ymax = (EditText) findViewById(R.id.ymax);
                x1 = (EditText) findViewById(R.id.x1);
                y1 = (EditText) findViewById(R.id.y1);
                x2 = (EditText) findViewById(R.id.x2);
                y2 = (EditText) findViewById(R.id.y2);


                t1=xmin.getText().toString();
                t2=ymin.getText().toString();
                t3=xmax.getText().toString();
                t4=ymax.getText().toString();
                t5=x1.getText().toString();
                t6=y1.getText().toString();
                t7=x2.getText().toString();
                t8=y2.getText().toString();
                if(t1.equals("")|| t2.equals("")||t3.equals("")||
                        t4.equals("") ||t5.equals("")|| t6.equals("")||t7.equals("")||t8.equals("")) {
                    result.setTextColor(Color.RED);
                    result.setText(R.string.error_message);
                }
                else
                {
                    xmin1 = Double.parseDouble(xmin.getText().toString());

                    ymin1 = Double.parseDouble(ymin.getText().toString());

                    xmax2 = Double.parseDouble(xmax.getText().toString());

                    ymax2 = Double.parseDouble(ymax.getText().toString());

                    x11 = Double.parseDouble(x1.getText().toString());

                    y11 = Double.parseDouble(y1.getText().toString());
                    x22 = Double.parseDouble(x2.getText().toString());

                    y22 = Double.parseDouble(y2.getText().toString());
                    result.setTextColor(Color.GRAY);
                    result.setText(u(xmin1,ymin1,xmax2,ymax2,x11,y11,x22,y22));


                }
            }
        });

    }
    private String u(double xmin1, double ymin1, double xmax2,
                     double ymax2,double x11,double y11,double x22,double y22)
    {
        double p1,p2,p3,p4,q1,q2,q3,q4,r1,r2,r3,r4,umax,umin,xma,yma,xmi,ymi;

        double delx=x22-x11;
        double dely=y22-y11;
        p1=(-1)*delx;
        p2=delx;
        p3=(-1)*dely;
        p4=dely;
        q1=x11-xmax2;
        q2=xmax2-x11;
        q3=y11-ymax2;
        q4=ymax2-y11;
        r1=q1/p1;
        r2=q2/p2;
        r3=q3/p3;
        r4=q4/p4;
        //if(p1<0)
        double []arrmax=new double[2];
        double [] arrmin=new double[2];
        if(p1<0)
            arrmax[0]=r1;
        if(p2<0)
            arrmax[0]=r2;
        if(p3<0)
            arrmax[1]=r3;
        if(p4<0)
            arrmax[1]=r4;


        if(p1>0)
            arrmin[0]=r1;
        if(p2>0)
            arrmin[0]=r2;
        if(p3>0)
            arrmin[1]=r3;
        if(p4>0)
            arrmin[1]=r4;

         umax=Math.max(0,Math.max(arrmax[0],arrmax[1]));
        umin=Math.min(1,Math.min(arrmin[0],arrmin[1]));
        // x and y for umax
        xma=x11+(umax*delx);
        yma=y11+(umax*dely);

        //x and y for umin
        xmi=x11+(umin*delx);
        ymi=y11+(umin*dely);

        String s="("+Double.toString(xma)+","+Double.toString(yma)+")"+"   "+"("+Double.toString(xmi)+","+Double.toString(ymi)+")";






        return s;

    }
}
