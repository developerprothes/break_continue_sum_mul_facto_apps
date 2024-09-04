package com.prothes.breakcontinuesummulfactoapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText factorialInput,sumNumberMin,sumNumberMax,namta,breakStartInput,breakEndInput,breakInput,continueStartInput,continueEndInput,continueInput;
    private AppCompatButton btn1,btn2,btn3,btn4,btn5;
    private TextView display1,display2,display3,display4,display5;
    private String tdata = "Start is Small, End is Big, Break is Medium";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        factorialInput = findViewById(R.id.factorialInput);
        sumNumberMin = findViewById(R.id.sumNumberMin);
        sumNumberMax = findViewById(R.id.sumNumberMax);
        namta = findViewById(R.id.namta);
        breakStartInput = findViewById(R.id.breakStartInput);
        breakEndInput = findViewById(R.id.breakEndInput);
        breakInput= findViewById(R.id.breakInput);
        continueStartInput = findViewById(R.id.continueStartInput);
        continueEndInput = findViewById(R.id.continueEndInput);
        continueInput = findViewById(R.id.continueInput);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
        display3 = findViewById(R.id.display3);
        display4 = findViewById(R.id.display4);
        display5 = findViewById(R.id.display5);
        //===========================================================================================================================================


        // For Factorial
        //===========================================================================================================================================
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = factorialInput.getText().toString();
                if (getData.length()>0){
                    long factorial = 1;
                    int num = Integer.parseInt(getData);
                    for (int i = 1; i<=num; i++){
                        factorial = factorial * i;
                    }
                    display1.setText("Your Factorial Number is : "+"\n\n"+factorial);
                }else{
                    factorialInput.setError("Empty");
                    display1.setText(null);
                }
            }
        });


        // For Summation a Series
        //===========================================================================================================================================
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getdata1 = sumNumberMin.getText().toString();
                String getdata2 = sumNumberMax.getText().toString();
                if (getdata1.length()>0 && getdata2.length()>0){
                    int minNum,maxNum,sum = 0;
                    minNum = Integer.parseInt(getdata1);
                    maxNum = Integer.parseInt(getdata2);
                    if (minNum<maxNum || minNum == maxNum){
                        for (int i = minNum; i<=maxNum; i++){
                            sum = sum + i;
                        }
                        display2.setText("Your "+minNum+" to "+maxNum+" Sum is : "+"\n\n"+sum);
                    }else{
                        myToast("Check Min & Max Number");
                    }
                }else if (getdata1.length()>0) {
                    sumNumberMin.setError(null);
                    if (getdata2.length()>0){
                        sumNumberMax.setError(null);
                    }else{
                        sumNumberMax.setError("Empty");
                        display2.setText(null);
                    }
                }else if (getdata2.length()>0) {
                    sumNumberMax.setError(null);
                    if (getdata1.length()>0){
                        sumNumberMin.setError(null);
                    }else{
                        sumNumberMin.setError("Empty");
                        display2.setText(null);
                    }
                }else {
                    sumNumberMin.setError("Empty");
                    sumNumberMax.setError("Empty");
                    display2.setText(null);
                }
            }
        });


        // For Numta
        //===========================================================================================================================================
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = namta.getText().toString();
                if (getData.length()>0){
                    int num,myNamta = 1;
                    num = Integer.parseInt(getData);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i<=10; i++){
                        myNamta = num * i;
                        stringBuilder.append(num+"*"+i+" = "+myNamta+"\n");
                    }
                    display3.setText(num+"'s count is : \n\n"+stringBuilder);
                }else{
                    namta.setError("Empty");
                    display3.setText(null);
                }
            }
        });



        // For Break Statement
        //===========================================================================================================================================
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData1 = breakStartInput.getText().toString();
                String getData2 = breakEndInput.getText().toString();
                String getData3 = breakInput.getText().toString();

                if (getData1.length()>0 && getData2.length()>0 && getData3.length()>0){
                    int num1,num2,num3;
                    num1 = Integer.parseInt(getData1);
                    num2 = Integer.parseInt(getData2);
                    num3 = Integer.parseInt(getData3);

                    if (num1<num2 || num1 == num2){
                        if (num3<num2){
                            if (num1 != num3){
                                if (num1<num3){
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int i = num1; i<=num2; i++){
                                        if (i == num3) break;
                                        stringBuilder.append(i+" ");
                                    }
                                    display4.setText("Braek Means - Stop Loop and Print When your select num is : "+num3+"\n\n"+stringBuilder);
                                }else{
                                    myDialog(tdata);
                                }
                            }else{
                                myDialog(tdata);
                            }
                        }else{
                            myDialog(tdata);
                        }
                    }else {
                        myDialog(tdata);
                    }

                } else if (getData1.length()>0) {
                    breakStartInput.setError(null);
                    if (getData2.length()>0){
                        breakEndInput.setError(null);
                        if (getData3.length()>0){
                            breakInput.setError(null);
                        }else{
                            breakInput.setError("Empty");
                            display4.setText(null);
                        }
                    }else{
                        if (getData3.length()>0){
                            breakInput.setError(null);
                        }else{
                            breakInput.setError("Empty");
                            display4.setText(null);
                        }
                        breakEndInput.setError("Empty");
                        display4.setText(null);
                    }
                } else if (getData2.length()>0) {
                    breakEndInput.setError(null);
                    if (getData3.length()>0){
                        breakInput.setError(null);
                        if (getData1.length()>0){
                            breakStartInput.setError(null);
                        }else{
                            breakStartInput.setError("Empty");
                        }
                    }else{
                        if (getData1.length()>0){
                            breakStartInput.setError(null);
                        }else{
                            breakStartInput.setError("Empty");
                        }
                        breakInput.setError("Empty");
                        display4.setText(null);
                    }
                } else if (getData3.length()>0) {
                    breakInput.setError(null);
                    if (getData2.length()>0){
                        breakEndInput.setError(null);
                        if (getData1.length()>0){
                            breakStartInput.setError(null);
                        }else{
                            breakStartInput.setError("Empty");
                            display4.setText(null);
                        }
                    }else{
                        if (getData1.length()>0){
                            breakStartInput.setError(null);
                        }else{
                            breakStartInput.setError("Empty");
                            display4.setText(null);
                        }
                        breakEndInput.setError("Empty");
                        display4.setText(null);
                    }
                }else{
                    breakStartInput.setError("Empty");
                    breakEndInput.setError("Empty");
                    breakInput.setError("Empty");
                    display4.setText(null);
                }
            }
        });


        // For Continue Statement
        //===========================================================================================================================================
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData1 = continueStartInput.getText().toString();
                String getData2 = continueEndInput.getText().toString();
                String getData3 = continueInput.getText().toString();
                if (getData1.length()>0 && getData2.length()>0 && getData3.length()>0){
                    int num1,num2,num3;
                    num1 = Integer.parseInt(getData1);
                    num2 = Integer.parseInt(getData2);
                    num3 = Integer.parseInt(getData3);

                    if (num1<num2 || num1 == num2){
                        if (num3<num2){
                            if (num1 != num3){
                                if (num1<num3){
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int i = num1; i<=num2; i++){
                                        if (i == num3) continue;
                                        stringBuilder.append(i+" ");
                                    }
                                    display5.setText("Continue Means - Print All Number. Without "+num3+" Number\n\n"+stringBuilder);
                                }else{
                                    myDialog(tdata);
                                }
                            }else{
                                myDialog(tdata);
                            }
                        }else{
                            myDialog(tdata);
                        }
                    }else {
                        myDialog(tdata);
                    }
                } else if (getData1.length()>0) {
                    continueStartInput.setError(null);
                    if (getData2.length()>0){
                        continueEndInput.setError(null);
                        if (getData3.length()>0){
                            continueInput.setError(null);
                        }else{
                            continueInput.setError("Empty");
                            display5.setText(null);
                        }
                    }else{
                        if (getData3.length()>0){
                            continueInput.setError(null);
                        }else{
                            continueInput.setError("Empty");
                            display5.setText(null);
                        }
                        continueEndInput.setError("Empty");
                        display5.setText(null);
                    }
                } else if (getData2.length()>0) {
                    continueEndInput.setError(null);
                    if (getData3.length()>0){
                        continueInput.setError(null);
                        if (getData1.length()>0){
                            continueStartInput.setError(null);
                        }else{
                            continueStartInput.setError("Empty");
                        }
                    }else{
                        if (getData1.length()>0){
                            continueStartInput.setError(null);
                        }else{
                            continueStartInput.setError("Empty");
                        }
                        continueInput.setError("Empty");
                        display5.setText(null);
                    }
                } else if (getData3.length()>0) {
                    continueInput.setError(null);
                    if (getData2.length()>0){
                        continueEndInput.setError(null);
                        if (getData1.length()>0){
                            continueStartInput.setError(null);
                        }else{
                            continueStartInput.setError("Empty");
                            display5.setText(null);
                        }
                    }else{
                        if (getData1.length()>0){
                            continueStartInput.setError(null);
                        }else{
                            continueStartInput.setError("Empty");
                            display5.setText(null);
                        }
                        continueEndInput.setError("Empty");
                        display5.setText(null);
                    }
                }else{
                    continueStartInput.setError("Empty");
                    continueEndInput.setError("Empty");
                    continueInput.setError("Empty");
                    display5.setText(null);
                }
            }
        });





    }
    //===========================================================================================================================================
    //===========================================================================================================================================
    //===========================================================================================================================================

    public void myToast(String txt){
        Toast.makeText(this, ""+txt, Toast.LENGTH_SHORT).show();
    }

    public void myDialog(String myTxt){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(myTxt)
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
    }






    //================================================== On Backpressed Method ==================================================================
    //===========================================================================================================================================

    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog  alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Warning !!!")
                    .setMessage("Do you want to exit this apps ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.sky));
        }else {
            super.onBackPressed();
        }
    }
}