package com.example.cms_insert_1___;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Add_customer extends AppCompatActivity {
//   private String insertDataURL = "http://stamasoft.com/android/cms_lmem/addCustomer.php";

//private String insertDataURL = "http://192.168.56.1/android/crudmysql/volleycrud/addProduct.php";

    private String insertDataURL = "http://10.0.2.2/android/addCustomer.php";
    // private String insertDataURL = "http://10.0.2.2/android/CMS_LMEM/addCustomer.php";
    // private String insertDataURL = "http://192.168.1.3/android/addCustomer.php";
    // private String insertDataURL = "http://192.168.1.3/android/addCustomer.php";

    private static String TAG = Add_customer.class.getSimpleName();
    private Button insertData;

    private EditText editIname, editMobile;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customer);
        insertData = findViewById(R.id.btnaddcustomer);

        editIname = findViewById(R.id.c_name);
        editMobile = findViewById(R.id.c_mobile);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmadddata();
            }
        });
    }

    public void insertdatanewway2() {
        showpDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertDataURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                editIname.setText("");
                editMobile.setText("");

                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parameters = new HashMap<>();
                parameters.put("c_fullname", editIname.getText().toString());
                parameters.put("c_mobile", editMobile.getText().toString());
                return parameters;
            }
        };

        AppSingleton1.getInstance(this).addToRequestQueue(stringRequest, TAG);
    }

    private void confirmadddata() {
        androidx.appcompat.app.AlertDialog.Builder alertDialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to add data?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                insertdatanewway2();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // Do nothing
            }
        });

        androidx.appcompat.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showpDialog() {
        if (!pDialog.isShowing()) pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing()) pDialog.dismiss();
    }
}
