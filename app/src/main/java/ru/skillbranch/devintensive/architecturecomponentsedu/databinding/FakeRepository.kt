package ru.skillbranch.devintensive.architecturecomponentsedu.databinding

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    private val fruitNames: List<String> = listOf(
            "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig",
            "Pear", "Strawberry", "Gooseberry", "Raspberry"
    )

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruitName.value = getRandomFruitName()
    }
}