package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.net.toUri
import com.kii.cloud.storage.KiiObject

private val loadingObject =
    KiiObject.createByUri("kiicloud://buckets/loading/objects/loading".toUri())

@Composable
fun ObjectViewerScreen(
    viewModel: ObjectViewerViewModel,
    back: () -> Unit,
) {
    val obj by viewModel.obj.collectAsState(loadingObject)
    val showEditDialog by viewModel.showEditDialog.collectAsState()
    val editKey by viewModel.editKey.collectAsState()
    val editValueType by viewModel.editValueType.collectAsState()
    val editValueExpanded by viewModel.editValueExpanded.collectAsState()
    val editValue by viewModel.editValue.collectAsState()

    val inProgress by viewModel.inProgress.collectAsState()
    val done by viewModel.done.collectAsState()

    ObjectViewerScreen(
        obj = obj,
        inProgress = inProgress,
        done = done,
        showEditDialog = showEditDialog,
        editKey = editKey,
        editValueExpanded = editValueExpanded,
        editValueType = editValueType,
        editValue = editValue,
        openEditDialog = { key, valueType, value ->
            viewModel.openEditDialog(
                key,
                valueType,
                value
            )
        },
        closeEditDialog = { viewModel.closeEditDialog() },
        setEditKey = { value -> viewModel.editKey.value = value },
        setEditValueExpanded = { value -> viewModel.editValueExpanded.value = value },
        setEditValueType = { type -> viewModel.setEditValueType(type) },
        setEditValue = { value -> viewModel.editValue.value = value },
        submit = { viewModel.submitEdit(it) },
        save = { viewModel.save(it) },
        back = back,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectViewerScreen(
    obj: KiiObject,
    inProgress: Boolean,
    done: Boolean,
    showEditDialog: Boolean,
    editKey: String,
    editValueExpanded: Boolean,
    editValueType: Int,
    editValue: String,
    openEditDialog: (key: String, valueType: Int, value: String) -> Unit,
    closeEditDialog: () -> Unit,
    setEditKey: (value: String) -> Unit,
    setEditValueExpanded: (value: Boolean) -> Unit,
    setEditValueType: (value: Int) -> Unit,
    setEditValue: (value: String) -> Unit,
    submit: (obj: KiiObject) -> Unit,
    save: (obj: KiiObject) -> Unit,
    back: () -> Unit,
) {
    LaunchedEffect(done) {
        if (done) {
            back()
        }
    }
    if (done) return
    Scaffold { paddingValues ->
        if (obj === loadingObject) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp)
                )
            }
            return@Scaffold
        }
        Column {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp),
                    enabled = !inProgress,
                    onClick = { openEditDialog("", 2, "") },
                ) {
                    Text("Add")
                }
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp),
                    enabled = !inProgress,
                    onClick = { save(obj) },
                ) {
                    Text("Save")
                }
            }
            val keys = obj.keySet().toSortedSet().toList()
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {
                items(keys) { key ->
                    ObjectField(key, obj.getObject(key), openEditDialog)
                }
            }
        }
        if (showEditDialog) {
            EditFieldDialog(
                obj = obj,
                editKey = editKey,
                editValueExpanded = editValueExpanded,
                editValueType = editValueType,
                editValue = editValue,
                closeEditDialog = closeEditDialog,
                setEditKey = setEditKey,
                setEditValueExpanded = setEditValueExpanded,
                setEditValueType = setEditValueType,
                setEditValue = setEditValue,
                submit = submit,
            )
        }
    }
}

@Composable
fun ObjectField(
    key: String,
    value: Any,
    openEditDialog: (key: String, valueType: Int, value: String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                openEditDialog(key, toType(value), value.toString())
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(key, modifier = Modifier.weight(1.0f))
            Text(value.toString(), modifier = Modifier.weight(1.0f))
        }
        Divider(modifier = Modifier.offset(y = 23.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditFieldDialog(
    obj: KiiObject,
    editKey: String,
    editValueExpanded: Boolean,
    editValueType: Int,
    editValue: String,

    closeEditDialog: () -> Unit,
    setEditKey: (value: String) -> Unit,
    setEditValueExpanded: (value: Boolean) -> Unit,
    setEditValueType: (value: Int) -> Unit,
    setEditValue: (value: String) -> Unit,
    submit: (obj: KiiObject) -> Unit,
) {
    Dialog(onDismissRequest = closeEditDialog) {
        Surface {
            Column {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 32.dp)
                        .fillMaxWidth(),
                    label = {
                        Text("Key")
                    },
                    value = editKey,
                    onValueChange = setEditKey,
                )
                ExposedDropdownMenuBox(
                    expanded = editValueExpanded,
                    onExpandedChange = setEditValueExpanded,
                ) {
                    OutlinedTextField(
                        readOnly = true,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 8.dp),
                        label = {
                            Text("Type")
                        },
                        value = typeToText(editValueType), onValueChange = {}
                    )
                    ExposedDropdownMenu(
                        expanded = editValueExpanded,
                        onDismissRequest = { setEditValueExpanded(false) }
                    ) {
                        listOf(1, 2).forEach {
                            DropdownMenuItem(
                                text = {
                                    Text(typeToText(it))
                                },
                                onClick = {
                                    setEditValueType(it)
                                }
                            )
                        }
                    }
                }
                OutlinedTextField(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    label = {
                        Text("Value")
                    },
                    value = editValue,
                    onValueChange = setEditValue,
                )
                Row(
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = closeEditDialog
                    ) {
                        Text(stringResource(id = android.R.string.cancel))
                    }
                    TextButton(
                        modifier = Modifier.padding(start = 16.dp),
                        onClick = { submit(obj) },
                    ) {
                        Text(stringResource(id = android.R.string.ok))
                    }
                }
            }
        }
    }
}

private fun toType(value: Any) = when (value) {
    is Int -> 1
    is String -> 2
    else -> 2
}

private fun typeToText(value: Int) = when (value) {
    1 -> "Int"
    2 -> "String"
    else -> "String"
}