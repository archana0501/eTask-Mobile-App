package com.eet.etask

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddTask : Fragment() {
    val types = arrayOf("Select Employee","Sandeep","Kunal","Preeti","Alisha","Gautam")
    val types2 = arrayOf("Select Priority","Critical","High","Medium","Low")

    private var param1: String? = null
    private var param2: String? = null

    //interface
    private lateinit var communicator: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun frag(){
        val manager=fragmentManager
        val transaction= manager?.beginTransaction()
        val fragment=Dashboard()
        transaction?.replace(R.id.Fragment_Container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        // Inflate the layout for this fragment
       val v= inflater.inflate(R.layout.fragment_add_task, container, false)

        communicator =activity as Communicator


        val spinner = v.findViewById<Spinner>(R.id.Assigned_to)
        val title = v.findViewById<TextInputEditText>(R.id.title)
        val start_date = v.findViewById<TextInputEditText>(R.id.start_date)
        val start_time = v.findViewById<TextInputEditText>(R.id.start_time)
        val end_date = v.findViewById<TextInputEditText>(R.id.end_date)
        val end_time = v.findViewById<TextInputEditText>(R.id.end_time)
        val Assigned_to = v.findViewById<Spinner>(R.id.Assigned_to)
        val Priority = v.findViewById<Spinner>(R.id.Priority)
        val multiline = v.findViewById<TextInputEditText>(R.id.multiline)
        val save = v.findViewById<Button>(R.id.save)
        val reset = v.findViewById<Button>(R.id.reset)


        val hashMap : HashMap<String, String> = HashMap<String,String> ()
//        val database : ArrayList<String> = ArrayList()
        //Button for saving data in Hashmap & Arraylist

        save.setOnClickListener{
            val strtitle = title.text.toString()
            val strstart_date = start_date.text.toString()
            val strstart_time = start_time.text.toString()
            val strend_date = end_date.text.toString()
            val strend_time = end_time.text.toString()
            val strAssigned_to= Assigned_to.selectedItem.toString()
            val strPriority = Priority.selectedItem.toString()
            val strmultiline = multiline.text.toString()

            hashMap["KeyTaskname"]=strtitle
            hashMap["KeyStartDate"]=strstart_date
            hashMap["KeysTime"]=strstart_time
            hashMap["KeyeDate"]=strend_date
            hashMap["KeyeTime"]=strend_time
            hashMap["Keyassigned"]=strAssigned_to
            hashMap["Keypriority"]=strPriority
            hashMap["Keymultiline"]=strmultiline
//            database.add(hashMap.toString())
                Data.database.add(hashMap)
            //check if the EditText have values or not

//            if(strtitle.length==0||strstart_date.length==0||strstart_time.length==0
//                ||strend_date.length==0||strend_time.length==0||strAssigned_to.length==0
//                ||strPriority.length==0||strmultiline.length==0)
//            {
//                Toast.makeText(v.context, "Title is required : "+strtitle, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "start date is required : "+strstart_date, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "start time is required : "+strstart_time, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "End date is required : "+strend_date, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "End time is required : "+strend_time, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "Assigned is required : "+strAssigned_to, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "priorty is required : "+strPriority, Toast.LENGTH_SHORT).show()
//                Toast.makeText(v.context, "multiline is required : "+strmultiline, Toast.LENGTH_SHORT).show()
//            }
//            else {
                frag() }
//        }

//            println( Data.database[0].toString())
//            communicator.passdata(view.database.text.toString())


        spinner?.adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                R.layout.spinner_row,
                types
            )
        } as SpinnerAdapter
        spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("erreur")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
//                Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                println(type)
            }
        }
//this is for spinner 2
        val spinner2 = v.findViewById<Spinner>(R.id.Priority)
        spinner2?.adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                R.layout.spinner_row,
                types2
            )
        } as SpinnerAdapter
        spinner2?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("erreur")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
//                Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                println(type)
            }
        }
//        val resetbutton: Button = v.findViewById(R.id.reset)
        reset.setOnClickListener{
            title.setText("")
            start_date.setText("")
            start_time.setText("")
            end_date.setText("")
            end_time.setText("")
            Assigned_to.setSelection(0)
            Priority.setSelection(0)
            multiline.setText("")
        }
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddTask().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}