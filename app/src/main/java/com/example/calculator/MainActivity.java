package com.example.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private final String[] operationsList = {"+", "-", "x", "÷", "%"};
    private final ArrayList<String> list = new ArrayList<>();
    private final DecimalFormat format = new DecimalFormat();
    private TextView tvAnswer, tvOperation, tvSignBox;
    private String process, sign = "", value1, value2;
    private double grandTotal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
    }


    //All the layouts find here.
    private void findViewById() {

        tvAnswer = findViewById(R.id.tvAnswer);
        tvOperation = findViewById(R.id.tvOperation);
        tvSignBox = findViewById(R.id.tvSignBox);

    }

    //All the arithmetic operations define here.
    private void operations() {
        if (list.size() > 2) {
            tvOperation.setText("");
            sign = null;
            value2 = null;
            value1 = null;
            String valueOfLastElement = list.get(list.size() - 1);
            if (Arrays.asList(operationsList).contains(valueOfLastElement)) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                String valueOfArrayElement = list.get(i);
                String valueOfOperation = (tvOperation.getText().toString().trim() + valueOfArrayElement);
                SpannableString ss1 = new SpannableString(valueOfOperation);
                if (valueOfArrayElement.length() > 1 && valueOfArrayElement.contains(getString(R.string.Subtraction))) {
                    int indexStart = valueOfOperation.indexOf(valueOfArrayElement);
                    int indexEnd = (indexStart + 1);
                    ss1.setSpan(new RelativeSizeSpan(0.8f), indexStart, indexEnd, 0); // set size
                    ss1.setSpan(new ForegroundColorSpan(Color.RED), indexStart, indexEnd, 0);// set color
                }
                tvOperation.setText(ss1);
                if (sign == null && Arrays.asList(operationsList).contains(valueOfArrayElement)) {
                    sign = valueOfArrayElement;
                } else if (value1 == null) {
                    value1 = valueOfArrayElement;

                } else if (value2 == null) {
                    value2 = valueOfArrayElement;
                }
                if (value1 != null && value2 != null && sign != null) {
                    double result = 0.0;
                    switch (sign) {
                        case "+": {
                            result = ((Double.parseDouble(value1)) + (Double.parseDouble(value2)));
                            break;
                        }
                        case "-": {
                            result = ((Double.parseDouble(value1)) - (Double.parseDouble(value2)));
                            break;
                        }
                        case "÷": {
                            result = ((Double.parseDouble(value1)) / (Double.parseDouble(value2)));
                            break;
                        }
                        case "x": {
                            result = ((Double.parseDouble(value1)) * (Double.parseDouble(value2)));
                            break;
                        }
                        case "%": {
                            result = ((Double.parseDouble(value1)) / 100);
                            break;
                        }
                    }
                    grandTotal = result;
                    value1 = String.valueOf(result);
                    value2 = null;
                    sign = null;
                }
            }
            String s = format.format(grandTotal);
            tvAnswer.setText(s);
        } else {
            tvOperation.setText("");
            tvAnswer.setText("");
            for (int i = 0; i < list.size(); i++) {
                tvOperation.setText((tvOperation.getText().toString().trim() + list.get(i)));
            }
        }
    }

    //Add all the elements for operations.
    private void addElementForOperation(String elementToAdd) {
        if (list.size() == 0) {
            list.add(elementToAdd);
        } else {
            String lastElement = list.get(list.size() - 1);
            if (Arrays.asList(operationsList).contains(lastElement)) {
                list.add(elementToAdd);
            } else {
                String s = list.get(list.size() - 1) + elementToAdd;
                list.remove(list.size() - 1);
                list.add(s);
            }
        }
    }

    //All kind  of arithmetic operations perform using button '1' here.
    public void one(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.One));
        addElementForOperation(getString(R.string.One));
        operations();
    }

    //All kind  of arithmetic operations perform using button '2' here.
    public void two(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Two));
        addElementForOperation(getString(R.string.Two));
        operations();
    }

    //All kind  of arithmetic operations perform using button '3' here.
    public void three(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Three));
        addElementForOperation(getString(R.string.Three));
        operations();
    }

    //All kind  of arithmetic operations perform using button '4' here.
    public void four(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Four));
        addElementForOperation(getString(R.string.Four));
        operations();
    }

    //All kind  of arithmetic operations perform using button '5' here.
    public void five(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Five));
        addElementForOperation(getString(R.string.Five));
        operations();
    }

    //All kind  of arithmetic operations perform using button '6' here.
    public void six(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Six));
        addElementForOperation(getString(R.string.Six));
        operations();
    }

    //All kind  of arithmetic operations perform using button '7' here.
    public void seven(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Seven));
        addElementForOperation(getString(R.string.Seven));
        operations();
    }

    //All kind  of arithmetic operations perform using button '8' here.
    public void eight(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Eight));
        addElementForOperation(getString(R.string.Eight));
        operations();
    }

    //All kind  of arithmetic operations perform using button '9' here.
    public void nine(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Nine));
        addElementForOperation(getString(R.string.Nine));
        operations();
    }

    //All kind  of arithmetic operations perform using button '0' here.
    public void zero(View view) {
        process = tvOperation.getText().toString();
        tvOperation.setText(process + getString(R.string.Zero));
        addElementForOperation(getString(R.string.Zero));
        operations();
    }

    //Convert the number into decimal number here.
    public void dot(View view) {
        if (list.size() > 0) {
            process = tvOperation.getText().toString();
            String s = getString(R.string.Zero) + getString(R.string.Dot);
            String lastElement = list.get(list.size() - 1);

            if (lastElement.contains(".")) {
                return;
            }
            if (list.size() == 0) {
                list.add(s);
                tvOperation.setText(process + s);
            } else {
                if (Arrays.asList(operationsList).contains(lastElement)) {
                    list.add(s);
                    tvOperation.setText(process + s);
                } else {
                    String s1 = list.get(list.size() - 1) + getString(R.string.Dot);
                    list.remove(list.size() - 1);
                    list.add(s1);
                    tvOperation.setText(process + getString(R.string.Dot));
                }
            }
            operations();
        }
    }

    //In this functions all the attribute are cleared.
    public void clear(View view) {
        tvOperation.setText("");
        tvAnswer.setText("");
        tvSignBox.setText("");
        list.clear();
        value1 = null;
        value2 = null;
        grandTotal = 0.0;
        sign = null;
    }

    //If any sign are there in Array list total will be set in tvOperation.
    public void equalTo(View view) {
        if (list.size() > 0) {
            String s = format.format(grandTotal);
            String lastElement = list.get(list.size() - 1);
            if (Arrays.asList(operationsList).contains(lastElement)) {
                value1 = String.valueOf(grandTotal);
                tvAnswer.setText("");
                tvOperation.setText(s);
                list.clear();
                list.add(s);
            } else {
                value1 = String.valueOf(grandTotal);
                tvAnswer.setText("");
                tvOperation.setText(s);
                list.clear();
                list.add(s);
            }
        }
    }

    //Convert the positive number to negative and negative number to positive.
    public void plusMinus(View view) {
        if (list.size() > 0) {
            String p1;
            sign = null;
            String lastElement = list.get(list.size() - 1);
            if (Arrays.asList(operationsList).contains(lastElement)) {
                return;
            }
            process = tvOperation.getText().toString();
            if (Double.parseDouble(lastElement) > 0) {
                p1 = getString(R.string.Subtraction) + lastElement;
                list.remove(list.size() - 1);
                list.add(p1);
            } else if (Double.parseDouble(lastElement) < 0) {
                p1 = lastElement.replace(getString(R.string.Subtraction), "");
                list.remove(list.size() - 1);
                list.add(p1);
            }
            operations();
        }
    }

    //In this function convert the percentage value of lastElement.
    public void percentage(View view) {
        if (list.size() > 0) {
            sign = getString(R.string.Percentage);
            String lastElement = list.get(list.size() - 1);
            double result = 0.0;
            process = tvOperation.getText().toString();
            tvOperation.setText(process + getString(R.string.Percentage) + "");
            tvSignBox.setText(getString(R.string.Percentage));

            if (list.size() > 0 || value1 != null) {
                if (list.size() > 0) {
                    if (Arrays.asList(operationsList).contains(lastElement)) {
                        list.remove((list.size() - 1));
                    }
                }
                list.add(sign);
            }

            if (list.size() <= 2) {
                sign = null;
                value2 = null;
                value1 = null;
                result = (Double.parseDouble(lastElement) / 100);
                grandTotal = result;
                value1 = String.valueOf(result);
                String s = format.format(grandTotal);
                tvAnswer.setText(s);
                list.add(s);
            } else if (list.size() > 2) {
                sign = null;
                value2 = null;
                value1 = null;
                result = (Double.parseDouble(lastElement) / 100);
                Double total = ((grandTotal) + (result) - (Double.parseDouble(lastElement)));
                String s = format.format(total);
                tvAnswer.setText(s);
                list.add(s);
            } else if (Arrays.asList(operationsList).contains(lastElement))
                return;
            else {
                operations();
            }
        }

    }

    //In this function compute the division of grandTotal and lastElement.
    public void division(View view) {
        if (list.size() > 0) {
            sign = getString(R.string.Division);
            process = tvOperation.getText().toString();
            tvSignBox.setText(getString(R.string.Division));
            String lastElement = list.get(list.size() - 1);

            if (lastElement.contains(getString(R.string.Division))) {
                return;
            }
            if (list.size() > 0 || value1 != null) {
                if (list.size() > 0) {
                    if (Arrays.asList(operationsList).contains(lastElement)) {
                        list.remove((list.size() - 1));
                    }
                }
                list.add(sign);
                tvOperation.setText(process + getString(R.string.Division) + "");
            }
        }
    }

    //In this function compute the multiplication of grandTotal and lastElement.
    public void multiplication(View view) {

        if (list.size() > 0) {
            sign = getString(R.string.Multiplication);
            process = tvOperation.getText().toString();
            tvSignBox.setText(getString(R.string.Multiplication));
            String lastElement = list.get(list.size() - 1);

            if (lastElement.contains(getString(R.string.Multiplication))) {
                return;
            }
            if (list.size() > 0 || value1 != null) {
                if (list.size() > 0) {

                    if (Arrays.asList(operationsList).contains(lastElement)) {
                        list.remove((list.size() - 1));
                    }
                }
                list.add(sign);
                tvOperation.setText(process + getString(R.string.Multiplication) + "");
            }
        }
    }

    //In this function compute the subtraction of grandTotal and lastElement.
    public void subtraction(View view) {
        if (list.size() > 0) {
            sign = getString(R.string.Subtraction);
            process = tvOperation.getText().toString();
            tvSignBox.setText(getString(R.string.Subtraction));
            String lastElement = list.get(list.size() - 1);

            if (lastElement.contains(getString(R.string.Subtraction))) {
                return;
            }
            if (list.size() > 0 || value1 != null) {
                if (list.size() > 0) {
                    if (Arrays.asList(operationsList).contains(lastElement)) {
                        list.remove((list.size() - 1));
                    }
                }
                list.add(sign);
                tvOperation.setText(process + getString(R.string.Subtraction) + "");
            }
        }
    }

    //In this function compute the addition of grandTotal and lastElement.
    public void addition(View view) {
        if (list.size() > 0) {
            sign = getString(R.string.Addition);
            process = tvOperation.getText().toString();
            tvSignBox.setText(getString(R.string.Addition));
            String lastElement = list.get(list.size() - 1);

            if (lastElement.contains(getString(R.string.Addition))) {
                return;
            }
            if (list.size() > 0 || value1 != null) {
                if (list.size() > 0) {
                    if (Arrays.asList(operationsList).contains(lastElement)) {
                        list.remove((list.size() - 1));
                    }
                }
                list.add(sign);
                tvOperation.setText(process + getString(R.string.Addition) + "");
            }
        }
    }

    //In this function erase the content of lastElement.
    public void backspace(View view) {
        if (list.size() > 0) {
            String p1;
            String lastElement = list.get(list.size() - 1);
            if (Arrays.asList(operationsList).contains(lastElement)) {
                list.remove((list.size() - 1));
            } else {
                if (lastElement.length() <= 1 || (lastElement.length() == 2 && lastElement.contains(getString(R.string.Subtraction)))) {
                    list.remove((list.size() - 1));
                } else {
                    p1 = lastElement.substring(0, lastElement.length() - 1);
                    list.set(list.size() - 1, p1);
                }
            }
            operations();
            tvOperation.setText("");
            for (int i = 0; i < list.size(); i++) {
                tvOperation.setText((tvOperation.getText().toString().trim() + list.get(i)));
            }
        }
    }
}



