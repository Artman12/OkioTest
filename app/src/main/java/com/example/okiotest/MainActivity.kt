package com.example.okiotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.okiotest.data.Node
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.okio.decodeBufferedSourceToSequence
import kotlinx.serialization.json.okio.decodeFromBufferedSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun getNodes(count: Int, depth: Int) : List<Node> {
            val ret = mutableListOf<Node>()
            if (depth == 0) return ret
            for (i in 0 until count) {
                ret.add(Node(getNodes(1, depth - 1)))
            }
            return ret
        }

        val rootNode = Node(getNodes(1000, 10))

        val json = Serializer.json.encodeToString(rootNode)

        val buffer = okio.Buffer().apply {
            write(json.toByteArray())
        }

//        val decodedNode = Serializer.json.decodeFromString<Node>(json)
        val decodedNode = Serializer.json.decodeFromBufferedSource<Node>(buffer)

        Log.i("!!!!!!!!", "decodedNode: " + decodedNode.children?.size);
    }
}