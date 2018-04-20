package banbara23.com.kotlinjacksonsample

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * GETレスポンスのモデル
 */
data class GetResponseK(
        @field:JsonProperty("card_type")
        val cardType: String? = "",


        @field:JsonProperty("card_id")
        val cardId: String? = ""

) : Response() {
    override fun toString(): String =
            "GetResponseK(status='$status' cardStatus='$cardStatus' cardType='$cardType', cardId='$cardId')"
}