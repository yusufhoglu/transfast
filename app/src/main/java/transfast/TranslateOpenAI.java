package transfast;

public class TranslateOpenAI implements Translator {
    private final String apiKey;

    public TranslateOpenAI(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String translate(String text) {
        return "translated text";
    }
}
