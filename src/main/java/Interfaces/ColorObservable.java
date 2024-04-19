
package Interfaces;
import Interfaces.ColorObserver;
import java.awt.*;
/**
 *
 * @author ASUS
 */
public interface ColorObservable {
   
    void addObserver(ColorObserver observer);
    void removeObserver(ColorObserver observer);
    void notifyColorChange(Color newStartColor, Color newEndColor);
}
