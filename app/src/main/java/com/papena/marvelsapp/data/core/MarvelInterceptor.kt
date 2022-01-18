package com.papena.marvelsapp.data.core

import okhttp3.HttpUrl

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class MarvelInterceptor(private val publicKey: String, private val privateKey: String) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val timeStamp = System.currentTimeMillis()
        val hash = generateMarvelHash(timeStamp, privateKey, publicKey)
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(PARAM_TIMESTAMP, timeStamp.toString())
            .addQueryParameter(PARAM_KEY, publicKey)
            .addQueryParameter(PARAM_HASH, hash)
            .build()
        val requestBuilder: Request.Builder = original.newBuilder().url(url)
        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun generateMarvelHash(timeStamp: Long, privateKey: String, publicKey: String): String {
        val marvelHash = timeStamp.toString() + privateKey + publicKey
        return md5(marvelHash)
    }

    companion object {
        const val PARAM_KEY = "apikey"
        const val PARAM_TIMESTAMP = "ts"
        const val PARAM_HASH = "hash"
        fun md5(s: String): String {
            val md5 = "MD5"
            try {
                val digest: MessageDigest = MessageDigest.getInstance(md5)
                digest.update(s.toByteArray())
                val messageDigest: ByteArray = digest.digest()
                val hexString = StringBuilder()
                for (aMessageDigest in messageDigest) {
                    var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                    while (h.length < 2) {
                        h = "0$h"
                    }
                    hexString.append(h)
                }
                return hexString.toString()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            return ""
        }
    }
}