package com.example.standardfour_recyclerview.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Application 클래스 작성
// Hilt 라이브러리는 Application와 ApplicationContext에 접근하기 위해 ApplicationClass가 필요!

@HiltAndroidApp
class StandardApplication : Application()