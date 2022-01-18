package com.papena.marvelsapp.features.landing.viewmodel


import androidx.lifecycle.ViewModel
import com.papena.marvelsapp.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {


}