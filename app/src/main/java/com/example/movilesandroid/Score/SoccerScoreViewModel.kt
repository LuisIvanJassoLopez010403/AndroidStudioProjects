package com.example.movilesandroid.Score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//Model
data class SoccerScoreLocalModel(val localScore: Int)
data class SoccerScoreVisitModel(val visitScore: Int)

//ViewModel
class SoccerScoreViewModel : ViewModel() {
    val currentLocalScore = MutableLiveData(0)
    fun getLocalScore(): LiveData<Int> = currentLocalScore

    val currentVisitScore = MutableLiveData(0)
    fun getVisitScore(): LiveData<Int> = currentVisitScore

    fun incrementLocalScore(localModel: SoccerScoreLocalModel){
        var incrementedScoreLocal = localModel.localScore + 1
        currentLocalScore.postValue(incrementedScoreLocal)
    }

    fun incrementVisitScore(visitModel: SoccerScoreVisitModel){
        var incrementedScoreVisit = visitModel.visitScore + 1
        currentVisitScore.postValue(incrementedScoreVisit)
    }
}
