package com.eet.etask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatCheckedTextView
import com.eet.etask.Data.database
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_task_details.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TaskDetails : Fragment() {
    // TODO: Rename and change types of parameters
    var position =0
    var hashmapinst:HashMap<String,String>?=null
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hashmapinst= arguments!!.getSerializable("datakey") as HashMap<String,String>
        position= arguments!!.getInt("position")

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
//            @Suppress("UNCHECKED_CAST")

//          hashmapinst=it.getSerializable("datakey") as HashMap<String,String>


//            var s=hashmapinst.get("Taskname")
        }
    }
    private fun frag_update(){
        val manager=fragmentManager
        val transaction= manager?.beginTransaction()
        val fragment=update_Details()
        transaction?.replace(R.id.Fragment_Container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
    private fun frag_delete(){
//        var datahashmap=database!![position]
//        var bundle1=Bundle()
//        bundle1.putSerializable("datakeyupdate",datahashmap)
//        val detailFragment=TaskDetails()
//        detailFragment.arguments=bundle1

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
        val view = inflater.inflate(R.layout.fragment_task_details, container, false)
        val editbtn = view.findViewById(R.id.edit_task) as MaterialButton
        val Deletebtn = view.findViewById(R.id.delete_task) as MaterialButton

      editbtn.setOnClickListener {
           frag_update()
//            var datahashmap=database!![position]
//            var bundle1=Bundle()
//           bundle1.putSerializable("datakey",datahashmap)
//            bundle1.putInt("position",position)
//            val activity=view.context as AppCompatActivity
//           val detailFragment=update_Details()
//           detailFragment.arguments=bundle1
//            activity.supportFragmentManager.beginTransaction().replace(R.id.Fragment_Container,detailFragment).addToBackStack(null).commit()
      }

        Deletebtn.setOnClickListener {
            database.removeAt(position)

            frag_delete()}


        var title=view.findViewById<AppCompatCheckedTextView>(R.id.Display_title)
        var settitle= hashmapinst?.get("KeyTaskname")
        title.setText(settitle)

        var startdate=view.findViewById<AppCompatCheckedTextView>(R.id.Display_startDate)
        var set_startdate= hashmapinst?.get("KeyStartDate")
        startdate.setText(set_startdate)

        var starttime=view.findViewById<AppCompatCheckedTextView>(R.id.start_time)
        var set_startime= hashmapinst?.get("KeyeTime")
        starttime.setText(set_startime)

        var enddate=view.findViewById<AppCompatCheckedTextView>(R.id.Display_endDate)
        var set_enddate= hashmapinst?.get("KeyeDate")
        enddate.setText(set_enddate)

        var assigned=view.findViewById<AppCompatCheckedTextView>(R.id.Display__Assigned)
        var set_assigned= hashmapinst?.get("Keyassigned")
        assigned.setText(set_assigned)

        var priority=view.findViewById<AppCompatCheckedTextView>(R.id.Display__priority)
        var set_priority= hashmapinst?.get("Keypriority")
        priority.setText(set_priority)

        var desc=view.findViewById<AppCompatCheckedTextView>(R.id.Display_description)
        var set_desc= hashmapinst?.get("Keymultiline")
        desc.setText(set_desc)






// val Display_title=arguments?.getString("interfacekey")
//        view.Display_title.text=Display_title

        return view



    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TaskDetails().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


