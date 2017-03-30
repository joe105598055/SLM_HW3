package tw.teddysoft.bdd.domain.invoice;

/**
 * Created by teddy on 2017/3/9.
 */
public class InvoiceCalculator {

    public static int getVAT(int taxIncludedPrice,double vatRate) {

        return taxIncludedPrice - getTaxExcludedPrice(taxIncludedPrice,vatRate);
    }

    public static int getTaxExcludedPrice(int taxIncludedPrice,double vatRate) {
        return (int) Math.round(taxIncludedPrice / (1 + vatRate));
    }
}
