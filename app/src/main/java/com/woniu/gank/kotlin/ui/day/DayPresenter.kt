package com.woniu.gank.kotlin.ui.day

import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.woniu.gank.kotlin.data.DataManager
import com.woniu.gank.kotlin.data.bean.DayBean
import com.woniu.gank.kotlin.data.bean.GankBean
import com.woniu.gank.kotlin.di.PerFragment
import com.woniu.gank.kotlin.tool.RxSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * @author woniu
 * @title DayPresenter
 * @description
 * @modifier
 * @date
 * @since 2017/6/21 下午5:48
 */
@PerFragment
class DayPresenter @Inject constructor(private val mView: DayContract.View) : DayContract.Presenter {

//    @Inject
//    internal var mDataManager: DataManager? = null

    /*对于非空类型的属性是必须初始化的。如果我们希望延迟进行初始化，就可以使用lateinit关键字了
    * lateinit只能在不可null的对象上使用，比须为var，不能为primitives（Int、Float之类）*/
    @Inject
    lateinit var mDataManager: DataManager  //这种写法比上面的写法更加合适

    /**
     * 获取每日数据
     */
    override fun fetchData() {
        mDataManager.getDay()
                .map(transform)
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(mView.bindLifecycle(), FragmentEvent.DESTROY_VIEW)
                .subscribe(object : RxSubscriber<List<DayModel>>() {
                    override fun onNext(t: List<DayModel>?) {
                        mView.showContent(t)
                    }

                })
//                .delay(3, TimeUnit.SECONDS)
//                .doOnError { Log.d("DayPresenter", it.message) }
//                .subscribe {
//                    bean ->
//                    bean?.IOS.forEach { Log.d("DayPresenter", it.toString()) }
//                    bean?.android.forEach { Log.d("DayPresenter", it.toString()) }
//                    bean.resource?.forEach { Log.d("DayPresenter", it.toString()) }
//                    bean?.video.forEach { Log.d("DayPresenter", it.toString()) }
//                    bean?.girl.forEach { Log.d("DayPresenter", it.toString()) }
//                }
    }

    private val transform = { result: DayBean ->
        var datas = arrayListOf<DayModel>()
        result.girl?.let {
            datas.addAll(DayModel.transform(result.girl))
        }

        result.android?.let {
            datas.addAll(DayModel.transform(result.android))
        }

        result.IOS?.let {
            datas.addAll(DayModel.transform(result.IOS))
        }

        result.resource?.let {
            datas.addAll(DayModel.transform(result.resource))
        }

        result.video?.let {
            datas.addAll(DayModel.transform(result.video))
        }

        datas
    }

    //和上面不写transform@的lambda表达式相同
//    private val transform = transform@ { result: DayBean ->
//        var datas = arrayListOf<GankBean>()
//        result.girl?.let {
//            datas.addAll(result.girl)
//        }
//
//        result.android?.let {
//            datas.addAll(result.android)
//        }
//
//        result.IOS?.let {
//            datas.addAll(result.IOS)
//        }
//
//        result.resource?.let {
//            datas.addAll(result.resource)
//        }
//
//        result.video?.let {
//            datas.addAll(result.video)
//        }
//
//        return@transform datas
//    }

    //对应函数fetchData()中的.map { result -> transform(result) }
    private fun transform(result: DayBean): List<GankBean> {
        var datas = arrayListOf<GankBean>()
        result.girl?.let {
            result.girl.forEach { datas.add(it) }
        }

        result.android?.let {
            result.android.forEach { datas.add(it) }
        }

        result.IOS?.let {
            result.IOS.forEach { datas.add(it) }
        }

        result.resource?.let {
            result.resource.forEach { datas.add(it) }
        }

        result.video?.let {
            result.video.forEach { datas.add(it) }
        }

        return datas
    }

}
