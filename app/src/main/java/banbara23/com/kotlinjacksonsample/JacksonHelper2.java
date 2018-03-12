package banbara23.com.kotlinjacksonsample;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class JacksonHelper2 {

    public static ObjectMapper createObjectMapper() {

        ObjectMapper om = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Object.class, new NullHandlerDeserializer());
        om.registerModule(module);

        return om;
    }

    public static class NullHandlerDeserializer extends UntypedObjectDeserializer {

        private static final long serialVersionUID = 1L;

        @Override
        public Object deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException {
            switch (jp.getCurrentToken()) {
                case VALUE_NULL:
                    return "";
                default:
                    return super.deserialize(jp, ctxt);
            }
        }
    }
}
