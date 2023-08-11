package dev.Generics.challenge;

import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable>{
    private final List<T> elements;

    public Layer(T[] layerElements) {
        this.elements = new ArrayList<T>(List.of(layerElements));
    }

    @SafeVarargs
    public final void addElements(T... ts){
        elements.addAll(List.of(ts));
    }

    public void renderLayer(){
        for (T element : elements){
            element.render();
        }
    }
}
