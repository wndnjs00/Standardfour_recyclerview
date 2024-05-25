package com.example.standardfour_recyclerview.presentation.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.standardfour_recyclerview.presentation.search.search.GitHubUserSharedViewModel
import com.example.standardfour_recyclerview.databinding.FragmentGithubFavorateUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubFavorateUsersFragment : Fragment() {

    // 다른 엑티비티에서도 GitHubFavorateUsersFragment호출할 수 있도록 newInstance()생성
    companion object{
        fun newInstance() = GitHubFavorateUsersFragment()
    }

    private var _binding: FragmentGithubFavorateUsersBinding? = null
    private val binding get() = _binding!!


    // sharedViewModel 호출
    private val sharedViewModel : GitHubUserSharedViewModel by activityViewModels()

    // 어뎁터 호출
    private val favoriteListAdapter : FavoriteListAdapter by lazy {
        FavoriteListAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGithubFavorateUsersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }


    private fun initViewModel(){
        // 좋아요값이 true인값들을 observe해서 좋아요값이 변경되면
        sharedViewModel.favoriteLiveData.observe(viewLifecycleOwner){

            // 넘어온 값을 넣어서, 어뎁터 업데이트
            // 좋아요된값 변경될때마다 그 변경된 데이터 가져와서, 어뎁터 업데이트
            favoriteListAdapter.gitHubUserList = it

            // 어뎁터와 리사이클러뷰 연결
            binding.rvGithubUsers.adapter = favoriteListAdapter
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}