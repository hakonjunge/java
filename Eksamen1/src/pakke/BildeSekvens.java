package pakke;

import java.util.List;

public class BildeSekvens extends Spillbar {
    private List<Integer> varigheter;

    public BildeSekvens(String navn, List<Integer> varigheter) {
        super(navn, sum(varigheter));
        this.varigheter = varigheter;
    }

    public int getVarighet() {
        return sum(varigheter);
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}