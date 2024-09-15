package com.example.kotlin_volley_cms_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var addButton: Button
    private lateinit var usersListView: ListView
    private val usersList = mutableListOf<User_lv>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        addButton = findViewById(R.id.addButton)
        usersListView = findViewById(R.id.usersListView)
        addButton.setOnClickListener {
            addUser()
        }

        usersListView.setOnItemClickListener { _, _, position, _ ->
            val user = usersList[position]
            showUpdateDeleteDialog(user)
           }

        getUsers()




    }

    //User Data Add Section

    private fun addUser() {
      //  val url = "http://10.0.2.2/kotlin_crud/create_user.php"
        val url = "https://stamasoft.com/android/kotlin_volley_crud/create_user.php"

        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("API_RESPONSE", response)
                getUsers() // Refresh list
            },
            Response.ErrorListener { error ->
                Log.e("API_ERROR", error.toString())
            }) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["name"] = nameEditText.text.toString()
                params["email"] = emailEditText.text.toString()
                params["phone"] = phoneEditText.text.toString()
                return params
            }
        }
        requestQueue.add(stringRequest)
    }

    //User Data Update Section
    private fun getUsers() {
        val url = "https://stamasoft.com/android/kotlin_volley_crud/get_users.php"
      //  val url = "http://10.0.2.2/kotlin_crud//get_users.php"

        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                val userLvs = mutableListOf<User_lv>()
                val jsonArray = JSONArray(response)
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val userLv = User_lv(
                        jsonObject.getInt("id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("email"),
                        jsonObject.getString("phone")
                    )
                    userLvs.add(userLv)
                }
                usersList.clear()
                usersList.addAll(userLvs)
                usersListView.adapter = UserAdapter_lv(this, usersList)
            },
            Response.ErrorListener { error ->
                Log.e("API_ERROR", error.toString())
            })
        requestQueue.add(stringRequest)
    }
    private fun updateUser(id: Int, name: String, email: String, phone: String) {
        val url = "https://stamasoft.com/android/kotlin_volley_crud/update_user.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("API_RESPONSE", response)
                getUsers() // Refresh list
            },
            Response.ErrorListener { error ->
                Log.e("API_ERROR", error.toString())
            }) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["id"] = id.toString()
                params["name"] = name
                params["email"] = email
                params["phone"] = phone
                return params
            }
        }
        requestQueue.add(stringRequest)
    }

    private fun deleteUser(id: Int) {
        val url = "https://stamasoft.com/android/kotlin_volley_crud/delete_user.php"
        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("API_RESPONSE", response)
                getUsers() // Refresh list
            },
            Response.ErrorListener { error ->
                Log.e("API_ERROR", error.toString())
            }) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["id"] = id.toString()
                return params
            }
        }
        requestQueue.add(stringRequest)
    }

    private fun showUpdateDeleteDialog(userLv: User_lv) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_update_delete_volley_lv, null)
        val nameEditText = dialogView.findViewById<EditText>(R.id.nameEditText)
        val emailEditText = dialogView.findViewById<EditText>(R.id.emailEditText)
        val phoneEditText = dialogView.findViewById<EditText>(R.id.phoneEditText)
        val updateButton = dialogView.findViewById<Button>(R.id.updateButton)
        val deleteButton = dialogView.findViewById<Button>(R.id.deleteButton)

        nameEditText.setText(userLv.name)
        emailEditText.setText(userLv.email)
        phoneEditText.setText(userLv.phone)

        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Update/Delete User")
            .setView(dialogView)
            .setCancelable(true)
            .create()

        updateButton.setOnClickListener {
            updateUser(userLv.id, nameEditText.text.toString(), emailEditText.text.toString(), phoneEditText.text.toString())
            dialog.dismiss()
        }

        deleteButton.setOnClickListener {
            deleteUser(userLv.id)
            dialog.dismiss()
        }

        dialog.show()
    }
}