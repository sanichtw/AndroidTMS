//package com.example.myapplication.di.module
//
//import android.app.Application
//import android.content.Context
//import android.view.View
//import com.bumptech.glide.Glide
//import com.bumptech.glide.RequestManager
//import com.example.myapplication.domain.models.DomainPost
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.EntryPoint
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@EntryPoint
//@InstallIn(SingletonComponent::class)
//interface GlideModule {
////        var glide: RequestManager
////        var context: Context
////        var items: List<DomainPost>
////        var event: (View) -> Unit
////
//
////    // Providing Application as a dependency also ensures uniformity and prevents multiple
////    // RequestManager instances from being created for different application contexts. When using
////    // Application instead of an activity context or fragment, you can guarantee that you will have
////    // only one instance of RequestManager for the entire lifetime of the application.
////
////    @Singleton
////    @Provides
////    fun provideGlide(application: Application): RequestManager = Glide.with(application)
//}