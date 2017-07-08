package com.woniu.gank.kotlin.tool

import android.util.Log
import com.woniu.gank.kotlin.data.bean.HttpResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer

/**
 * @author woniu
 * @title RxHelper
 * @description
 * @modifier
 * @date
 * @since 2017/6/30 下午2:47
 */
object RxHelper {

    val TAG = RxHelper::class.java.simpleName

    /**
     * 将HttpResponse<T>转换成T
     */
    fun <T> transerformResult(): FlowableTransformer<HttpResponse<T>, T> {
        return FlowableTransformer { upstream ->
            upstream.flatMap { httpResponse ->
                if (httpResponse.error) {
                    Flowable.error(RuntimeException(""))
                } else {
                    Log.d(TAG, httpResponse.toString())
                    createFlowable(httpResponse.data)
                }
            }
        }
    }

    //和上面的方法相同，在kotlin的lambda表达式中，如果只有一个参数，则可以直接不写 "->"左边的参数，在右边直接用it代替
//    fun <T> transerformResult() : FlowableTransformer<HttpResponse<T>, T> {
//        return FlowableTransformer { upstream ->
//            upstream.flatMap {
//                if(it.error) {
//                    Flowable.error(RuntimeException(""))
//                } else {
//                    createFlowable(it.data)
//                }
//            }
//        }
//    }

    //和上面的方法相同，kotlin的lambda表达式中，如果参数支持解构，则可以写成如下，例如：data class，map等
//    fun <T> transerformResult() : FlowableTransformer<HttpResponse<T>, T> {
//        return FlowableTransformer { upstream ->
//            upstream.flatMap { (data, error) ->
//                if(error) {
//                    Flowable.error(RuntimeException(""))
//                } else {
//                    createFlowable(data)
//                }
//            }
//        }
//    }

    //上面函数transerformResult的java实现如下
//    public <T> FlowableTransformer<HttpResponse<T>, T> transformer() {
//        return new FlowableTransformer<HttpResponse<T>, T>() {
//            @Override
//            public Publisher<T> apply(@NonNull Flowable<HttpResponse<T>> upstream) {
//                return upstream.flatMap(new Function<HttpResponse<T>, Publisher<T>>() {
//                    @Override
//                    public Publisher<T> apply(@NonNull HttpResponse<T> tHttpResponse) throws Exception {
//                        if (tHttpResponse.getError()) {
//                            return Flowable.error(new RuntimeException(""));
//                        } else {
//                            return createFlowable(tHttpResponse.getData());
//                        }
//                    }
//                });
//            }
//        };
//    }

    /**
     * 创建一个Flowable对象
     */
    private fun <T> createFlowable(t: T): Flowable<T> {
        return Flowable.create({ fe ->
            try {
                if (!fe.isCancelled())
                    fe.onNext(t)
                fe.onComplete()
            } catch (e: Exception) {
                if (!fe.isCancelled()) fe.onError(e)
            }
        }, BackpressureStrategy.BUFFER)
    }

}