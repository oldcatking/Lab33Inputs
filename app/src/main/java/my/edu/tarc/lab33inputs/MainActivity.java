package my.edu.tarc.lab33inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge=findViewById(R.id.spinnerAge);
        radioGroupGender=findViewById(R.id.radioGroupGender);
        radioButtonMale=findViewById(R.id.radioButtonMale);
        radioButtonFemale=findViewById(R.id.radioButtonFemale);
        checkBoxSmoker=findViewById(R.id.checkBoxSmoker);
        textViewPremium=findViewById(R.id.textViewPremium);


        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"Position="+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void calculatePremium(View view){
        int position;
        float premium=0;

        position=spinnerAge.getSelectedItemPosition();
        switch (position){
            case 0:
                premium=50;
                break;
            case 1:
                premium=55;
                break;
            case 2:
                premium=60;
                break;
            case 3:
                premium=70;
                break;
            case 4:
                premium=120;
                break;
            case 5:
                premium=160;
                break;
            case 6:
                premium=200;
                break;
            case 7:
                premium=250;
                break;
        }
        int gender;
        float extramale=0;
        gender=radioGroupGender.getCheckedRadioButtonId();
        if(gender==R.id.radioButtonMale){
            //TODO calculate premium if male
            switch(position){
                case 0:
                    extramale=0;
                    break;
                case 1:
                    extramale=0;
                    break;
                case 2:
                    extramale=50;
                    break;
                case 3:
                    extramale=100;
                    break;
                case 4:
                    extramale=100;
                    break;
                case 5:
                    extramale=50;
                    break;
                case 6:
                    extramale=0;
                    break;
                case 7:
                    extramale=0;
                    break;
            }
        }
        float smoker=0;
        if(checkBoxSmoker.isChecked()){
            //TODO calculate premium of smoker

            switch(position){
                case 0:
                    smoker=0;
                    break;
                case 1:
                    smoker=0;
                    break;
                case 2:
                    smoker=0;
                    break;
                case 3:
                    smoker=100;
                    break;
                case 4:
                    smoker=150;
                    break;
                case 5:
                    smoker=150;
                    break;
                case 6:
                    smoker=250;
                    break;
                case 7:
                    smoker=250;
                    break;
        }}else{
                smoker = 0;
            }


        float total=0;
                total+=premium+extramale+smoker;
        textViewPremium.setText(getString(R.string.premium)+" "+total);
    }
}
