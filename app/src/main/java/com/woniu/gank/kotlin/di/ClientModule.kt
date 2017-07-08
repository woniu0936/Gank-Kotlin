package com.woniu.gank.kotlin.di

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.woniu.gank.kotlin.BuildConfig
import com.woniu.gank.kotlin.data.bean.NetWorkInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
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
    fun provideOkHttp(interceptor: NetWorkInterceptor, loggingInterceptor: LoggingInterceptor): OkHttpClient = buildOkHttpClient(interceptor, loggingInterceptor)

    @Provides
    @Singleton
    fun provideRetrofit(okClient: OkHttpClient): Retrofit = buildRetrofit(okClient)

    @Provides
    @Singleton
    fun provideInterceptor(): NetWorkInterceptor = NetWorkInterceptor()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .addHeader("version", BuildConfig.VERSION_NAME)
                .build()
    }

    /**
     * 构建OkHttpClient对象
     */
    private fun buildOkHttpClient(interceptor: NetWorkInterceptor, loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
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