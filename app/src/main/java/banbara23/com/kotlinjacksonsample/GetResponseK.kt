package banbara23.com.kotlinjacksonsample

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * GETレスポンスのモデル
 */
data class GetResponseK(
        @field:JsonProperty("card_type")
//        @field:JsonSetter(nulls = Nulls.DEFAULT)
        val cardType: String? = "",


        @field:JsonProperty("card_id")
//        @field:JsonSetter(nulls = Nulls.AS_EMPTY)
        val cardId: String? = ""

) : Response() {
    override fun toString(): String =
            "GetResponseK(status='$status' cardStatus='$cardStatus' cardType='$cardType', cardId='$cardId')"
}