package StreamAPI;

public class OpenClosed {
    double tax(String type, double sum){
        if (type.equals("6")) return sum * 0.06;
        if (type.equals("15")) return sum * 0.15;
        return 0;
    }
}

interface TaxStrategy { double cals(double sum);}

class Tax6 implements TaxStrategy {
    public double cals(double sum){
        return sum * 0.06;
    }
}
class Tax15 implements TaxStrategy{
    public double cals(double sum) {
        return sum * 0.15;
    }
}
