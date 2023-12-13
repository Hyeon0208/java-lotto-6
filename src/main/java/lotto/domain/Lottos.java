package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int purchaseCount) {
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(new Lotto(getSortedList(numberGenerator.generateNumberList())));
        }
        return new Lottos(lottos);
    }

    private static List<Integer> getSortedList(List<Integer> randomNumbers) {
        List<Integer> copyList = new ArrayList<>(randomNumbers);
        Collections.sort(copyList);
        return copyList;
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Integer> getLottoNumberBy(int index) {
        return lottos.get(index).getNumbers();
    }

    public Lotto getLottoBy(int index) {
        return lottos.get(index);
    }
}
