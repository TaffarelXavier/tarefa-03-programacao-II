/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class ComboItem {

    private int value;
    private String label;

    public ComboItem(int value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
