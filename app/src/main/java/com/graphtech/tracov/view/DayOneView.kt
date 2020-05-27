package com.graphtech.tracov.view

import com.graphtech.tracov.model.dayone.DayOneResponse

interface DayOneView {
    fun onShowLoading()
    fun onHideLoading()
    fun onSuccessGetDayOne(data: List<DayOneResponse?>?)
    fun onErrorGetDayOne(msg: String)
}