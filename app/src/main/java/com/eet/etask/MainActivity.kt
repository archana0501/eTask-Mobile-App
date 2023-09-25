package com.eet.etask
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.login_button)
        val username = findViewById<TextInputEditText>(R.id.ed_email)
        val password = findViewById<TextInputEditText>(R.id.ed_password)
        val progbar=findViewById<ProgressBar>(R.id.my_progressBar)
        val remember=findViewById<CheckBox>(R.id.remember)
        progbar.setVisibility(View.GONE);

//        for shared prefernece initialization

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
        editor = sharedPreferences.edit()
//        when user returns second time it is alredy save
        val strMail: String = sharedPreferences.getString("email", "").toString()
        val strPass: String = sharedPreferences.getString("password", "").toString()
        username.setText(strMail)
        password.setText(strPass)

        submit.setOnClickListener {
            if (username.text.toString() == "admin" &&
                password.text.toString() == "123"
            ) {
                print("loggedin")
                progbar.setVisibility(View.VISIBLE);
//               check if user logged in before and saved data in sp
                if(remember.isChecked()){
                    editor.putString("email",username.getText().toString());
                    editor.putString("password",password.getText().toString());
                    editor.commit();
                }else{
//                    if nothing saaved ever
                    editor.putString("email","");
                    editor.putString("password","");
                    editor.commit();
                }
//                activty changed to base acitvity
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
            } else {
                print("Invalid Credentials")
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show()
            }
        }
    }
}