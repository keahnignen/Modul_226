/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafikeditor;

/**
 *
 * @author vmadmin
 */
public class FigurFileDAOStub implements grafikeditor.FigurDAO {

    private String[] testFiguren = {
        "Rechteck 10 30 60 90"
    };
    public FigurFileDAOStub() {
        
    }
    private int currentFigur = 0;
    @Override
    public String[] readNextFigurData() {
        if(currentFigur < testFiguren.length){
        String[] figurData = testFiguren[currentFigur].split("\\s");
        currentFigur++;
        return figurData;
        }
        return null;
    }
    
}
