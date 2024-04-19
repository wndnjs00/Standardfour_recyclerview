## RecyclerView Multi View Type 구현
### 학습내용
-  **viewBinding** 사용
-  **RecyclerView**를 사용하여  **Multi View Type** 구현
- 멀티뷰타입 변수를 **enum class**로 선언
- **람다식**을 사용하여 아이템 클릭 이벤트 구현
- Intent부분, 데이터 받아오는 부분 **확장함수**로 빼서 구현
- **Parcelize**와 **bundle**을 사용하여 데이터 전달, 받아오기 구현
- key값을 **const val**값으로 지정하여 공통으로 사용하게끔 구현
- **싱글톤**을 사용하여 데이터 관리
- **DecimalFormat**을 사용하여 콤마와 소숫점 표시 </br></br>

---
#### MVVM 패턴으로 수정
- Observer Pattern 사용
