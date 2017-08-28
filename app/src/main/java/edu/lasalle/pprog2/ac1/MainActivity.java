package edu.lasalle.pprog2.ac1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText repassword;
    private CheckBox laptot;
    private CheckBox androidPhone;
    private Spinner versioAndroid;
    private RadioButton menor;
    private RadioButton entre;
    private RadioButton major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //guardo la informacio seleccionada per l'usuari
        name = (EditText) findViewById(R.id.nom);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        laptot = (CheckBox) findViewById(R.id.laptot);
        androidPhone = (CheckBox) findViewById(R.id.phone);
        versioAndroid = (Spinner) findViewById(R.id.android_version);
        menor = (RadioButton) findViewById(R.id.less18);
        entre = (RadioButton) findViewById(R.id.entre);
        major = (RadioButton) findViewById(R.id.major18);





    }

    //Metode per a amagar o activar el spinner
    public void onClick(View v) {

        if(androidPhone.isChecked()) {
            versioAndroid.setVisibility(View.VISIBLE);
        } else {
            versioAndroid.setVisibility(View.GONE);
        }
    }
    //Metodes per netejar els textFields si s'han clicat per l'usuari.
    public void clearName(View v) {
        if(name.isClickable()) {
            name.setText("");
        }
    }

    public void clearEmail(View v) {
        if(email.isClickable()) {
            email.setText("");
        }
    }
    public void clearPassword(View v) {
        if(password.isClickable()) {
            password.setText("");
        }
    }

    public void clearRepassword(View v) {
        if(repassword.isClickable()) {
            repassword.setText("");
        }
    }



    //Metode que comprova si tot és correcte un cop s'hagi presionat el botó de registrar.
    public void onButtonSaveClick(View view) {
        char[] arrobas = email.getText().toString().toCharArray();
        int contador = 0;
        for (int i = 0; i < arrobas.length; i++) {
            if(arrobas[i] == '@') {
                contador++;
            }
        }


        if (name.getText().toString().equals("")) {
            name.requestFocus();
            name.setError(getString(R.string.Error_nombre));

        } else if(email.getText().toString().equals("")){
            email.requestFocus();
            email.setError(getString(R.string.Error_correo));


        } else if(password.getText().toString().equals("")) {
            password.requestFocus();
            password.setError(getString(R.string.Error_password));

        }else if(!(password.getText().toString().equals(repassword.getText().toString()))) {
            repassword.requestFocus();
            repassword.setError(getString(R.string.Error_password2));

        } else if(contador != 1) {
            email.requestFocus();
            email.setError(getString(R.string.Error_correo2));

        }  else {
            /* Si tot ha estat OK, es mostra la info per la terminal i es mostra una toast per
             * la pantalla de l'aplicació
             */
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.Guardar);
            int duration = Toast.LENGTH_SHORT;

            Log.d(TAG, "Name: " + name.getText().toString());
            Log.d(TAG, "Email: " + email.getText().toString());
            Log.d(TAG, "Password: " + password.getText().toString());
            Log.d(TAG, "Laptop? " + Boolean.toString(laptot.isChecked()));
            Log.d(TAG, "Android Phone? " + Boolean.toString(androidPhone.isChecked()));
            Log.d(TAG, "Android Version: " + versioAndroid.getSelectedItem().toString());
            Log.d(TAG, "<18?: " + Boolean.toString(menor.isChecked()));
            Log.d(TAG, "18-65?: " + Boolean.toString(entre.isChecked()));
            Log.d(TAG, ">65?: " + Boolean.toString(major.isChecked()));

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
