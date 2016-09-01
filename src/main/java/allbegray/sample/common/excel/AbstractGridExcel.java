package allbegray.sample.common.excel;

public abstract class AbstractGridExcel<T> extends AbstractSinglePageExcel {

    public AbstractGridExcel() {
        super();
        this.header();
    }

    protected abstract void header();

    public abstract void addItem(T item);

}
