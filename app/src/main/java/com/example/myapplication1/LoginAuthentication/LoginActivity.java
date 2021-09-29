//package com.example.myapplication1.LoginAuthentication;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapplication1.R;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class LoginActivity extends AppCompatActivity {
//    private EditText edtstudentnumberlogin, edtstudentpasswordlogin;
//    private Button bntlogin;
//    private SessionMananger sessionMananger;
//    Messages messages = new Messages();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_login);
//
//        edtstudentnumberlogin = findViewById(R.id.edtstudentnumberlogin);
//        edtstudentpasswordlogin = findViewById(R.id.edtstudentpasswordlogin);
//        bntlogin = findViewById(R.id.bntlogin);
//        sessionMananger = new SessionMananger(this);
//        bntlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    LoginRequest loginRequest = new LoginRequest();
//                    loginRequest.setUsername(Long.parseLong(edtstudentnumberlogin.getText().toString()));
//                    loginRequest.setPassword(edtstudentpasswordlogin.getText().toString());
//
//                    loginUser(loginRequest);
//                } catch (NumberFormatException ex) {
//                    Toast.makeText(LoginActivity.this, messages.FIELDS_REQUIRED, Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
//
//    public void loginUser(LoginRequest loginRequest) {
//        Call<LoginResponse> loginResponseCall = ApiClient.userService(getApplicationContext()).loginUser(loginRequest);
//        loginResponseCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//
//                LoginResponse loginResponse = response.body();
//                try {
//                    switch (response.code()) {
//                        case 200:
//                            sessionMananger.saveAuthToken(loginResponse.getAccessToken());
//                            Toast.makeText(LoginActivity.this, messages.SUCCESS200, Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("username", loginResponse));
//                            break;
//                        case 401:
//                            Toast.makeText(LoginActivity.this, messages.ERROR401, Toast.LENGTH_LONG).show();
//                            break;
//                        case 422:
//                            Toast.makeText(LoginActivity.this, messages.ERROR422, Toast.LENGTH_LONG).show();
//                            break;
//                        case 500:
//                            Toast.makeText(LoginActivity.this, messages.ERROR500, Toast.LENGTH_LONG).show();
//                            break;
//                    }
//
//                } catch (Exception e) {
//                    Toast.makeText(LoginActivity.this, messages.CATCH, Toast.LENGTH_LONG).show();
//                    Log.e("exception", e.toString());
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                String message = t.getLocalizedMessage();
//                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
//
//
//}