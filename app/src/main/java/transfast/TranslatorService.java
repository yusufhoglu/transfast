package transfast;

public class TranslatorService {

    private final Translator translator;

    public TranslatorService(Translator translator) {
        this.translator = translator;
    }

    public String translate(String text) {
        return this.translator.translate(text);
    }
}
