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
            throw new Exception("El tamaño de ambas matrices debe ser igual");
        }
        if(!(matriz2 instanceof Matriz)){
            throw new Exception("El objeto no es un ADTMatriz");
        }
        ADTMatriz_proyecto resultado = new ADTMatriz_proyecto(filas,columnas);
        for (byte b = 0; b < filas; b++) {
            for (byte c = 0; c < columnas; c++) {
                resultado.matriz[b][c] = (this.matriz[b][c]+matriz2.getMatriz()[b][c]);
            }
        }
        return resultado;
    }

    @Override
    public ADTMatriz_proyecto producto(Matriz matriz2) throws Exception {
        if(!(this.columnas == matriz2.getFilas())){
            throw new Exception("El numero de columnas de la primera matriz debe ser igual al numero de filas de la segunda matriz");
        }
        if(!(matriz2 instanceof Matriz)){
            throw new Exception("El objeto no es un ADTMatriz");
        }
        ADTMatriz_proyecto resultado = new ADTMatriz_proyecto(filas,matriz2.getColumnas());
        int suma=0;
        for (byte b = 0; b < filas; b++) {
            for (byte c = 0; c < matriz2.getColumnas(); c++) {
                for (byte d = 0; d < columnas; d++) {
                    suma += matriz[b][d]*matriz2.getMatriz()[d][c];
                }
                resultado.matriz[b][c] = suma;
            }
        }
        return resultado;
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

    @Override
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public int[][] getMatriz() {
        return matriz;
    }
    
    public static void main(String[] args) {
        
    }
    
}
