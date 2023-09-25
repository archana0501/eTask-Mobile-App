package com.eet.etask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BaseActivity : AppCompatActivity(),Communicator {

    val manager = supportFragmentManager
    var isAddTaskLoaded=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)


        val transaction = manager.beginTransaction()
        val fragment = Dashboard()
        transaction.add(R.id.Fragment_Container, fragment)
        transaction.addToBackStack(null)
       transaction.commit() }

    //for interface communicator

    override fun passdata(database: ArrayList<HashMap<String, String>>) {

        val bundle=Bundle()
        bundle.putString("interfacekey", database.toString())
        val fragmenttask=TaskDetails()
        fragmenttask.arguments=bundle

    }
}
