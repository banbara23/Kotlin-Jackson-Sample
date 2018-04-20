package banbara23.com.kotlinjacksonsample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

public class JacksonHelper {

    public static ObjectMapper createObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new KotlinModule());

        // マッピング対象のクラスには存在しないフィールドを無視する
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // マッピング対象のクラスで明示的に無視するフィールドを無視する
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        VisibilityChecker<?> checker
                = objectMapper.getVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);

        objectMapper.setVisibility(checker);
        objectMapper.configOverride(String.class).setSetterInfo((JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY)));
        return objectMapper;
    }
}
