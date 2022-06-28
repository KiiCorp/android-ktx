package com.kii.cloud.storage.ktx.demo.feature.group.screen

sealed class Screens(val route: String) {
    object Top : Screens("groups/top")
    object JoinedAsMember : Screens("groups/list/member")
    object JoinedAsOwner : Screens("groups/list/owner")
    object Create : Screens("groups/create")
}
