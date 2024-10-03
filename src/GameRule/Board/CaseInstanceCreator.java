package GameRule.Board;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CaseInstanceCreator implements InstanceCreator<Case> {
    private final Case case;

    public CaseInstanceCreator(Case case) {
        this.case = case;
    }

    public Case createInstance(Type type) {
        return case;
    }
}
