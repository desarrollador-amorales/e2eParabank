package parabank.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class MultipleClicksOnSameElement implements Task {
    private final Target target;
    private final int times;

    public MultipleClicksOnSameElement(Target target, int times) {
        this.target = target;
        this.times = times;
    }

    public static MultipleClicksOnSameElement on(Target target, int times) {
        return new MultipleClicksOnSameElement(target, times);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < times; i++) {
            actor.attemptsTo(Click.on(target));
        }
    }
}
