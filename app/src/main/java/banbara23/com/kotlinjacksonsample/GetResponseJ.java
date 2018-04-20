package banbara23.com.kotlinjacksonsample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetResponseJ {
    @JsonProperty("card_type")
//    @JsonSetter(nulls = Nulls.AS_EMPTY)
            String cardType;

    @JsonProperty("card_id")
    String cardId;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "GetResponseJ{" +
                "cardType='" + cardType + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
