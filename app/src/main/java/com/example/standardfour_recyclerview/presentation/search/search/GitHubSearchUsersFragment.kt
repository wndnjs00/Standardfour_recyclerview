package com.example.standardfour_recyclerview.presentation.search.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.standardfour_recyclerview.databinding.FragmentGithubSearchUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubSearchUsersFragment : Fragment() {

    private var _binding: FragmentGithubSearchUsersBinding? = null
    private val binding get() = _binding!!


    // 다른 엑티비티에서도 GitHubSearchUsersFragment호출할 수 있도록 newInstance()생성
    companion object{
        fun newInstance() = GitHubSearchUsersFragment()
    }

    // searchViewModel 선언
    private val searchViewModel: SearchViewModel by viewModels()


    // sharedViewModel 선언
    // activityViewModels() 사용 시 Activity의 라이프사이클에 의해 생존주기 결정되며, 같은 액티비티안에서 같은 데이터 공유가능
    // 프레그먼트끼리 좋아요데이터 공유하기위해서 사용
    private val sharedViewModel : GitHubUserSharedViewModel by activityViewModels()


    private val gitHubUserAdapter : GitHubUserAdapter by lazy {
        GitHubUserAdapter{
            // 어뎁터 클릭시
            // 토글버튼 클릭시, viewModel을 통해 좋아요 클릭한 아이템 가져옴
            searchViewModel.setFavoriteItem(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGithubSearchUsersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }


    private fun initView() = with(binding){
        btnSearch.setOnClickListener {
            // 내가 입력한 값받아서 보여줌
            val editText = binding.etSearch.text.toString()
            searchViewModel.getGitHubUserList(query = editText)
        }
    }


    private fun initViewModel(){

        // 검색버튼이 호출되었을때(검색에 cindy가 호출돠었을때)
        searchViewModel.getGitHubUserList.observe(viewLifecycleOwner){

            // 넘어온 값을 넣어서 어뎁터 업데이트
            gitHubUserAdapter.gitHubUserList = it

            // 리사이클러뷰와 어뎁터 연결
            with(binding.rvGithubUsers){
                adapter = gitHubUserAdapter
            }
        }


        // 좋아요 상태값 observe해서, 좋아요가 ture인 값들만 observe
        searchViewModel.favoriteUserList.observe(viewLifecycleOwner){

            // sharedViewModel.setFavoriteList에 그 넘어온값(좋아요가 ture)인값을 넣어줌
            sharedViewModel.setFavoriteList(it)
        }
    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}