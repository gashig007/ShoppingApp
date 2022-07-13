package com.geektech.shoppingapplication.presentation.list

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.geektech.shoppingapplication.databinding.ActivityListBinding
import com.geektech.shoppingapplication.domain.entity.ShopItem
import com.geektech.shoppingapplication.presentation.main.MainViewModel
import com.geektech.shoppingapplication.presentation.list.adapter.ListAdapter
import com.geektech.shoppingapplication.presentation.detail.DetailActivity
import kotlin.random.Random

class ListActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityListBinding
    private var adapter = ListAdapter()


    var startForResult: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initAdapter()
        resultListener()
        initListener()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startForResult?.launch(intent)
        }
    }

    private fun initAdapter() {
        binding.recyclerList.adapter = adapter
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.list[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
                adapter.list = viewModel.getShopList()
            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerList)
    }

    private fun resultListener() {
        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    val name = intent?.getStringExtra(KEY_NAME)
                    val count = intent?.getStringExtra(KEY_COUNT)
                    viewModel.addShopItem(ShopItem(name, count?.toInt(), Random.nextBoolean()))
                    adapter.list = viewModel.getShopList()
                }
            }
    }

    companion object {
        private val KEY_NAME = "name"
        private val KEY_COUNT = "count"
    }
}
