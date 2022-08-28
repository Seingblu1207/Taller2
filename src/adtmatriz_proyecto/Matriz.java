package adtmatriz_proyecto;

public interface Matriz{
    
    ADTMatriz_proyecto suma(Matriz matriz) throws Exception;
    
    ADTMatriz_proyecto producto(Matriz matriz) throws Exception;
    
    ADTMatriz_proyecto Eliminacion_Gausiana() throws Exception;

    int hashIDs();
    
    int getFilas();

    int getColumnas();
    
    public void setMatriz(double[][] matriz);
    
    public double[][] getMatriz();
    
}
