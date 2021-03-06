package comwow2778.naver.blog.app3;

import android.graphics.Color;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TabHost tabhost;
    LinearLayout L1,L2,L3;
    EditText E1,E2,E3;
    TextView T1,T2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");
        init();
        L1=(LinearLayout)findViewById(R.id.L1);
        L2=(LinearLayout)findViewById(R.id.tab1);
        L3=(LinearLayout)findViewById(R.id.tab2);
        E1=(EditText)findViewById(R.id.e1);
        E2=(EditText)findViewById(R.id.e2);
        E3=(EditText)findViewById(R.id.e3);
        T1=(TextView)findViewById(R.id.t1);
        T2=(TextView)findViewById(R.id.t2);


    }
    void onmyclick(View v){
        if(v.getId()==R.id.b1){
            BMI();
        }
        else if(v.getId()==R.id.b2){
            area();
        }
        else if(v.getId()==R.id.b3){
            area2();
        }
    }

    void BMI(){
        String a = E1.getText().toString();
        String b = E2.getText().toString();
        if(a.isEmpty() || b.isEmpty()){
            T1.setText("빈칸이 없이 값을 입력하세요.");
        }
        else {
            Double i = Double.parseDouble(a) * 0.01;
            Double j = Double.parseDouble(b);
            Double bmi = j / (i * i);
            if (bmi < 18.5) {
                T1.setText("체중 부족입니다.");
            } else if (bmi >= 18.5 && bmi <= 22.9) {
                T1.setText("정상 입니다.");
            } else if (bmi >= 23 && bmi <= 24.9) {
                T1.setText("과체중 입니다.");
            } else {
                T1.setText("비만 입니다.");
                T1.setTextColor(Color.RED);
            }
        }
    }

    void area(){
        String a =E3.getText().toString();
        if(a.isEmpty()){
            T2.setText("빈칸이 없이 값을 입력하세요.");
        }
        else {
            double i = Double.parseDouble(a);
            T2.setText((i * 3.305785) + "제곱미터 입니다.");
        }
    }

    void area2(){
        String a =E3.getText().toString();
        if(a.isEmpty()){
            T2.setText("빈칸이 없이 값을 입력하세요");
        }
        else {
            double i = Double.parseDouble(a);
            T2.setText((i / 3.305785) + "평");
        }
    }

    void init(){
        tabhost = (TabHost)findViewById(R.id.tabhost);
        tabhost.setup();
        tabhost.addTab(tabhost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI 계산기"));
        tabhost.addTab(tabhost.newTabSpec("b").setContent(R.id.tab2).setIndicator("면적 계산기"));
    }
}
