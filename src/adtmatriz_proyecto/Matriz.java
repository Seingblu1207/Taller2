package adtmatriz_proyecto;

public interface Matriz{
    
    ImplementacionMatriz Suma(Matriz matriz) throws Exception;
    
    ImplementacionMatriz Producto(Matriz matriz) throws Exception;
    
    ImplementacionMatriz Potencia(double k) throws Exception;
    
    String toString();
    
    boolean equals(Matriz matriz) throws Exception;

    int hashIDs();
    
    int getFilas();

    int getColumnas();
    
    public void setMatriz(int[][] matriz);
    
    public int[][] getMatriz();
    
}
