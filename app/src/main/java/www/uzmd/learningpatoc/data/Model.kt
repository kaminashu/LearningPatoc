package www.uzmd.learningpatoc.data

import com.google.gson.annotations.SerializedName

data class Model(

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("startTime")
	val startTime: Any? = null,

	@field:SerializedName("endTime")
	val endTime: Any? = null,

	@field:SerializedName("endAt")
	val endAt: Any? = null,

	@field:SerializedName("title")
	val title: Any? = null,

	@field:SerializedName("startAt")
	val startAt: String? = null,

	@field:SerializedName("quality")
	val quality: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)
