package com.cevlikalprn.safeargswithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cevlikalprn.safeargswithnavigation.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(), View.OnClickListener{

    private lateinit var registerBinding: FragmentRegisterBinding
    private var selectedAvatar: Int? = null
    private var isAvatarSelected: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBinding.btnNext.setOnClickListener(this)
        registerBinding.includeAvatar.imageView1.setOnClickListener(this)
        registerBinding.includeAvatar.imageView2.setOnClickListener(this)
        registerBinding.includeAvatar.imageView3.setOnClickListener(this)
        registerBinding.includeAvatar.imageView4.setOnClickListener(this)
        registerBinding.includeAvatar.imageView5.setOnClickListener(this)
        registerBinding.includeAvatar.imageView6.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.btn_next -> {
                    if (check()) {
                        val character = createCharacter()
                        val roomNumber = registerBinding.etRoomNumber.text.toString().toInt()
                        val action = RegisterFragmentDirections.actionRegisterFragmentToConfirmationFragment(roomNumber)
                        action.character = character
                        findNavController().navigate(action)
                    }
                }
                R.id.imageView1 -> {
                    isAvatarSelected = true
                    selectedAvatar = Constants.avatar1
                }
                R.id.imageView2 -> {
                    isAvatarSelected = true
                    selectedAvatar = Constants.avatar2
                }
                R.id.imageView3 -> {
                    isAvatarSelected = true
                    selectedAvatar = Constants.avatar3
                }
                R.id.imageView4 -> {
                    isAvatarSelected = true
                    selectedAvatar = Constants.avatar4
                }
                R.id.imageView5 -> {
                    isAvatarSelected = true
                    selectedAvatar = Constants.avatar5
                }
                R.id.imageView6 -> {
                    isAvatarSelected = true
                    selectedAvatar = Constants.avatar6
                }
            }
        }
    }

    private fun check():Boolean {
        return if (registerBinding.includeInformationAboutCharacter.etCharacterName.text.toString().isEmpty() ||
            registerBinding.includeInformationAboutCharacter.etCharacterAge.text.toString().isEmpty() ||
            registerBinding.etRoomNumber.text.toString().isEmpty() || !isAvatarSelected) {
            Toast.makeText(requireActivity(), "Choose an Avatar and fill in the blanks", Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }
    }

    private fun createCharacter(): Character {
        return Character(selectedAvatar!!,
            registerBinding.includeInformationAboutCharacter.etCharacterName.text.toString(),
            registerBinding.includeInformationAboutCharacter.etCharacterAge.text.toString().toInt())
    }


}