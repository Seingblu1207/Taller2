/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtmatriz_proyecto;

import java.lang.Math;

public class ImplementacionMatriz implements Matriz{
    
    private int filas;
    private int columnas; 
    private int[][] matriz;
    
    public ImplementacionMatriz(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
        llenar_matriz();
    }
    
    private void llenar_matriz(){
        int max = 10, min = 0, range = max-min+1;
        for (byte b = 0; b < getFilas(); b++) {
            for (byte c = 0; c < getColumnas(); c++) {
                matriz[b][c] = (int)(Math.random()*range)+min;
            }
        }
    }
    
    public boolean equals(Object matriz){
        if(!(matriz instanceof Matriz))
            return false;
        if(!(filas == ((Matriz)matriz).getFilas() && columnas == ((Matriz)matriz).getColumnas()))
            return false;
        for (byte b = 0; b < filas; b++) {
            for (byte c = 0; c < columnas; c++) {
                if(!(this.matriz[b][c] == ((Matriz)matriz).getMatriz()[b][c])){
                    return false;
                }
            }
        }
        return true;
    }
    
    public String toString(){
        String retorno = "";
        for (byte b = 0; b < filas; b++) {
//            if(b==0)
//                retorno += "[";
            for (byte c = 0; c < columnas; c++) {
                if(b == filas-1 && c == columnas-1)
                    retorno += matriz[b][c];
                else
                    retorno += matriz[b][c]+", ";
            }
            retorno += "\n"; 
        }
        return retorno;
    }
    
    @Override
    public ImplementacionMatriz Suma(Matriz matriz2) throws Exception {
        if(!(this.filas == matriz2.getFilas() && this.columnas == matriz2.getColumnas())){
            throw new Exception("El tamaño de ambas matrices debe ser igual");
        }
        if(!(matriz2 instanceof Matriz)){
            throw new Exception("El objeto no es un ADTMatriz");
        }
        ImplementacionMatriz resultado = new ImplementacionMatriz(filas,columnas);
        for (byte b = 0; b < filas; b++) {
            for (byte c = 0; c < columnas; c++) {
                resultado.matriz[b][c] = (this.matriz[b][c]+matriz2.getMatriz()[b][c]);
            }
        }
        return resultado;
    }

    @Override
    public ImplementacionMatriz Producto(Matriz matriz2) throws Exception {
        if(!(this.columnas == matriz2.getFilas())){
            throw new Exception("El numero de columnas de la primera matriz debe ser igual al numero de filas de la segunda matriz");
        }
        if(!(matriz2 instanceof Matriz)){
            throw new Exception("El objeto no es un ADTMatriz");
        }
        ImplementacionMatriz resultado = new ImplementacionMatriz(filas,matriz2.getColumnas());
        for (byte b = 0; b < filas; b++) {
            for (byte c = 0; c < matriz2.getColumnas(); c++) {
                int suma=0;
                for (byte d = 0; d < columnas; d++) {
                    suma += matriz[b][d]*matriz2.getMatriz()[d][c];
                }
                resultado.matriz[b][c] = suma;
            }
        }
        return resultado;
    }
    
    @Override
    public ImplementacionMatriz Potencia(double k) throws Exception{
        if(filas != columnas)
            throw new Exception("La matriz debe ser cuadrada");
        if(!(filas > 1))
            throw new Exception("La matriz debe ser almenos de 2x2");
        if(!(k>=0))
            throw new Exception("La potencia debe ser un numero natural");
        if(k==1)
            return this;
        ImplementacionMatriz resultado;
        resultado = this.Producto(this);
        if(k==2)
            return resultado;
        for (byte b = 2; b < k; b++) {
            resultado = resultado.Producto(this);
        }
        return resultado;
    }
    
    @Override
    public int hashIDs() {
        String ID = "462237454176";
        return ID.hashCode()%5;
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
        try {
            
            Matriz m = new ImplementacionMatriz(3,3);
            System.out.println(m.hashIDs());
            Matriz n = new ImplementacionMatriz(3,3);
            System.out.println(m);
            System.out.println(n);
//            System.out.println(m.producto(n));
//            System.out.println((m.suma(n)).toString());
//            System.out.println(m.Potencia(0).toString());
            assert(m.Potencia(2)==m.Producto(n));
        }
        catch (Exception Error) {
            System.out.println("Se presento un error: \n" + Error);
        }
    }
    
}
