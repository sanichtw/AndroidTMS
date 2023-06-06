package com.example.myapplication.presentation.fragments.testFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.presentation.view_models.CoroutinesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesTestFragment : Fragment() {

    private val viewModel: CoroutinesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coroutines_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        launchCoroutines()
    }

    private fun launchCoroutines() {
        workWithCoroutines()
    }


    private fun workWithCoroutines() =
        viewModel.viewModelScope.launch {
            Log.d("TEST_ANDROID", "Start downloading files..")
            downloadTenFiles()
            Log.d("TEST_ANDROID", "Files downloaded!")
        }

    private suspend fun downloadTenFiles() =
       coroutineScope {
           launch { downloadFiveFilesUsingLaunch() }
           async { downloadFiveFilesUsingAsync() }
       }

    private suspend fun downloadFiveFilesUsingLaunch() =
        coroutineScope {
            downloadFirstFile()
            downloadSecondFile()
            downloadThirdFile()
            downloadFourthFile()
            downloadFifthFile()
        }

    private suspend fun downloadFiveFilesUsingAsync() =
        coroutineScope {
            downloadSixthFile()
            downloadSeventhFile()
            downloadEighthFile()
            downloadNinthFile()
            downloadTenthFile()
        }


    private suspend fun downloadFirstFile() = withContext(Dispatchers.IO) {
        Log.d("TEST_ANDROID", "Download the first file..")
        delay(1000)
        Log.d("TEST_ANDROID", "The first file is downloaded..")
    }

    private suspend fun downloadSecondFile() = withContext(Dispatchers.IO) {
        Log.d("TEST_ANDROID", "Download the second file..")
        delay(5000)
        Log.d("TEST_ANDROID", "The second file is downloaded..")
    }

    private suspend fun downloadThirdFile() = withContext(Dispatchers.IO) {
        Log.d("TEST_ANDROID", "Download the third file..")
        delay(1200)
        Log.d("TEST_ANDROID", "The third file is downloaded..")
    }

    private suspend fun downloadFourthFile() = withContext(Dispatchers.IO) {
        Log.d("TEST_ANDROID", "Download the fourth file..")
        delay(2000)
        Log.d("TEST_ANDROID", "The fourth file is downloaded..")
    }

    private suspend fun downloadFifthFile() = withContext(Dispatchers.IO) {
        Log.d("TEST_ANDROID", "Download the fifth file..")
        delay(1600)
        Log.d("TEST_ANDROID", "The fifth file is downloaded..")
    }


    private suspend fun downloadSixthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", "Download the sixth file..")
        delay(500)
        Log.d("TEST_ANDROID", "The sixth file is downloaded..")
    }

    private suspend fun downloadSeventhFile() = withContext(IO) {
        Log.d("TEST_ANDROID", "Download the seventh file..")
        delay(1000)
        Log.d("TEST_ANDROID", "The seventh file is downloaded..")
    }

    private suspend fun downloadEighthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", "Download the eighth file..")
        delay(3000)
        Log.d("TEST_ANDROID", "The eighth file is downloaded..")
    }

    private suspend fun downloadNinthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", "Download the ninth file..")
        delay(1000)
        Log.d("TEST_ANDROID", "The ninth file is downloaded..")
    }

    private suspend fun downloadTenthFile() = withContext(IO) {
        Log.d("TEST_ANDROID", "Download the tenth file..")
        delay(2000)
        Log.d("TEST_ANDROID", "The tenth file is downloaded..")
    }
}