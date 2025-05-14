package com.jaytech.pacepro.data


import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.jaytech.pacepro.Navigations.ROUTE_HOME
import com.jaytech.pacepro.Navigations.ROUTE_LOGIN
import com.jaytech.pacepro.Navigations.ROUTE_REGISTER
import com.jaytech.pacepro.model.User


class AuthViewModel (
    var navController: NavHostController,
    var context: Context) {

    var mAuth: FirebaseAuth
    val progress: ProgressDialog


    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setMessage("Registering User...")
        progress.setTitle("Loading")
    }

    fun signup(fname: String, lname: String, email: String, pass: String, confirmpass: String) {
        progress.show()

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty() || email.isEmpty() || confirmpass.isEmpty()) {
            progress.dismiss()
            Toast.makeText(context, "please fill in all details", Toast.LENGTH_LONG).show()
            return

        } else if (pass != confirmpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {

                if (it.isSuccessful) {
                    var userdata = User(fname, lname, email, pass, mAuth.currentUser!!.uid)
                    var regRef = FirebaseDatabase.getInstance().getReference()
                        .child("Users/" + mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener { }

                    if (it.isSuccessful) {
                        Toast.makeText(
                            context, "Successfully" + "created an account",
                            Toast.LENGTH_LONG
                        ).show()
                        navController.navigate(ROUTE_HOME)


                    } else {
                        Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                            .show()
                        navController.navigate(ROUTE_LOGIN)
                    }
                } else {
                    navController.navigate(ROUTE_REGISTER)
                }


            }
        }

    }

    fun login(email: String, pass: String) {
        progress.show()

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
            } else {
                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }

        }
    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)

    }

    fun isloggedin(): Boolean {
        return mAuth.currentUser != null
    }


}
