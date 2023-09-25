package com.eet.etask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckedTextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [update_Details.newInstance] factory method to
 * create an instance of this fragment.
 */
class update_Details : Fragment() {
//hashmap instance
    var hashmapinst:HashMap<String,String>?=null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hashmap
//        hashmapinst= arguments!!.getSerializable("datakey") as HashMap<String,String>

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            hashmapinst= arguments!!.getSerializable("datakey") as HashMap<String,String>

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

        val view=inflater.inflate(R.layout.fragment_update__details, container, false)
        val button = view.findViewById(R.id.update_save) as MaterialButton
        button.setOnClickListener {frag()}

        // fetch value
        var title=view.findViewById<TextInputEditText>(R.id.Displayup_title)
        var s= hashmapinst?.get("KeyTaskname")
        title.setText(s)



        var desc=view.findViewById<TextInputEditText>(R.id.Display_description)
        var strdec= hashmapinst?.get("Keymultiline")
        desc.setText(strdec)



        return view


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment update_Details.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            update_Details().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }


            }
    }
}