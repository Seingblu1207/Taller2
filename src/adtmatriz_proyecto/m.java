/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtmatriz_proyecto;
import adtmatriz_proyecto.ADTMatriz_proyecto;

public class m {
    public static void main(String[] args) {
        try {
            
            Matriz m = new ADTMatriz_proyecto(6,6);
            System.out.println(m.hashIDs());
            
            
        } catch (Exception Error) {
            System.out.println("Se presento un error: \n" + Error);
        } finally {
            System.out.println("Fin de la ejecucion.");
        }
    }
}
