package com.geniusforapp.nytimes.shared.rx

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @name testAndroidDagger
 * Copyrights (c) 10/1/18 Created By Ahmad Najar
 **/
class AppSchedulerProvider @Inject constructor() : SchedulerProvider {

    override fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> =
            ObservableTransformer { upstream ->
                upstream.subscribeOn(io())
                        .observeOn(ui())
            }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> =
            SingleTransformer { upstream ->
                upstream.subscribeOn(io())
                        .observeOn(ui())
            }


    override fun ioToMainCompletableScheduler(): CompletableTransformer =
            CompletableTransformer { upstream ->
                upstream.subscribeOn(io())
                        .observeOn(ui())
            }


    override fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> =
            FlowableTransformer { upstream ->
                upstream.subscribeOn(io())
                        .observeOn(ui())
            }


    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> =
            MaybeTransformer { upstream ->
                upstream.subscribeOn(io())
                        .observeOn(ui())
            }


    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }
}