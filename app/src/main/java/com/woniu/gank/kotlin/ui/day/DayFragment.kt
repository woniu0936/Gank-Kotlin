package com.woniu.gank.kotlin.ui.day

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment
import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.ui.day.viewBinder.*
import kotlinx.android.synthetic.main.fragment_day.*
import me.drakeet.multitype.MultiTypeAdapter
import me.drakeet.multitype.MultiTypeAsserts
import javax.inject.Inject

/**
 * @author woniu
 * @title DayFragment
 * @description 每日推荐
 * @modifier
 * @date
 * @since 2017/6/14 下午9:31
 */
class DayFragment : RxBaseFragment(), DayContract.View {

    @Inject
    lateinit var mPresenter: DayPresenter

    val mAdapter: MultiTypeAdapter by lazy {
        MultiTypeAdapter()
    }

    //Java 调用伴生对象的方法时需要加上注解 platformStatic
    companion object {
        fun newInstance(): DayFragment {
            return DayFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter.register(DayModel::class.java)
                .to(GirlViewBinder(),
                        VideoViewBinder(),
                        AndroidViewBinder(),
                        IOSViewBinder(),
                        JSViewBinder())
                .withClassLinker { model ->
                    when (model.type) {
                        DayModel.TYPE_VIDEO -> VideoViewBinder::class.java
                        DayModel.TYPE_RESOURCE -> JSViewBinder::class.java
                        DayModel.TYPE_ANDROID -> AndroidViewBinder::class.java
                        DayModel.TYPE_IOS -> IOSViewBinder::class.java
                        else -> GirlViewBinder::class.java
                    }
                }
    }

    //    lateinit var adapter: DayAdapter
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(_mActivity)
//        adapter = DayAdapter()
        mRecyclerView.adapter = mAdapter
        mPresenter.fetchData()
    }

    override fun getLayoutId(): Int = R.layout.fragment_day

    override fun bindLifecycle(): LifecycleProvider<FragmentEvent> = this

    override fun showLoading() {

    }

    override fun showContent(t: List<DayModel>?) {
        t?.forEach { Log.d("dayFragment", it.toString()) }
        t?.let {
            //            adapter.setList(t)
            mAdapter.items = t
            mAdapter.notifyDataSetChanged()

            MultiTypeAsserts.assertAllRegistered(mAdapter, t)
        }
    }

    override fun hideLoading() {

    }

    override fun inject(appComponent: AppComponent) {
        DaggerDayComponent.builder()
                .appComponent(appComponent)
                .dayModule(DayModule(this))
                .build()
                .inject(this)
    }

}
