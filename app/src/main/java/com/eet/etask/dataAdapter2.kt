package com.eet.etask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatCheckedTextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class dataAdapter2(private val database: ArrayList<HashMap<String, String>>?): RecyclerView.Adapter<dataAdapter2.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{v:View->
                val position:Int=adapterPosition
//                val position1:Int=layoutPosition
                var datahashmap=database!![position]
                var bundle=Bundle()
                bundle.putSerializable("datakey",datahashmap)
                bundle.putInt("position",position)
                Toast.makeText(itemView.context,"you clicked on item"+(position+1), Toast.LENGTH_LONG).show()
                val activity=v.context as AppCompatActivity
                val detailFragment=TaskDetails()
                detailFragment.arguments=bundle
                activity.supportFragmentManager.beginTransaction().replace(R.id.Fragment_Container,detailFragment).addToBackStack(null).commit()


//// for update fragment
//                var bundle1=Bundle()
//                bundle1.putSerializable("datakeyupdate",datahashmap)
//                val activity1=v.context as AppCompatActivity
                val updateFragment=update_Details()
                updateFragment.arguments=bundle
//                activity1.supportFragmentManager.beginTransaction().replace(R.id.Fragment_Container,updateFragment).addToBackStack(null).commit()
            }
        }
        val title: TextView = itemView.findViewById(R.id.view_title)
        val startDate: TextView = itemView.findViewById(R.id.view_start_date)
        val endDate: TextView = itemView.findViewById(R.id.view_end_date)
        val startTime: TextView = itemView.findViewById(R.id.view_start_time)
        val endTime: TextView = itemView.findViewById(R.id.view_end_time)
        val aSsigned: TextView = itemView.findViewById(R.id.view_assigned_to)
        val pRiority: TextView = itemView.findViewById(R.id.view_priority)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return database!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = database?.get(position)?.get("KeyTaskname").toString()
        holder.startDate.text = database?.get(position)?.get("KeyStartDate").toString()
        holder.endDate.text = database?.get(position)?.get("KeyeDate").toString()
        holder.startTime.text = database?.get(position)?.get("KeysTime").toString()
        holder.endTime.text = database?.get(position)?.get("KeyeTime").toString()
        holder.aSsigned.text = database?.get(position)?.get("Keyassigned").toString()
        holder.pRiority.text = database?.get(position)?.get("Keypriority").toString()

//        holder.itemView.setOnClickListener{
//
////         object:View.OnClickListener
//            val activity=it.context as AppCompatActivity
//            val detailFragment=TaskDetails()
//            activity.supportFragmentManager.beginTransaction().replace(R.id.Fragment_Container,detailFragment).commit()
//
//        }
    }
}


