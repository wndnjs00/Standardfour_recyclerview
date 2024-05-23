package com.example.standardfour_recyclerview.presentation.githubmain

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

data class SearchMainTabModel(
    val fragment : Fragment,
    @StringRes val title : Int
)
