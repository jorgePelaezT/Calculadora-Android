package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton radioMultiplicacion;
    private RadioButton radioDivision;
    private RadioButton radioResta;
    private RadioButton radioSuma;
    private Button buttonClear;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonSuma;
    private Button buttonResta;
    private Button buttonDivision;
    private Button buttonMutiplicacion;
    private Button buttonIgual;
    private Button buttonDecimal;
    private TextView textView;
    private boolean decimales;
    private int operandos;
    private RecyclerView recyclerView;
    private ArrayList<String> operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox=findViewById(R.id.checkBox);
        radioGroup=findViewById(R.id.RadioGroup);
        buttonClear=findViewById(R.id.ButtonClear);
        button0=findViewById(R.id.Button0);
        button1=findViewById(R.id.Button1);
        button2=findViewById(R.id.Button2);
        button3=findViewById(R.id.Button3);
        button4=findViewById(R.id.Button4);
        button5=findViewById(R.id.Button5);
        button6=findViewById(R.id.Button6);
        button7=findViewById(R.id.Button7);
        button8=findViewById(R.id.Button8);
        button9=findViewById(R.id.Button9);
        buttonSuma =findViewById(R.id.ButtonMas);
        buttonResta=findViewById(R.id.ButtonRes);
        buttonMutiplicacion=findViewById(R.id.ButtonMul);
        buttonDivision=findViewById(R.id.ButtonDiv);
        buttonDecimal=findViewById(R.id.ButtonDec);
        buttonIgual=findViewById(R.id.ButtonIgu);
        textView=findViewById(R.id.textView);
        radioSuma=findViewById(R.id.radioButton1);
        radioResta=findViewById(R.id.radioButton2);
        radioMultiplicacion=findViewById(R.id.radioButton3);
        radioDivision=findViewById(R.id.radioButton4);


        checkBox.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonSuma.setOnClickListener(this);
        buttonResta.setOnClickListener(this);
        buttonMutiplicacion.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);
        radioSuma.setOnClickListener(this);
        radioResta.setOnClickListener(this);
        radioMultiplicacion.setOnClickListener(this);
        radioDivision.setOnClickListener(this);

        operaciones=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
    }

    @Override
    public void onClick(View view) {
        String operacion=textView.getText().toString();
        String aux="",res="";
        boolean clear=false;
        int longitud=textView.getText().toString().length();
        boolean botonesOpciones=false;

        switch (view.getId()){
            case R.id.ButtonClear:
                clear=true;
            break;
            case R.id.checkBox:
                botonesOpciones=true;
                if(checkBox.isChecked()){
                    radioGroup.setVisibility(radioGroup.VISIBLE);
                }else{
                    radioGroup.setVisibility(radioGroup.GONE);
                }
            break;
            case R.id.radioButton1:
                botonesOpciones=true;
                if(radioSuma.isChecked()){
                    buttonSuma.setEnabled(false);
                    buttonResta.setEnabled(true);
                    buttonMutiplicacion.setEnabled(true);
                    buttonDivision.setEnabled(true);
                }
            break;
            case R.id.radioButton2:
                botonesOpciones=true;
                if(radioResta.isChecked()){
                    buttonResta.setEnabled(false);
                    buttonSuma.setEnabled(true);
                    buttonMutiplicacion.setEnabled(true);
                    buttonDivision.setEnabled(true);
                }
            break;
            case R.id.radioButton3:
                botonesOpciones=true;
                if(radioMultiplicacion.isChecked()){
                    buttonMutiplicacion.setEnabled(false);
                    buttonSuma.setEnabled(true);
                    buttonResta.setEnabled(true);
                    buttonDivision.setEnabled(true);
                }
            break;
            case R.id.radioButton4:
                botonesOpciones=true;
                if(radioDivision.isChecked()){
                    buttonDivision.setEnabled(false);
                    buttonSuma.setEnabled(true);
                    buttonResta.setEnabled(true);
                    buttonMutiplicacion.setEnabled(true);
                }
            break;
            case R.id.Button0:
                aux="0";
            break;
            case R.id.Button1:
                aux="1";
            break;
            case R.id.Button2:
                aux="2";
            break;
            case R.id.Button3:
                aux="3";
            break;
            case R.id.Button4:
                aux="4";
            break;
            case R.id.Button5:
                aux="5";
            break;
            case R.id.Button6:
                aux="6";
            break;
            case R.id.Button7:
                aux="7";
            break;
            case R.id.Button8:
                aux="8";
            break;
            case R.id.Button9:
                aux="9";
            break;
            case R.id.ButtonMas:
                aux="+";
                operandos+=1;
            break;
            case R.id.ButtonRes:
                aux="-";
                operandos+=1;
            break;
            case R.id.ButtonMul:
                aux="*";
                operandos+=1;
            break;
            case R.id.ButtonDiv:
                aux="/";
                operandos+=1;
            break;
            case R.id.ButtonDec:
                aux=".";
            break;
            case R.id.ButtonIgu:
                aux="=";
            break;
        }

        if(clear){
            operandos=0;
            textView.setText("0");
        }else if(aux.equals("=")){
            textView.setText(operar(operacion));
            operaciones.add(operacion+"="+operar(operacion));
            recyclerView.setAdapter(new CustomAdapter(operaciones));
        } else if(botonesOpciones==false) {
            if (operacion.equals("0")) {
                if (aux.equals(".") || aux.equals("*") || aux.equals("/") || aux.equals("+") || aux.equals("-")) {
                    operacion += aux;
                    textView.setText(operacion);
                } else {
                    textView.setText(aux);
                }
            } else {
                if ((operacion.charAt(operacion.length() - 1) == '+' || operacion.charAt(operacion.length() - 1) == '/' || operacion.charAt(operacion.length() - 1) == '*' || operacion.charAt(operacion.length() - 1) == '-') && (aux.equals("*") || aux.equals("/") || aux.equals("+") || aux.equals("-"))) {
                    operandos -= 1;
                    Toast.makeText(getBaseContext(), "No puedes poner dos signos juntos", Toast.LENGTH_SHORT).show();
                }else if (operandos % 2 == 0 && operandos != 0) {
                    res = operar(operacion);
                    res += aux;
                    textView.setText(res);
                    operandos-=1;
                    operaciones.add(operacion+"="+operar(operacion));
                    recyclerView.setAdapter(new CustomAdapter(operaciones));
                } else {
                    for (int i = 0; i < longitud - 1; i++) {
                        if (operacion.charAt(i) == '.' && decimales == false) {
                            decimales = true;
                        } else if (operacion.charAt(i) == '*' || operacion.charAt(i) == '/' || operacion.charAt(i) == '+' || operacion.charAt(i) == '-') {
                            decimales = false;
                        }
                    }
                    if (decimales == false&&operacion.charAt(operacion.length()-1)!='.') {
                        operacion += aux;
                        textView.setText(operacion);
                    } else {
                        if (!aux.equals(".")) {
                            operacion += aux;
                            textView.setText(operacion);
                        } else {
                            Toast.makeText(this, "No puedes añadir mas comas", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }
    }

    private String operar(String operacion) {
        String numero="";
        char signo;
        int i=0;
        double primerNum,segundoNum,resultado=0;

        while (i<operacion.length()&&operacion.charAt(i)!='+'&&operacion.charAt(i)!='-'&&operacion.charAt(i)!='/'&&operacion.charAt(i)!='*'){
            numero+=operacion.charAt(i);
            i++;
        }
        if(i<operacion.length()) {
            signo = operacion.charAt(i);
            primerNum = Double.valueOf(numero);
            numero = "";
            i += 1;
            while (i < operacion.length()) {
                numero += operacion.charAt(i);
                i++;
            }
            segundoNum = Double.valueOf(numero);

            switch (signo) {
                case '+':
                    resultado = primerNum + segundoNum;
                    break;
                case '-':
                    resultado = primerNum - segundoNum;
                    break;
                case '/':
                    resultado = primerNum / segundoNum;
                    break;
                case '*':
                    resultado = primerNum * segundoNum;
                    break;
            }
            return String.valueOf(resultado);
        }else{
            return String.valueOf(numero);
        }

    }
}