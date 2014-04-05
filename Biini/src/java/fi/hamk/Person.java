/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.hamk;

/**
 *
 * @author fotakkihe
 */
public class Person {
    private String etunimi;
    private String sukunimi;
    private int ika;

    public Person() {
        this.etunimi = "Kalle";
        this.sukunimi = "Kehveli";
        this.ika = 40;
    }
    
    public Person(String etunimi, String sukunimi, int ika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
    }

    /**
     * @return the etunimi
     */
    public String getEtunimi() {
        return etunimi;
    }

    /**
     * @param etunimi the etunimi to set
     */
    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    /**
     * @return the sukunimi
     */
    public String getSukunimi() {
        return sukunimi;
    }

    /**
     * @param sukunimi the sukunimi to set
     */
    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    /**
     * @return the ika
     */
    public int getIka() {
        return ika;
    }

    /**
     * @param ika the ika to set
     */
    public void setIka(int ika) {
        this.ika = ika;
    }
    
}
