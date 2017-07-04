package com.woniu.gank.kotlin.di

import com.woniu.gank.kotlin.data.bean.NetWorkInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author woniu
 * @title ClientModule
 * @description
 * @modifier
 * @date
 * @since 2017/6/21 下午2:44
 */
@Module
class ClientModule(val baseUrl: String) {

    val READ_TIME_OUT = 3000L
    val WRITE_TIME_OUT = 3000L
    val CONNECT_TIME_OUT = 3000L

    @Provides
    @Singleton
    fun provideOkHttp(interceptor: NetWorkInterceptor): OkHttpClient = buildOkHttpClient(interceptor)

    @Provides
    @Singleton
    fun provideRetrofit(okClient: OkHttpClient): Retrofit = buildRetrofit(okClient)

    @Provides
    @Singleton
    fun provideInterceptor(): NetWorkInterceptor = NetWorkInterceptor()

    /**
     * 构建OkHttpClient对象
     */
    private fun buildOkHttpClient(interceptor: NetWorkInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                .build()
    }

    /**
     * 构建Retrofit对象
     */
    private fun buildRetrofit(okClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}