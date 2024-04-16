package com.example.standardfour_recyclerview.presentation.enums


// 멀티뷰타입을 위해 상수 정의(enum으로 만들어보기)
// enum class로 열거형 클래스로 만들기 (코드 단순, 가독성 up)
enum class MultiViewEnum(val viewType : Int) {

    MULTI_VIEWTYPE1(0),
    MULTI_VIEWTYPE2(1),
    MULTI_VIEWTYPE3(2)
}