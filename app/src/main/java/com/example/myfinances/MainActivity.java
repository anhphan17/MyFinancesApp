package com.example.myfinances;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        initAccountTypeClick();
        initSaveButton();

        currentCD = new CertificatesOfDeposit();
        currentLoans = new Loans();
        currentCheckings = new Checkings();
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
        TextView savedText = findViewById(R.id.savedTextView);
        Resources res = getResources();
        String defaultMessage = res.getString(R.string.default_save_message);
        cancelBtn.setOnClickListener(v -> {
            clear();
            savedText.setText(defaultMessage);

        });
    }

    private void initAccountTypeClick() {
        RadioGroup accountTypeRG = findViewById(R.id.radioGroup);
        accountTypeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton cdRadioBtn = findViewById(R.id.cdRadioButton);
                RadioButton loanRadioBtn = findViewById(R.id.loansRadioButton);
                RadioButton checkingsRadioBtn = findViewById(R.id.checkingsRadioButton);

                EditText accountNumET = findViewById(R.id.accountNumEditText);
                EditText initialBalET = findViewById(R.id.initialBalEditText);
                EditText currentBalET = findViewById(R.id.currentBalEditText);
                EditText interestRateET = findViewById(R.id.interestEditText);
                EditText paymentAmountET = findViewById(R.id.payAmtEditText);

                accountNumET.setEnabled(false);
                initialBalET.setEnabled(false);
                currentBalET.setEnabled(false);
                interestRateET.setEnabled(false);
                paymentAmountET.setEnabled(false);

                if (cdRadioBtn.isChecked()) {
                    accountNumET.setEnabled(true);
                    initialBalET.setEnabled(true);
                    currentBalET.setEnabled(true);
                    interestRateET.setEnabled(true);
                }
                else if (loanRadioBtn.isChecked()) {
                    accountNumET.setEnabled(true);
                    initialBalET.setEnabled(true);
                    currentBalET.setEnabled(true);
                    interestRateET.setEnabled(true);
                    paymentAmountET.setEnabled(true);
                }
                else if (checkingsRadioBtn.isChecked()) {
                    accountNumET.setEnabled(true);
                    currentBalET.setEnabled(true);
                }
            }
        });
    }

    private void initSaveButton() {
        Button saveBtn = findViewById(R.id.saveButton);
        saveBtn.setOnClickListener(v -> {
            EditText accountNumET = findViewById(R.id.accountNumEditText);
            EditText initialBalET = findViewById(R.id.initialBalEditText);
            EditText currentBalET = findViewById(R.id.currentBalEditText);
            EditText paymentAmtET = findViewById(R.id.payAmtEditText);
            EditText interestRateET = findViewById(R.id.interestEditText);

            TextView savedMessage = findViewById(R.id.savedTextView);
            Resources res = getResources();
            String savedMesStr = res.getString(R.string.confirmed_save_message);

            RadioGroup AccountTypeRG = findViewById(R.id.radioGroup);


            boolean didSucceed;
            int selectedId = AccountTypeRG.getCheckedRadioButtonId();
            MyFinancesDataSource ds = new MyFinancesDataSource(MainActivity.this);
            try {
                ds.open();
                if (selectedId == R.id.cdRadioButton) {
                    currentCD.setAccountNumber(Integer.parseInt(accountNumET.getText().toString()));
                    currentCD.setInitialBalance(Double.parseDouble(initialBalET.getText().toString()));
                    currentCD.setCurrentBalance(Double.parseDouble(currentBalET.getText().toString()));
                    currentCD.setInterestRate(Float.parseFloat(interestRateET.getText().toString()));

                    if (currentCD.getCdId() == -1) {
                        didSucceed = ds.insertCD(currentCD);
                        if (didSucceed) {
                            int newCDId = ds.getLastCDId();
                            currentCD.setCdId(newCDId);
                        }
                    }
                    else {
                        ds.updateCD(currentCD);
                    }
                }
                else if (selectedId == R.id.loansRadioButton) {
                    currentLoans.setAccountNumber(Integer.parseInt(accountNumET.getText().toString()));
                    currentLoans.setInitialBalance(Double.parseDouble(initialBalET.getText().toString()));
                    currentLoans.setCurrentBalance(Double.parseDouble(currentBalET.getText().toString()));
                    currentLoans.setPaymentAmount(Double.parseDouble(paymentAmtET.getText().toString()));
                    currentLoans.setInterestRate(Float.parseFloat(interestRateET.getText().toString()));

                    if (currentLoans.getLoansId() == -1) {
                        didSucceed = ds.insertLoans(currentLoans);
                        if (didSucceed) {
                            int newLoansId = ds.getLastLoanId();
                            currentLoans.setLoansId(newLoansId);
                        }
                    }
                    else {
                        ds.updateLoans(currentLoans);
                    }
                }
                else if (selectedId == R.id.checkingsRadioButton) {
                    currentCheckings.setAccountNumber(Integer.parseInt(accountNumET.getText().toString()));
                    currentCheckings.setCurrentBalance(Double.parseDouble(currentBalET.getText().toString()));

                    if (currentCheckings.getCheckingsId() == -1) {
                        didSucceed = ds.insertCheckings(currentCheckings);
                        if (didSucceed) {
                            int newCheckingsId = ds.getLastCheckingsId();
                            currentCheckings.setCheckingsId(newCheckingsId);
                        }
                    }
                    else {
                        ds.updateCheckings(currentCheckings);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                ds.close();
                clear();
                savedMessage.setText(savedMesStr);
            }
        });
    }





}