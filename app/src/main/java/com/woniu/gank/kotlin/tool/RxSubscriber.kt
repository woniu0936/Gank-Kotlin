package com.woniu.gank.kotlin.tool

import io.reactivex.subscribers.DefaultSubscriber

/**
 * @author woniu
 * @title RxSubscriber
 * @description
 * @modifier
 * @date
 * @since 2017/7/7 上午1:08
 */
abstract class RxSubscriber<T> : DefaultSubscriber<T>() {

    override fun onComplete() {

    }

    override fun onError(t: Throwable?) {

    }

}