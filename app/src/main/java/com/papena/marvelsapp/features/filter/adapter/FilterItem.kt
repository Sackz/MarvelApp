package com.papena.marvelsapp.features.filter.adapter

import java.io.Serializable

data class FilterItem(
    var name: String,
    var id: String,
    var selected: Boolean
): Serializable
