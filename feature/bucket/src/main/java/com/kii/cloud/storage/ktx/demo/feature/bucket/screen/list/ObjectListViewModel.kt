package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kii.cloud.storage.Kii
import com.kii.cloud.storage.KiiBucket
import com.kii.cloud.storage.KiiObject
import com.kii.cloud.storage.ktx.queryAsync
import com.kii.cloud.storage.query.KiiQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

abstract class ObjectListViewModel : ViewModel() {
    abstract fun getBucket(): KiiBucket

    val objectList = flow<List<KiiObject>> {
        val objects = mutableListOf<KiiObject>()
        var query = KiiQuery()
        while (true) {
            val result = getBucket().queryAsync(query)
            objects.addAll(result.result)
            if (!result.hasNext()) {
                break
            }
            query = result.nextKiiQuery!!
        }
        this.emit(objects)
    }
}

@HiltViewModel
class AppObjectLitViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ObjectListViewModel() {
    override fun getBucket(): KiiBucket {
        val name = savedStateHandle.get<String>("name") ?: ""
        return Kii.bucket(name)
    }

}