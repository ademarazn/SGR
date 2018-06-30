package Action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Aluno
 */
public class Refazer extends AbstractAction{
    
    private UndoManager manager;

    public Refazer(UndoManager manager){
        this.manager = manager;
     }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            manager.redo();
        }catch (CannotRedoException e){
          Toolkit.getDefaultToolkit().beep();
        }
    }
    
    
}
