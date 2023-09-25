package com.eet.etask
import android.content.Context
import android.os.Bundle
import android.text.method.Touch.onTouchEvent
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.eet.etask.Data.database
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_task_details.*
class Dashboard: Fragment() {
    val TAG = "Dashboard"
    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        val posts: ArrayList<Data> = ArrayList()
        recyclerView1.layoutManager = LinearLayoutManager(context)
        recyclerView1.adapter = dataAdapter2(Data.database)}

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    private fun frag(){
        val manager=fragmentManager
        val transaction= manager?.beginTransaction()
        val fragment=AddTask()
        transaction?.replace(R.id.Fragment_Container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val d = Log.d(TAG, "onCreateView")
        val v = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val button = v.findViewById(R.id.add_task) as FloatingActionButton
              button.setOnClickListener {frag()}
        if(database !=null&& database.size>0) {
            println("this is dashboard")
            println(database[0].toString())
        }
        return v
    }

    override fun onStart() {
        Log.d(TAG,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG,"onDestroyView")
        super.onDestroyView()

    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG,"onDetach")
        super.onDetach()
    }
}

