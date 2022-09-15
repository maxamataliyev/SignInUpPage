package com.maxataliyev_01.task1.login

import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.maxataliyev_01.task1.R
import com.maxataliyev_01.task1.databinding.FragmentSignUpBinding

class SignUp : Fragment(R.layout.fragment_sign_up) {
    lateinit var binding: FragmentSignUpBinding
    private lateinit var fulname:EditText
    private lateinit var phonenumber:EditText
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var conpasswrod:EditText
    private lateinit var dateBirth:EditText
    private lateinit var fAuth:FirebaseAuth
    lateinit var sharedPreferences: SharedPreferences


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSignUpBinding.bind(view)
        fulname=binding.etFullname
        phonenumber=binding.etPhoneNumber
        email=binding.etEmail
        password=binding.etPassword
        conpasswrod=binding.etConfirmPassword
        dateBirth=binding.etDateBirth
        fAuth=Firebase.auth


        binding.btnRegister.setOnClickListener {
            validateEmptyForm()
        }
    }







    //onCreatedView
    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_sign_up,container,false)
        fulname=view.findViewById(R.id.etFullname)
        phonenumber=view.findViewById(R.id.etPhoneNumber)
        email=view.findViewById(R.id.etEmail)
        password=view.findViewById(R.id.etPassword)
        conpasswrod=view.findViewById(R.id.etConfirmPassword)
        dateBirth=view.findViewById(R.id.etDateBirth)
        fAuth=Firebase.auth


        view.findViewById<Button>(R.id.btnRegister).setOnClickListener {
            validateEmptyForm()

        }
        return view

       }

     */



     private fun firebaseSignUp(){
               fAuth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener {
             task->
             if (task.isSuccessful){
                 findNavController().navigate(R.id.action_signUp_to_logIn)

             }
             else{
                 Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
             }
         }

     }


     private fun validateEmptyForm() {
         val icon=AppCompatResources.getDrawable(requireContext(),
             R.drawable.ic_shield
         )
         icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)
         when{
             TextUtils.isEmpty(fulname.text.toString().trim())->{
                 fulname.setError("Please enter Fullname",icon)
             }
             TextUtils.isEmpty(phonenumber.text.toString().trim())->{
                 phonenumber.setError("Please enter phonenumber",icon)
             }
             TextUtils.isEmpty(email.text.toString().trim())->{
                 email.setError("Please enter email",icon)
             }
             TextUtils.isEmpty(password.text.toString().trim())->{
                 password.setError("Please enter password",icon)
             }
             TextUtils.isEmpty(conpasswrod.text.toString().trim())->{
                 conpasswrod.setError("Please enter password again",icon)
             }
             TextUtils.isEmpty(dateBirth.text.toString().trim())->{
                 dateBirth.setError("Please enter dateBirth",icon)
             }

             fulname.text.toString().isNotEmpty()&&
                     phonenumber.text.toString().isNotEmpty()&&
                     email.text.toString().isNotEmpty()&&
                     password.text.toString().isNotEmpty()&&
                     conpasswrod.text.toString().isNotEmpty()&&
                     dateBirth.text.toString().isNotEmpty()->{
                 if (fulname.text.toString().matches(Regex("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)"))){

                     if (phonenumber.text.toString().matches(Regex("^998(9[01345789]|3[3]|8[8]|5[5])[0-9]{7}$"))){
                         if (email.text.toString().matches(Regex("^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$"))){
                             if (password.text.toString().length>5){
                                 if (conpasswrod.text.toString()==password.text.toString()){
                                     if (dateBirth.text.toString().matches(Regex("^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$" ))){

                                     firebaseSignUp()

                                     }else{
                                         dateBirth.setError("Birthday didn't match",icon)
                                     }

                                 }else{
                                     conpasswrod.setError("Password didn't match",icon)
                                 }

                             }else{
                                 password.setError("Please enter at least 6 characters",icon)
                             }

                         }else{
                             email.setError("Please validate mail",icon)
                         }
                     }else{
                         phonenumber.setError("Please validate phone number",icon)
                     }
                 }else {
                     fulname.setError("Please validate Name",icon)
                 }
                     }
         }
     }
    }
