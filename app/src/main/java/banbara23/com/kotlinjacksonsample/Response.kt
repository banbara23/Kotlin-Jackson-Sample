package banbara23.com.kotlinjacksonsample

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 共通レスポンス
 */
open class Response(
        // NG
        //@JsonProperty("status") val status: Int = 0,
        //@JsonProperty("card_status") val cardStatus: Int = 0

        // OK
        @field:JsonProperty("status") val status: Int = 0,
        @field:JsonProperty("card_status") val cardStatus: Int = 0
)