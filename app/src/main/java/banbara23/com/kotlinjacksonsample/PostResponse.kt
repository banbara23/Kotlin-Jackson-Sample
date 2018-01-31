package banbara23.com.kotlinjacksonsample

import com.fasterxml.jackson.annotation.JsonProperty

data class PostResponse(
        @field:JsonProperty("result_code") val resultCode: Int = 0
) : Response() {
    override fun toString(): String =
            "PostResponse(status='$status' cardStatus='$cardStatus' resultCode='$resultCode')"
}