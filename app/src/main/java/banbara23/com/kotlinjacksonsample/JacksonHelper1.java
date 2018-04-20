package banbara23.com.kotlinjacksonsample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

import java.io.IOException;

public class JacksonHelper1 {

    public static ObjectMapper createObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new KotlinModule());
//        ObjectMapper objectMapper = new ObjectMapper();

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
//
        DefaultSerializerProvider.Impl dsp = new DefaultSerializerProvider.Impl();
        dsp.setNullValueSerializer(new NullValueSerializer());
        objectMapper.setSerializerProvider(dsp);

        return objectMapper;
    }

    public static class NullValueSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object t, JsonGenerator jsonGenerator, SerializerProvider sp)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString("");
        }
    }
}
