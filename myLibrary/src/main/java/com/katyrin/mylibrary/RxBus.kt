package com.katyrin.mylibrary

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject

internal object RxBus {

    private val bus: Subject<String> = PublishSubject.create()

    fun publish(textState: String): Unit = bus.onNext(textState)

    fun subscribe(block: (textState: String) -> Unit): Disposable = bus.subscribe { block(it) }
}