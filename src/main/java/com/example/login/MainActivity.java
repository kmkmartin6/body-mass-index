package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCm;
    EditText editKg;
    Button btnCal;
    TextView txtResultBmi;
    TextView txtResultMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCm = findViewById(R.id.edit_cm);
        editKg = findViewById(R.id.edit_kg);
        btnCal = findViewById(R.id.btn_cal);
        txtResultBmi = findViewById(R.id.txt_result_bmi);
        txtResultMsg = findViewById(R.id.txt_result_msg);


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bringCm = editCm.getText().toString();
                String bringKg = editKg.getText().toString();




                /*
       ㅂㅈㄷㅂㅈㄷㅂㅈㄷㅂㅈㄷㅂㅈㄷㅂ
       ㅂㅈㄷㅂㅈㄷㅂㅈ
                 */

                /**
                 * 정수를 표현 int
                 * double
                 */


                // 첫번째는 키와 몸무게 값이 둘다 들어와 있는지 확인한다.
                if (bringCm.equals("")) {
                    Toast.makeText(getApplicationContext() ,"키를 입력해 주세요." ,Toast.LENGTH_SHORT).show();
                } else if (bringKg.equals("")){
                    Toast.makeText(getApplicationContext() ,"몸무게를 입력해 주세요." ,Toast.LENGTH_SHORT).show();
                } else {
                    // 키와 몸무게가 모두 입력
                    //   bmi 값   =    60   / 2.89
                    // bmi 계산  몸무게 / ((키*0.01) * (키*0.01))

                    /**
                     * 1. 문자를 숫자로 바꾸는 방법
                     *    "170" -> 170
                     */
                    int changeCm = Integer.parseInt(bringCm);
                    int changeKg = Integer.parseInt(bringKg);

                    //bmi 값
                    double resultBmi = changeKg / ((changeCm * 0.01) * (changeCm * 0.01));
                    Toast.makeText(getApplicationContext() ,"bmi 결과값은 == " +resultBmi ,Toast.LENGTH_SHORT).show();
                    // bmi 결과값과 결과에 따른 범위를 텍스트뷰에 입력한다.

                    int finalBmi = (int) resultBmi;
                    String resultMsg = "";

                    if (finalBmi >= 40){
                        resultMsg = "고도비만";
                    } else if (finalBmi >=30){
                        resultMsg = "비만";
                    } else if (finalBmi >= 25){
                        resultMsg = "과체중";
                    } else if (finalBmi >= 20){
                        resultMsg = "정상";
                    } else {
                        resultMsg = "저체중";
                    }

                    txtResultBmi.setText("BMI : " + finalBmi);
                    txtResultMsg.setText("결과는 " + resultMsg);






                }

            }
        });
    }
}