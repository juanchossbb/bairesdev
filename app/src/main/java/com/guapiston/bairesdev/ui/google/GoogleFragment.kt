package com.guapiston.bairesdev.ui.google

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.guapiston.bairesdev.R

class GoogleFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_google,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString("url") ?: ""
        val webview = view.findViewById<WebView>(R.id.wv_google)
        webview.loadUrl(url)
    }

    companion object{
        fun newInstance(url : String) : GoogleFragment{
            return GoogleFragment().apply { arguments = bundleOf("url" to url) }
        }
    }
}