package br.ufg.inf.Utils;

/**
 * Permite a criação de retorno de tuplas
 *
 * @param <X> the generic type
 * @param <Y> the generic type
 */
public class Pair<X, Y> {

    /** The x. */
    private X x;
    
    /** The y. */
    private Y y;

    /**
     * Instantiates a new pair.
     *
     * @param x the x
     * @param y the y
     */
    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiates a new pair.
     */
    public Pair() {

    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public X getX() {
        return x;
    }

    /**
     * Sets the x.
     *
     * @param x the new x
     */
    public void setX(X x) {
        this.x = x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public Y getY() {
        return y;
    }

    /**
     * Sets the y.
     *
     * @param y the new y
     */
    public void setY(Y y) {
        this.y = y;
    }

}
