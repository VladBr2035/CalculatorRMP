package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    Button sumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumberET);
        secondNumber = findViewById(R.id.secondNumberET);
        sumButton = findViewById(R.id.sumBtn);

        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstNumberValue= 0;
                int secondNumberValue = 0;
                try {
                    firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
                    secondNumberValue = Integer.parseInt(secondNumber.getText().toString());
                } catch (Exception e){
                    Log.e("Некорректный ввод", "Были введены некорректные данные");
                    System.exit(0);
                }

                if (firstNumber.getText().toString().isEmpty() ||
                        secondNumber.getText().toString().isEmpty()) {
                    Toast.makeText(
                            MainActivity.this, //Активити, в котором будет показываться сообщение
                            "Не указано одно из слагаемых", //Текст сообщения
                            Toast.LENGTH_SHORT) //Время высвечивания сообщения (около 2.5 секунд)
                            .show(); //Запуск
                } else {
                    int sum = firstNumberValue + secondNumberValue;
                    Intent intent = new Intent(getApplicationContext(), Result.class); //Указываем какой экран сейчас и какой должен быть открыт
                    intent.putExtra("firstNumber", firstNumberValue);
                    intent.putExtra("secondNumber", secondNumberValue);
                    intent.putExtra("sum", sum); //Сохранение значение с указанием ключа
                    startActivity(intent); //Переход к другому активити
                }
            }
        });
    }

}