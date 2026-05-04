public interface IMeasurable {

    double getConversionFactor();

    double toBase(double value);

    double fromBase(double baseValue);

    String getUnitName();
}