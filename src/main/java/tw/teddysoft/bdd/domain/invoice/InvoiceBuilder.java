package tw.teddysoft.bdd.domain.invoice;

/**
 * Created by teddy on 2017/3/9.
 */
public class InvoiceBuilder {

    private double vatRate = 0.0;
    private int taxIncludedPrice = 0;
   private  int taxExcludedPrice=0;
    private InvoiceBuilder(){}

    public static InvoiceBuilder newInstance(){
        return new InvoiceBuilder();
    }

    public InvoiceBuilder withVatRate(double vatRate) {
        this.vatRate = vatRate;
        return this;
    }

    public InvoiceBuilder withTaxIncludedPrice(int taxIncludedPrice) {
        this.taxIncludedPrice = taxIncludedPrice;
        this.taxExcludedPrice = 0;
        return this;
    }

    public Invoice issue() {
        if(taxIncludedPrice==0 && taxExcludedPrice!=0) {
            taxIncludedPrice =(int) Math.round(taxExcludedPrice * (1 + vatRate));
        }
        return new Invoice(taxIncludedPrice, vatRate,
                InvoiceCalculator.getTaxExcludedPrice(taxIncludedPrice, vatRate)
                , InvoiceCalculator.getVAT(taxIncludedPrice, vatRate));
    }

    public InvoiceBuilder withTaxExcludedPrice(Integer taxExcludedPrice) {
        this.taxExcludedPrice=taxExcludedPrice;
        this.taxIncludedPrice = 0;
        return this;
    }
}
