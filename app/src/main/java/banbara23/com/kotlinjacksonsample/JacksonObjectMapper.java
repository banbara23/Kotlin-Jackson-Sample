package banbara23.com.kotlinjacksonsample;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

import java.io.IOException;

public class JacksonObjectMapper {
    /** ObjectMapper */
    private ObjectMapper mapper;

    /** デフォルトコンストラクタ. */
    public JacksonObjectMapper() {
        mapper = new ObjectMapper();
        DefaultSerializerProvider.Impl dsp = new DefaultSerializerProvider.Impl();
        dsp.setNullValueSerializer(new NullValueSerializer());
        mapper.setSerializerProvider(dsp);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public static class NullValueSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object t, JsonGenerator jg, SerializerProvider sp)
                throws IOException, JsonProcessingException {
            jg.writeString("");
        }
    }
}