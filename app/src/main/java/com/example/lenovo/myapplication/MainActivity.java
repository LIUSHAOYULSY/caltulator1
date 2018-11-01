package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button BtnQu;
    Button BtnRooting;
    Button BtnSquare;
    Button BtnReciprocal;
    Button BtnC;
    Button BtnCE;
    Button BtnBack;
    Button BtnDivide;
    Button Btn7;
    Button Btn8;
    Button Btn9;
    Button Btn0;
    Button Btn1;
    Button Btn2;
    Button Btn3;
    Button Btn4;
    Button Btn5;
    Button Btn6;
    Button BtnMultiply;
    Button BtnMinus;
    Button BtnPlus;
    Button BtnSign;
    Button BtnPoint;
    Button BtnEqual;
    EditText et_input;
    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn0= (Button) findViewById(R.id.Btn0);
        Btn1= (Button) findViewById(R.id.Btn1);
        Btn2= (Button) findViewById(R.id.Btn2);
        Btn3= (Button) findViewById(R.id.Btn3);
        Btn4= (Button) findViewById(R.id.Btn4);
        Btn5= (Button) findViewById(R.id.Btn5);
        Btn6= (Button) findViewById(R.id.Btn6);
        Btn7= (Button) findViewById(R.id.Btn7);
        Btn8= (Button) findViewById(R.id.Btn8);
        Btn9= (Button) findViewById(R.id.Btn9);
        BtnQu= (Button) findViewById(R.id.BtnQu);
        BtnRooting= (Button) findViewById(R.id.BtnRooting);
        BtnSquare= (Button) findViewById(R.id.BtnSquare);
        BtnReciprocal= (Button) findViewById(R.id.BtnReciprocal);
        BtnC= (Button) findViewById(R.id.BtnC);
        BtnCE= (Button) findViewById(R.id.BtnCE);
        BtnBack= (Button) findViewById(R.id.BtnBack);
        BtnDivide= (Button) findViewById(R.id.BtnDivide);
        BtnMultiply= (Button) findViewById(R.id.BtnMultiply);
        BtnMinus= (Button) findViewById(R.id.BtnMinus);
        BtnPlus= (Button) findViewById(R.id.BtnPlus);
        BtnSign= (Button) findViewById(R.id.BtnSign);
        BtnPoint= (Button) findViewById(R.id.BtnPoint);
        BtnEqual= (Button) findViewById(R.id.BtnEqual);
        Btn0.setOnClickListener(this);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        Btn4.setOnClickListener(this);
        Btn5.setOnClickListener(this);
        Btn6.setOnClickListener(this);
        Btn7.setOnClickListener(this);
        Btn8.setOnClickListener(this);
        Btn9.setOnClickListener(this);
        BtnQu.setOnClickListener(this);
        BtnC.setOnClickListener(this);
        BtnCE.setOnClickListener(this);
        BtnSign.setOnClickListener(this);
        BtnSquare.setOnClickListener(this);
        BtnMinus.setOnClickListener(this);
        BtnMultiply.setOnClickListener(this);
        BtnReciprocal.setOnClickListener(this);
        BtnRooting.setOnClickListener(this);
        BtnDivide.setOnClickListener(this);
        BtnBack.setOnClickListener(this);
        BtnPlus.setOnClickListener(this);
        BtnEqual.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        String str = et_input.getText().toString();
        switch (view.getId()) {
            case R.id.Btn0:
            case R.id.Btn1:
            case R.id.Btn3:
            case R.id.Btn4:
            case R.id.Btn5:
            case R.id.Btn6:
            case R.id.Btn7:
            case R.id.Btn8:
            case R.id.Btn9:
            case R.id.Btn2:
            case R.id.BtnPoint:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)view).getText());
                break;
            case R.id.BtnPlus:
            case R.id.BtnMinus:
            case R.id.BtnMultiply:
            case R.id.BtnDivide:
                if(clear_flag)
                { clear_flag=false;
                    str="";
                    et_input.setText("");}

                if (str.contains("＋") || str.contains("－") || str.contains("×") || str.contains("÷")) {
                    str = str.substring(0, str.indexOf(" "));
                }

                et_input.setText(str + " " + ((Button) view).getText() + " ");
                break;
            case R.id.BtnC:
            case R.id.BtnCE:
                if(clear_flag)
                    clear_flag=false;
                str="";
                et_input.setText("");
                break;
            case R.id.BtnBack:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.BtnEqual:
                getResult();
                break;
        }
    }
    private void getResult() {
        String exp = et_input.getText().toString();
        if(exp==null||exp.equals("")) return ;
        if(!exp.contains(" ")){
            return ;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        double cnt=0;
        if(!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d1+d2;
            }
            if(op.equals("-")){
                cnt=d1-d2;
            }
            if(op.equals("×")){
                cnt=d1*d2;
            }
            if(op.equals("÷")){
                if(d2==0) cnt=0;
                else cnt=d1/d2;
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")) {
                int res = (int) cnt;
                et_input.setText(res+"");
            }else {
                et_input.setText(cnt+"");}
        }
        else if(!s1.equals("")&&s2.equals("")){
            double d1=Double.parseDouble(s1);
            if(op.equals("x²"))
            {  cnt=d1*d1;}
            else if(op.equals("1/x"))
            {if(clear_flag=false)
                et_input.setText("除数不能为零");
            else
                cnt=1/d1;}
            else if (op.equals("√")) {
                if (d1< 0) {
                    et_input.setText("无效输入");
                } else
                    cnt = Math.sqrt(d1);
            }

            else if(op.equals("±"))
            {  cnt=-d1;
            }
            if(!s1.contains(".")) {
                int res = (int) cnt;
                et_input.setText(res+"");
            }else {
                et_input.setText(cnt+"");}
        }

        else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d2;
            }
            if(op.equals("-")){
                cnt=0-d2;
            }
            if(op.equals("×")){
                cnt=0;
            }
            if(op.equals("÷")){
                if(clear_flag=false)
                et_input.setText("结果未定义");
               else cnt=0;
            }
            if(!s2.contains(".")) {
                int res = (int) cnt;
                et_input.setText(res+"");
            }else {
                et_input.setText(cnt+"");}
        }
        else {
            et_input.setText("");
        }
    }
}

