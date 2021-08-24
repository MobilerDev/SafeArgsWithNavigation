package com.cevlikalprn.safeargswithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.cevlikalprn.safeargswithnavigation.databinding.FragmentConfirmationBinding
import com.cevlikalprn.safeargswithnavigation.Character

class ConfirmationFragment : Fragment() {

    private lateinit var confirmationBinding: FragmentConfirmationBinding
    private val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        confirmationBinding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return confirmationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //First Way
        if(args.character != null) {
            showCharacterInformation(args.character!!)
        }
        showRoomNumber(args.room)

        //Second Way
        /*
        val bundle = arguments
        if(bundle != null) {
            val args = ConfirmationFragmentArgs.fromBundle(bundle)
            showCharacterInformation(args.character!!)
            showRoomNumber(args.room)
        }
         */

    }

    private fun showCharacterInformation(character: Character){
        confirmationBinding.imgProfile.setImageResource(character.characterImage)
        confirmationBinding.txtCharacterName.text = character.characterName
        confirmationBinding.txtCharacterAge.text = character.characterAge.toString()
    }
    private fun showRoomNumber(number: Int){
        confirmationBinding.txtRoomNumber.text = number.toString()
    }

}