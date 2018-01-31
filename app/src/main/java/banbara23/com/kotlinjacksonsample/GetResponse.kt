package banbara23.com.kotlinjacksonsample

import com.fasterxml.jackson.annotation.JsonProperty

data class GetResponse(
        @field:JsonProperty("card_type") val cardType: String = "",
        @field:JsonProperty("card_id") val cardId: String = ""
) : Response() {
    override fun toString(): String =
            "GetResponse(status='$status' cardStatus='$cardStatus' cardType='$cardType', cardId='$cardId')"
}