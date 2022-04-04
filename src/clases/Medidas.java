/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author PRIDE OMEGA
 */
public class Medidas {
    
    private int iD_Medida;
    private int iD_Paciente;
    private int iMC;
    private int iMM;
    private int peso;
    private int cintura;
    private int brazo;
    private int estatura;
    
    public Medidas(int id_M,int id_p,int imc,int imm,int p,int cin,int br,int est){
        this.iD_Medida = id_M;
        this.iD_Paciente = id_p;
        this.iMC = imc;
        this.iMM = imm;
        this.peso = p;
        this.cintura = cin;
        this.brazo = br;
        this.estatura = est;
    }
    public Medidas(){
        
    }

    public int getiD_Paciente() {
        return iD_Paciente;
    }

    public int getiMC() {
        return iMC;
    }

    public int getiMM() {
        return iMM;
    }
    
    public int getBrazo() {
        return brazo;
    }

    public int getCintura() {
        return cintura;
    }

    public int getEstatura() {
        return estatura;
    }

    public int getPeso() {
        return peso;
    }

    public int getiD_Medida() {
        return iD_Medida;
    }

    public void setBrazo(int brazo) {
        this.brazo = brazo;
    }

    public void setCintura(int cintura) {
        this.cintura = cintura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setiD_Medida(int iD_Medida) {
        this.iD_Medida = iD_Medida;
    }

    public void setiD_Paciente(int iD_Paciente) {
        this.iD_Paciente = iD_Paciente;
    }

    public void setiMC(int iMC) {
        this.iMC = iMC;
    }

    public void setiMM(int iMM) {
        this.iMM = iMM;
    }
    

    @Override
    public String toString() {
        return "Medida ["
                +iD_Medida+ ", "
                +iD_Paciente+ ", "
                +iMC+ ", "
                +iMM+ ", "
                +peso+ ", "
                +cintura+ ", "
                +brazo+ ", "
                +estatura+"]";
    }
    
    
    
    
}
