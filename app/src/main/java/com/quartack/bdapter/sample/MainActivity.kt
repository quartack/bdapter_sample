package com.quartack.bdapter.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.quartack.bdapter.sample.basic.BasicActivity
import com.quartack.bdapter.sample.diff_util.DiffUtilActivity
import com.quartack.bdapter.sample.drag.DragActivity
import com.quartack.bdapter.sample.event.EventActivity
import com.quartack.bdapter.sample.filter.FilterActivity
import com.quartack.bdapter.sample.grid.GridActivity
import com.quartack.bdapter.sample.recycler_inside_recycler.RIRActivity
import com.quartack.bdapter.sample.sort.SortActivity
import com.quartack.bdapter.sample.tree.TreeActivity
import com.quartack.bdapter.sample.update.UpdateActivity
import com.quartack.bdapter.sample.variable_name.VariableNameActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = listOf(
            BasicActivity::class.java,
            DiffUtilActivity::class.java,
            DragActivity::class.java,
            EventActivity::class.java,
            FilterActivity::class.java,
            GridActivity::class.java,
            RIRActivity::class.java,
            SortActivity::class.java,
            TreeActivity::class.java,
            UpdateActivity::class.java,
            VariableNameActivity::class.java
        )

        val viewGroup = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        list.forEach { item ->
            Button(this).apply {
                text = item.simpleName.replace("Activity", "")
                setOnClickListener {
                    startActivity(Intent(this@MainActivity, item))
                }
            }.also {
                viewGroup.addView(it)
            }
        }

        setContentView(viewGroup)
    }
}
