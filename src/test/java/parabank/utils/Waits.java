package parabank.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public final class Waits {
    private Waits() { }

    public static void untilVisible(Actor actor, Target target) {
        actor.attemptsTo(WaitUntil.the((net.serenitybdd.screenplay.targets.Target) target, isVisible()).forNoMoreThan(5).seconds());
    }
}
