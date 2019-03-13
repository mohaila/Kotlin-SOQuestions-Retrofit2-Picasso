package ca.qc.mtl.mohaila.kotlinsoquestionsretrofit2

import com.google.gson.annotations.SerializedName

class Questions(@SerializedName("items") val questions: List<Question>)
