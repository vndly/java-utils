package com.mauriciotogneri.javautils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.joda.time.DateTime;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Json
{
    private static final Gson gson = new Gson();

    public static Gson create(Boolean prettyPrint)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter());
        builder.registerTypeAdapterFactory(new EnumAdapterFactory());

        if (prettyPrint)
        {
            builder.setPrettyPrinting();
            builder.disableHtmlEscaping();
        }

        return builder.create();
    }

    public static Gson create()
    {
        return create(false);
    }

    public static <T> T object(String string, Class<T> type)
    {
        return gson.fromJson(string, type);
    }

    public static <T> T object(JsonElement json, Class<T> type)
    {
        return gson.fromJson(json, type);
    }

    public static <T> T object(Map<?, ?> map, Class<T> type)
    {
        return object(gson.toJson(map), type);
    }

    public static <T> T object(String json, Type type)
    {
        return gson.fromJson(json, type);
    }

    public static String json(Object object)
    {
        return gson.toJson(object);
    }

    public static JsonObject jsonObject(Object object)
    {
        return jsonObject(json(object));
    }

    public static JsonObject jsonObject(String string)
    {
        JsonParser parser = new JsonParser();

        return parser.parse(string).getAsJsonObject();
    }

    public static <A, B extends JsonToObject<A>> List<A> list(B[] list)
    {
        List<A> result = new ArrayList<>();

        if (list != null)
        {
            for (B json : list)
            {
                result.add(json.object());
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public static <A, B extends JsonToObject<A>> A[] array(B[] list, Class<A> clazz)
    {
        List<A> newList = list(list);

        A[] result = (A[]) Array.newInstance(clazz, list.length);
        newList.toArray(result);

        return result;
    }

    public interface JsonToObject<T>
    {
        T object();
    }

    private static class DateTimeTypeAdapter implements JsonSerializer<DateTime>, JsonDeserializer<DateTime>
    {
        private final FormattedDateTime formatter = new FormattedDateTime();

        @Override
        public JsonElement serialize(DateTime dateTime, Type type, JsonSerializationContext context)
        {
            return new JsonPrimitive(formatter.date(dateTime, Locale.getDefault()));
        }

        @Override
        public DateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException
        {
            try
            {
                return formatter.date(jsonElement.getAsString());
            }
            catch (Exception e)
            {
                throw new RuntimeException(String.format("Error parsing date: %s", jsonElement.getAsString()));
            }
        }
    }

    private static class EnumAdapterFactory implements TypeAdapterFactory
    {
        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
        {
            Class<? super T> rawType = typeToken.getRawType();

            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class)
            {
                return null;
            }

            if (!rawType.isEnum())
            {
                rawType = rawType.getSuperclass();
            }

            return (TypeAdapter<T>) new EnumTypeAdapter(rawType);
        }
    }

    public static class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T>
    {
        private final Class<T> classOfT;
        private final Map<String, T> nameToConstant = new HashMap<>();
        private final Map<T, String> constantToName = new HashMap<>();

        public EnumTypeAdapter(Class<T> classOfT)
        {
            try
            {
                this.classOfT = classOfT;

                for (T constant : classOfT.getEnumConstants())
                {
                    String name = constant.name();
                    SerializedName annotation = classOfT.getField(name).getAnnotation(SerializedName.class);

                    if (annotation != null)
                    {
                        name = annotation.value();
                    }

                    nameToConstant.put(name, constant);
                    constantToName.put(constant, name);
                }
            }
            catch (NoSuchFieldException e)
            {
                throw new AssertionError();
            }
        }

        public T read(JsonReader in) throws IOException
        {
            if (in.peek() == JsonToken.NULL)
            {
                in.nextNull();
                return null;
            }

            String value = in.nextString();

            T result = nameToConstant.get(value);

            if (result == null)
            {
                throw new RuntimeException(String.format("Invalid enum value '%s' for type '%s'", value, classOfT.getName()));
            }

            return result;
        }

        public void write(JsonWriter out, T value) throws IOException
        {
            out.value(value == null ? null : constantToName.get(value));
        }
    }
}