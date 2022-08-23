/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtmatriz_proyecto;

import java.lang.Math;

public class ADTMatriz_proyecto implements Matriz{
    
    private int filas;
    private int columnas; 
    private int[][] matriz = new int[filas][columnas];
    
    public ADTMatriz_proyecto(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
    }
    
    public void llenar_matriz(){
        int max = 20, min = 0, range = max-min+1;
        for (byte b = 0; b < getFilas(); b++) {
            for (byte c = 0; c < getColumnas(); c++) {
                matriz[b][c] = (int)(Math.random()*range)+min;
            }
        }
    }
    
    
    @Override
    public ADTMatriz_proyecto suma(Matriz matriz2) throws Exception {
        if(!(this.filas == matriz2.getFilas() && this.columnas == matriz2.getColumnas())){
            throw new Exception("The size of both matrix should be equals, Openenglish");
        }
        if(!(matriz2 instanceof Matriz)){
            throw new Exception("The object isn't a matrix type");
        }
        ADTMatriz_proyecto resultado = new ADTMatriz_proyecto(filas,columnas);
        for (byte b = 0; b < filas; b++) {
            for (byte c = 0; c < columnas; c++) {
                resultado.matriz[b][c] = (this.getMatriz()[b][c]+matriz2.[b][c]);
            }
        }
        return resultado;
    }

    @Override
    public ADTMatriz_proyecto producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashIDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getFilas() {
        return filas;
    }

    @Override
    public int getColumnas() {
        return columnas;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }
    
    
}
