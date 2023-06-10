/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_danielelvir;

/**
 *
 * @author HP
 */
class Libro {
    private String nombre;
    private String autor;
    private int año;  
    
    public Libro(String nombreN, String autorN, int añoN){
        this.nombre=nombreN;
        this.autor=autorN;
        this.año=añoN;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public int getAño(){
        return this.año;
    }
    
     public void setNombre(String nuevoNom){
        this.nombre=nuevoNom;
    }
    
    public void setAutor(String nuevoAut){
        this.autor=nuevoAut;
    }
    
    public void setAño(int nuevoAño){
        this.año=nuevoAño;
    }
    
}
