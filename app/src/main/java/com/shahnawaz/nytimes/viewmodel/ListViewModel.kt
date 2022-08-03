package com.shahnawaz.nytimes.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahnawaz.nytimes.di.component.DaggerApiComponent
import com.shahnawaz.nytimes.model.MostViewed
import com.shahnawaz.nytimes.model.MostViewedService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ListViewModel : ViewModel() {

    @Inject
    lateinit var mostViewedService: MostViewedService
    private val disposable = CompositeDisposable()

    val mostViewed = MutableLiveData<MostViewed>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    //initializing the necessary components and classes
    init {
        DaggerApiComponent.create().inject(this)
    }


    fun refresh(){
        fetchMostViewed()
    }


    private fun fetchMostViewed(){
        loading.value = true
        disposable.add(
            mostViewedService.getMostView().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableSingleObserver<MostViewed> (){
                    override fun onSuccess(value: MostViewed) {
                        mostViewed.value = value
                        countryLoadError.value = false
                        loading.value = false
                    }
                    override fun onError(e: Throwable) {
                        countryLoadError.value = true
                        loading.value = false
                    }

                })
        )
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}