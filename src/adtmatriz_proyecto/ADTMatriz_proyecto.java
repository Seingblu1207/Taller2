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
    private double[][] matriz;
    
    public ADTMatriz_proyecto(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matriz = new double[filas][columnas];
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
    public ADTMatriz_proyecto Eliminacion_Gausiana() throws Exception{
        /*
        Metodo compatible solo con funciones AxA.
        Se supondra que los valores estan ordenados, ej:
        a0X0, b0X1, c0X2 = d0     [a0 b0 c0 d0
        a1X0, b1X1, c1X2 = d1 -->  a1 b1 c1 d1
        a2X0, b2X1, c2X2 = d2      a2 b2 c2 d2]
        */
        if(!(filas >=2 && columnas>=2))
            throw new Exception("La matriz debe ser mayor o igual a 2x2");
        double[][] resultado = this.getMatriz();
        //int[] resultados = new int[columnas];
        byte pivot = 0;
        
        ADTMatriz_proyecto r = new ADTMatriz_proyecto(filas,columnas);
        r.setMatriz(resultado);
        return r;
    }
    
    @Override
    public int hashIDs() {
        String ID = "454176";
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
    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public double[][] getMatriz() {
        return matriz;
    }
    
    public static void main(String[] args) {
        try {
            
            Matriz m = new ADTMatriz_proyecto(3,3);
            System.out.println(m.hashIDs());
            Matriz n = new ADTMatriz_proyecto(3,3);
            System.out.println(m.toString());
//            System.out.println(n.toString());
//            System.out.println((m.suma(n)).toString());
            System.out.println(m.Eliminacion_Gausiana().toString());
        }
        catch (Exception Error) {
            System.out.println("Se presento un error: \n" + Error);
        }
    }
    
}
