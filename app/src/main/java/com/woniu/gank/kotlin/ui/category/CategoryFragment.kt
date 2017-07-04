package com.woniu.gank.kotlin.ui.category

import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.kotlin.bind
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment
import com.woniu.gank.kotlin.di.AppComponent
import io.reactivex.Observable

/**
 * @author woniu
 * @title CategoryFragment
 * @description
 * @modifier
 * @date
 * @since 2017/6/16 下午4:31
 */
class CategoryFragment : RxBaseFragment() {
    override fun inject(appComponent: AppComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //Java 调用伴生对象的方法时需要加上注解 platformStatic
    companion object {
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_category

    fun t() {
        Observable.just(1)
//                .bindUntilEvent(this, FragmentEvent.DESTROY_VIEW)
                .bindToLifecycle(this)
                .subscribe()
    }

}