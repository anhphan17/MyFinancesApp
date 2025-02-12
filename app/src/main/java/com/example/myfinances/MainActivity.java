package com.example.myfinances;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CertificatesOfDeposit currentCD;

    private Loans currentLoans;

    private Checkings currentCheckings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initCancelButton();
    }

    private void clear() {
        EditText accountNumberET = findViewById(R.id.accountNumEditText);
        EditText initialBalanceET = findViewById(R.id.initialBalEditText);
        EditText currentBalanceET = findViewById(R.id.currentBalEditText);
        EditText interestRateET = findViewById(R.id.interestEditText);
        EditText payAmountET = findViewById(R.id.payAmtEditText);
        RadioGroup accountTypeRG = findViewById(R.id.radioGroup);

        accountTypeRG.clearCheck();
        accountNumberET.setText("");
        initialBalanceET.setText("");
        currentBalanceET.setText("");
        interestRateET.setText("");
        payAmountET.setText("");
    }


    private void initCancelButton() {
        Button cancelBtn = findViewById(R.id.cancelButton);
        cancelBtn.setOnClickListener(v -> {
            clear();
        });
    }


}